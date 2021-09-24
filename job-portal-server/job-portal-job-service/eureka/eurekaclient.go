package eureka

import (
	"fmt"
	"job_service/config"
	"log"
	"os"
	"time"

	"github.com/hudl/fargo"
	"github.com/spf13/viper"
)


var (
	instance fargo.Instance
	conn fargo.EurekaConnection
)

func Register() {
	conn = fargo.NewConn(viper.GetString("registry_url"))

	// hostname acts as an InstanceId
	hostname, err := os.Hostname()

	if err != nil {
		log.Fatal(err);
	}

	instance = fargo.Instance{
		HostName: hostname,
		App: config.APPLICATION_NAME,
		IPAddr: viper.GetString("ip_address"),
		VipAddress: config.APPLICATION_NAME,
		SecureVipAddress: config.APPLICATION_NAME,
		Status: fargo.UP,
		Port: viper.GetInt("server_port"),
		PortEnabled: true,
		SecurePort: 443,
		SecurePortEnabled: true,	
		HealthCheckUrl: "http://localhost"+ viper.GetString("grpc_port") + "/health",
		StatusPageUrl: "http://localhost"+ viper.GetString("grpc_port") + "/info",
		HomePageUrl: "http://localhost"+ viper.GetString("grpc_port"),
		DataCenterInfo: fargo.DataCenterInfo{Class: "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
											 Name: "MyOwn"},
		LeaseInfo: fargo.LeaseInfo{
			RenewalIntervalInSecs: viper.GetInt32("lease_renewal_interval_in_secs"),
			DurationInSecs: viper.GetInt32("lease_duration_in_secs"),
		},
	}
	
	conn.RegisterInstance(&instance)
}

func Deregister() {
	conn.DeregisterInstance(&instance)
}

func SendHeartbeats() {
	go func() {
		for {
			fmt.Println("Sending a heartbeat...")
			err := conn.HeartBeatInstance(&instance)
			if err != nil {
				log.Fatal(err)
			}
			<-time.After(time.Duration(viper.GetInt("heartbeat_interval")) * time.Second)
		}
	}()
}

func UpdateApp() {
	app, err := conn.GetApp("JOB-SERVICE")
	
	for err != nil {
		app, err = conn.GetApp("JOB-SERVICE")
	}

	fmt.Println(app);

	go func() {
		conn.UpdateApp(app)
		for {
			for _, ins := range app.Instances {
				fmt.Printf("%s, ", ins.HostName)
			}
			fmt.Println(len(app.Instances))
			
			<-time.After(10 * time.Second)
		}
	}()
}