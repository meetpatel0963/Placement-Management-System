package configclient

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	"github.com/spf13/viper"
)

// load config properties from given branch
func LoadConfigurationFromBranch(configserverurl string, appname string, profile string, branch string) {
	url := fmt.Sprintf("%s/%s/%s/%s", configserverurl, appname, profile, branch)
	fmt.Printf("loading config from %s\n", url)
	body, err := FetchConfiguration(url)
	if err != nil {
			panic("couldn't load configuration, cannot start. terminating. error: " + err.Error())
	}
	ParseConfiguration(body)
}

// make http request to fetch configuration from config server
func FetchConfiguration(url string) ([]byte, error) {
	resp, err := http.Get(url)
	if err != nil {
			panic("couldn't load configuration, cannot start. terminating. error: " + err.Error())
	}
	body, err := ioutil.ReadAll(resp.Body)
	return body, err
}

// pass json bytes into struct and then into viper
func ParseConfiguration(body []byte) {
	var cloudconfig springCloudConfig
	err := json.Unmarshal(body, &cloudconfig)
	if err != nil {
			panic("cannot parse configuration, message: " + err.Error())
	}

	for key, value := range cloudconfig.PropertySources[0].Source {
			viper.Set(key, value)
			fmt.Printf("loading config property %v => %v\n", key, value)
	}
	if viper.IsSet("server_name") {
			fmt.Printf("successfully loaded configuration for service %s\n", viper.GetString("server_name"))
	}
}

// structs having same structure as response from spring cloud config
type springCloudConfig struct {
	Name            string           `json:"name"`
	Profiles        []string         `json:"profiles"`
	Label           string           `json:"label"`
	Version         string           `json:"version"`
	PropertySources []propertySource `json:"propertysources"`
}

type propertySource struct {
	Name   string                 `json:"name"`
	Source map[string]interface{} `json:"source"`
}