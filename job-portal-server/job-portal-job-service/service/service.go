package service

import (
	"context"
	"fmt"

	"job_service/config"
	"job_service/database"
	proto "job_service/proto"
	placement_service "job_service/proto/placement_service"

	"github.com/spf13/viper"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

type JobServer struct {
	proto.UnimplementedJobServiceServer
}

func protoToStructEntry(entry *proto.StudentJobEntry) database.StudentJobEntry {
	_entry := database.StudentJobEntry{
		JobID: entry.GetJobId(),
		StudentID: entry.GetStudentId(),
	}

	return _entry;
}

func structToProtoEntry(entry database.StudentJobEntry) *proto.StudentJobEntry {
	_entry := proto.StudentJobEntry{
		JobId: entry.JobID,
		StudentId: entry.StudentID,
	}

	return &_entry;
}

func protoToStructJob(job *proto.Job) database.Job {
	_job := database.Job{
		CompanyId:             job.GetCompanyId(),
		EligibleStreams:       job.GetEligibleStreams(),
		JobDescription:        job.GetJobDescription(),
		StartDate:             job.GetStartDate(),
		EndDate:               job.GetEndDate(),
		LPA:                   job.GetLpa(),
		NumberOfRegistrations: job.GetNumberOfRegistrations(),
	}

	return _job
}

func structToProtoJob(job database.Job) *proto.Job {
	_job := proto.Job{
		Id:                    job.Id,
		CompanyId:             job.CompanyId,
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
	conn, err := grpc.Dial(config.PLACEMENT_SERVICE_SERVER_URL, grpc.WithInsecure())
	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't save the job. Try Again!")
	}

	client := placement_service.NewCompanyServiceClient(conn)
	_, err = client.GetCompanyById(context.Background(), &placement_service.GetCompanyByIdRequest{ CompanyId: r.GetJob().GetCompanyId() })

	if err != nil {
		return nil, status.Error(codes.InvalidArgument, "Invalid company Id. Try Again!")
	}
	
	job := protoToStructJob(r.GetJob())
	err = database.SaveJob(job)

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
		_jobs = append(_jobs, structToProtoJob(job))
	}
	
	return &proto.GetAllJobsResponse{Jobs: _jobs}, nil
}

func (JobServer) GetJobById(ctx context.Context, r *proto.GetJobByIdRequest) (*proto.GetJobByIdResponse, error) {
	job, err := database.GetJobById(r.GetJobId())

	if err != nil {
		return nil, status.Error(codes.NotFound, "No job exists with given Id!")
	}

	return &proto.GetJobByIdResponse{Job: structToProtoJob(job)}, nil
}

func (JobServer) GetJobByCompanyId(ctx context.Context, r *proto.GetJobByCompanyIdRequest) (*proto.GetJobByCompanyIdResponse, error) {
	job, err := database.GetJobByCompanyId(r.GetCompanyId())

	if err != nil {
		return nil, status.Error(codes.NotFound, "No job exists for given company Id!")
	}

	return &proto.GetJobByCompanyIdResponse{Job: structToProtoJob(job)}, nil
}

func (JobServer) UpdateJob(ctx context.Context, r *proto.UpdateJobRequest) (*proto.UpdateJobResponse, error) {
	job := protoToStructJob(r.GetJob())
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
	jobs, err := database.GetJobByStartDate(r.GetStartDate())

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't fetch the jobs. Try Again!")
	}

	var _jobs []*proto.Job
	for _, job := range jobs {
		_jobs = append(_jobs, structToProtoJob(job))
	}

	return &proto.GetJobByStartDateResponse{Jobs: _jobs}, nil
}

func (JobServer) GetJobByEndDate(ctx context.Context, r *proto.GetJobByEndDateRequest) (*proto.GetJobByEndDateResponse, error) {
	jobs, err := database.GetJobByEndDate(r.GetEndDate())

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't fetch the jobs. Try Again!")
	}

	var _jobs []*proto.Job
	for _, job := range jobs {
		_jobs = append(_jobs, structToProtoJob(job))
	}

	return &proto.GetJobByEndDateResponse{Jobs: _jobs}, nil
}

func (JobServer) GetJobByStream(ctx context.Context, r *proto.GetJobByStreamRequest) (*proto.GetJobByStreamResponse, error) {

	jobs, err := database.GetJobByStream(r.GetStream())

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't fetch the jobs. Try Again!")
	}

	var _jobs []*proto.Job
	for _, job := range jobs {
		_jobs = append(_jobs, structToProtoJob(job))
	}

	return &proto.GetJobByStreamResponse{Jobs: _jobs}, nil
}

func (JobServer) RegisterStudentForJob(ctx context.Context, r *proto.RegisterStudentForJobRequest) (*proto.RegisterStudentForJobResponse, error) {
	err := database.RegisterStudentForJob(protoToStructEntry(r.GetStudentJobEntry()))

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't register the student. Try Again!")
	}

	return &proto.RegisterStudentForJobResponse{ Message: "Student registered successfully!" }, nil
}

func (JobServer) GetRegisteredStudentsByJobId(ctx context.Context, r *proto.GetRegisteredStudentsByJobIdRequest) (*proto.GetRegisteredStudentsByJobIdResponse, error) {
	entries, err := database.GetRegisteredStudentsByJobId(r.GetJobId())

	if err != nil {
		return nil, status.Error(codes.Internal, "Couldn't fetch the registration entries. Try Again!")
	}
	
	var _entries []*proto.StudentJobEntry
	for _, entry := range entries {
		_entries = append(_entries, structToProtoEntry(entry))
	}
	
	return &proto.GetRegisteredStudentsByJobIdResponse{ StudentJobEntries: _entries }, nil
}

func (JobServer) GetProjectName(ctx context.Context, r *proto.GetProjectNameRequest) (*proto.GetProjectNameResponse, error) {
	return &proto.GetProjectNameResponse{ ProjectName: viper.GetString("project.name")}, nil
}

