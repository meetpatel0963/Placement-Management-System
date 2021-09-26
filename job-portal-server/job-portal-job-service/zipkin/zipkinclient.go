package zipkinclient

import (
	"job_service/config"

	"github.com/openzipkin/zipkin-go"
	"github.com/openzipkin/zipkin-go/model"
	reporterhttp "github.com/openzipkin/zipkin-go/reporter/http"
	"github.com/spf13/viper"
)

func NewTracer() (*zipkin.Tracer, error) {
	reporter := reporterhttp.NewReporter(viper.GetString("zipkin_endpoint_url"))

	localEndpoint := &model.Endpoint{ServiceName: config.APPLICATION_NAME, Port: uint16(viper.GetInt("server_port"))}

	sampler, err := zipkin.NewCountingSampler(viper.GetFloat64("zipkin_sampler_probability"))
	if err != nil {
		return nil, err
	}
	
	tracer, err := zipkin.NewTracer(
		reporter,
		zipkin.WithSampler(sampler),
		zipkin.WithLocalEndpoint(localEndpoint),
	)
	if err != nil {
		return nil, err
	}

	return tracer, err
}