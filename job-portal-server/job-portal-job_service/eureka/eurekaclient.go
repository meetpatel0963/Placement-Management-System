package eureka

import (
	"fmt"
	"log"
	"os"
	"time"

	"github.com/hudl/fargo"
)


var (
	instance fargo.Instance
	conn fargo.EurekaConnection
)

func Register() {
	conn = fargo.NewConn("http://localhost:8761/eureka")

	// hostname acts as an InstanceId
	hostname, err := os.Hostname()

	if err != nil {
		log.Fatal(err);
	}

	instance = fargo.Instance{
		HostName: hostname,
		App: "job-service",
		IPAddr: "127.0.0.1",
		VipAddress: "job-service",
		SecureVipAddress: "job-service",
		Status: fargo.UP,
		Port: 9090,
		PortEnabled: true,
		SecurePort: 443,
		SecurePortEnabled: true,	
		HealthCheckUrl: "http://localhost:9090/health",
		StatusPageUrl: "http://localhost:9090/info",
		HomePageUrl: "http://localhost:9090",
		DataCenterInfo: fargo.DataCenterInfo{Class: "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
											 Name: "MyOwn"},
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
			<-time.After(30 * time.Second)
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