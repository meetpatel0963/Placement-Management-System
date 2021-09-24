package eureka

import (
	"fmt"
	"job_service/config"
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
	conn = fargo.NewConn(config.REGISTRY_URL)

	// hostname acts as an InstanceId
	hostname, err := os.Hostname()

	if err != nil {
		log.Fatal(err);
	}

	instance = fargo.Instance{
		HostName: hostname,
		App: config.APPLICATION_NAME,
		IPAddr: config.IP_ADDR,
		VipAddress: config.APPLICATION_NAME,
		SecureVipAddress: config.APPLICATION_NAME,
		Status: fargo.UP,
		Port: config.PORT,
		PortEnabled: true,
		SecurePort: 443,
		SecurePortEnabled: true,	
		HealthCheckUrl: "http://localhost"+ config.GRPC_PORT + "/health",
		StatusPageUrl: "http://localhost"+ config.GRPC_PORT + "/info",
		HomePageUrl: "http://localhost"+ config.GRPC_PORT,
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
			<-time.After(config.HEARTBEAT_INTERVAL * time.Second)
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