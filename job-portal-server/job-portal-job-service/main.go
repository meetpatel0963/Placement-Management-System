package main

import (
	"fmt"
	"job_service/database"
	"job_service/eureka"
	"job_service/server"
	"os"
	"os/signal"
	"syscall"
)

func cleanup() {
	fmt.Println("Closing DB Connection...")
	database.CloseConnection()
	fmt.Println("DB Connection closed.")
	
	fmt.Println("Deregistering an instance from eureka...")
	eureka.Deregister()
	fmt.Println("Instance deregistered.")

	fmt.Println("Stopping server gracefully...")
	server.StopServer()
	fmt.Println("Server stopped.")
}

func main() {
	sigs := make(chan os.Signal, 1)
    done := make(chan bool, 1)
	signal.Notify(sigs, syscall.SIGINT, syscall.SIGTERM)
    go func(){
		sig := <-sigs
        fmt.Println(sig)
		cleanup()
        done <- true
	}()
	
	fmt.Println("Connecting to Cassandra...")
	database.SetupDBConnection()
	fmt.Println("Cassandra DB connected.")
	
	fmt.Println("Registering an instance to eureka...")
	eureka.Register()
	fmt.Println("Instance Registered.")
	
	eureka.SendHeartbeats()
	// eureka.UpdateApp()
	
	fmt.Println("Starting server...")
	server.StartServer()
	fmt.Println("Server started.")

	<-done
}
