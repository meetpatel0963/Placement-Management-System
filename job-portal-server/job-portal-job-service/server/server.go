package server

import (
	"context"
	"log"
	"net"
	"net/http"

	"job_service/config"
	proto "job_service/proto"
	"job_service/service"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"google.golang.org/grpc"
)

var grpcServer *grpc.Server

func StartServer() {
	mux := runtime.NewServeMux()
	proto.RegisterJobServiceHandlerServer(context.Background(), mux, service.JobServer{})

	go func() {
		log.Fatalln(http.ListenAndServe("localhost" + config.REST_PORT, mux))
	}()
	
	grpcServer = grpc.NewServer()
	proto.RegisterJobServiceServer(grpcServer, service.JobServer{})
	listener, err := net.Listen("tcp", config.GRPC_PORT)
	
	if err != nil {
		log.Fatal("Error creating listener: ", err.Error())
	}

	go func() {
		log.Fatalln(grpcServer.Serve(listener))
	}()
}

func StopServer() {
	if grpcServer != nil {
		grpcServer.GracefulStop()
	}
}