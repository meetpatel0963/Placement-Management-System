package server

import (
	"context"
	"log"
	"net"
	"net/http"

	proto "job_service/proto"
	"job_service/service"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"github.com/spf13/viper"
	"google.golang.org/grpc"
)

var grpcServer *grpc.Server

func StartServer() {
	mux := runtime.NewServeMux()
	proto.RegisterJobServiceHandlerServer(context.Background(), mux, service.JobServer{})
	
	go func() {
		log.Fatalln(http.ListenAndServe("localhost" + viper.GetString("rest_port"), mux))
	}()
	
	grpcServer = grpc.NewServer()
	proto.RegisterJobServiceServer(grpcServer, service.JobServer{})
	listener, err := net.Listen("tcp", viper.GetString("grpc_port"))
	
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