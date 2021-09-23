package main

import (
	"context"
	"log"
	"net"
	"net/http"

	"job_service/config"
	"job_service/database"
	proto "job_service/proto"
	"job_service/service"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"google.golang.org/grpc"
)

func main() {
	database.SetupDBConnection()

	go func() {
		mux := runtime.NewServeMux()

		proto.RegisterJobServiceHandlerServer(context.Background(), mux, service.JobServer{})

		log.Fatalln(http.ListenAndServe("localhost" + config.REST_PORT, mux))
	}()
	
	grpcServer := grpc.NewServer()
	proto.RegisterJobServiceServer(grpcServer, service.JobServer{})
	listener, err := net.Listen("tcp", config.GRPC_PORT)
	
	if err != nil {
		log.Fatal("Error creating listener: ", err.Error())
	}

	grpcServer.Serve(listener)
}