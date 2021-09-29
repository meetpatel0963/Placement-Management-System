package server

import (
	"context"
	"log"
	"net"
	"net/http"

	proto "job_service/proto"
	"job_service/service"
	zipkinclient "job_service/zipkin"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"github.com/spf13/viper"
	"google.golang.org/grpc"

	zipkingrpc "github.com/openzipkin/zipkin-go/middleware/grpc"
	zipkinhttp "github.com/openzipkin/zipkin-go/middleware/http"
)

var grpcServer *grpc.Server

func StartServer() {
	mux := runtime.NewServeMux()
	proto.RegisterJobServiceHandlerServer(context.Background(), mux, service.JobServer{})
	
	tracer, err := zipkinclient.NewTracer()
    if err != nil {
      log.Fatal(err)
    }

	http.DefaultClient.Transport, err = zipkinhttp.NewTransport(
        tracer,
        zipkinhttp.TransportTrace(true),
    )
    if err != nil {
      log.Fatal(err)
    }
	
	wrappedMux := zipkinhttp.NewServerMiddleware(tracer, zipkinhttp.SpanName("REST"))(mux)
	
	go func() {
		log.Fatalln(http.ListenAndServe(viper.GetString("rest_port"), wrappedMux))
	}()
	
	grpcServer = grpc.NewServer(grpc.StatsHandler(zipkingrpc.NewServerHandler(tracer)))
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