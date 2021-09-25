package service

import (
	"context"
	"fmt"

	"job_service/database"
	proto "job_service/proto"

	"github.com/spf13/viper"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

type JobServer struct {
	proto.UnimplementedJobServiceServer
}

func protoToStruct(job *proto.Job) database.Job {
	_job := database.Job{
		CompanyName:           job.GetCompanyName(),
		EligibleStreams:       job.GetEligibleStreams(),
		JobDescription:        job.GetJobDescription(),
		StartDate:             job.GetStartDate(),
		EndDate:               job.GetEndDate(),
		LPA:                   job.GetLpa(),
		NumberOfRegistrations: job.GetNumberOfRegistrations(),
	}

	return _job
}

func structToProto(job database.Job) *proto.Job {
	_job := proto.Job{
		Id:                    job.Id,
		CompanyName:           job.CompanyName,
		EligibleStreams:       job.EligibleStreams,
		JobDescription:        job.JobDescription,
		StartDate:             job.StartDate,
		EndDate:               job.EndDate,
		Lpa:                   job.LPA,
		NumberOfRegistrations: job.NumberOfRegistrations,
	}

	return &_job
}

func (JobServer) SaveJob(ctx context.Context, r *proto.SaveJobRequest) (*proto.SaveJobResponse, error) {
	job := protoToStruct(r.GetJob())
	err := database.SaveJob(job)

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't save the job. Try Again!")
	}

	return &proto.SaveJobResponse{Message: "Job saved successfully!"}, nil
}

func (JobServer) GetAllJobs(ctx context.Context, r *proto.GetAllJobsRequest) (*proto.GetAllJobsResponse, error) {
	jobs, err := database.GetAllJobs()

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't fetch the jobs. Try Again!")
	}

	var _jobs []*proto.Job
	for _, job := range jobs {
		_jobs = append(_jobs, structToProto(job))
	}
	
	return &proto.GetAllJobsResponse{ Jobs: _jobs }, nil
}

func (JobServer) GetJobById(ctx context.Context, r *proto.GetJobByIdRequest) (*proto.GetJobByIdResponse, error) {
	job, err := database.GetJobById(r.GetJobId())
	
	if err != nil {
		return nil, status.Error(codes.NotFound, "No job exists with given Id!")
	}

	return &proto.GetJobByIdResponse{Job: structToProto(job)}, nil
}

func (JobServer) GetJobByCompanyName(ctx context.Context, r *proto.GetJobByCompanyNameRequest) (*proto.GetJobByCompanyNameResponse, error) {
	job, err := database.GetJobByCompanyName(r.GetCompanyName())
	
	if err != nil {
		return nil, status.Error(codes.NotFound, "No job exists with given Id!")
	}

	return &proto.GetJobByCompanyNameResponse{Job: structToProto(job)}, nil
}

func (JobServer) UpdateJob(ctx context.Context, r *proto.UpdateJobRequest) (*proto.UpdateJobResponse, error) {
	job := protoToStruct(r.GetJob())
	job.Id = r.GetJob().GetId()
	err := database.UpdateJob(job)

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't update the job. Maybe no job exists with given id. Try Again!")
	}

	return &proto.UpdateJobResponse{Message: "Job updated successfully!"}, nil
}

func (JobServer) DeleteJob(ctx context.Context, r *proto.DeleteJobRequest) (*proto.DeleteJobResponse, error) {
	err := database.DeleteJob(r.GetJobId())
	
	fmt.Println(err)

	if err != nil {
		return nil, status.Error(codes.NotFound, "No job exists with given Id!")
	}

	return &proto.DeleteJobResponse{Message: "Job deleted successfully!"}, nil
}

func (JobServer) GetJobByStartDate(ctx context.Context, r *proto.GetJobByStartDateRequest) (*proto.GetJobByStartDateResponse, error) {
	return &proto.GetJobByStartDateResponse{}, nil
}

func (JobServer) GetJobByEndDate(ctx context.Context, r *proto.GetJobByEndDateRequest) (*proto.GetJobByEndDateResponse, error) {
	return &proto.GetJobByEndDateResponse{}, nil
}

func (JobServer) GetJobByStream(ctx context.Context, r *proto.GetJobByStreamRequest) (*proto.GetJobByStreamResponse, error) {
	return &proto.GetJobByStreamResponse{}, nil
}

func (JobServer) GetProjectName(ctx context.Context, r *proto.GetProjectNameRequest) (*proto.GetProjectNameResponse, error) {
	return &proto.GetProjectNameResponse{ ProjectName: viper.GetString("project.name")}, nil
}
