package main

import (
	"context"
	"log"
	"net"

	"google.golang.org/grpc"
	proto "job-portal.com/job_service/proto"
)

type jobServer struct{
	proto.UnimplementedJobServiceServer
}

func (jobServer) SaveJob(ctx context.Context, r *proto.SaveJobRequest) (*proto.SaveJobResponse, error) {
	return &proto.SaveJobResponse{}, nil
}

func (jobServer) GetAllJobs(ctx context.Context, r *proto.GetAllJobsRequest) (*proto.GetAllJobsResponse, error) {
	return &proto.GetAllJobsResponse{}, nil
}

func (jobServer) GetJobById(ctx context.Context, r *proto.GetJobByIdRequest) (*proto.GetJobByIdResponse, error) {
	return &proto.GetJobByIdResponse{}, nil
}

func (jobServer) GetJobByCompanyName(ctx context.Context, r *proto.GetJobByCompanyNameRequest) (*proto.GetJobByCompanyNameResponse, error) {
	return &proto.GetJobByCompanyNameResponse{}, nil
}

func (jobServer) UpdateJob(ctx context.Context, r *proto.UpdateJobRequest) (*proto.UpdateJobResponse, error) {
	return &proto.UpdateJobResponse{}, nil
}

func (jobServer) DeleteJob(ctx context.Context, r *proto.DeleteJobRequest) (*proto.DeleteJobResponse, error) {
	return &proto.DeleteJobResponse{}, nil
}

func main() {
	server := grpc.NewServer()
	proto.RegisterJobServiceServer(server, jobServer{})
	listener, err := net.Listen("tcp", ":9090")

	if err != nil {
		log.Fatal("Error creating listener: ", err.Error())
	}

	server.Serve(listener)
}