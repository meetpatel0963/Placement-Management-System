// Code generated by protoc-gen-go-grpc. DO NOT EDIT.

package job_service

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
// Requires gRPC-Go v1.32.0 or later.
const _ = grpc.SupportPackageIsVersion7

// JobServiceClient is the client API for JobService service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type JobServiceClient interface {
	GetAllJobs(ctx context.Context, in *GetAllJobsRequest, opts ...grpc.CallOption) (*GetAllJobsResponse, error)
	GetJobById(ctx context.Context, in *GetJobByIdRequest, opts ...grpc.CallOption) (*GetJobByIdResponse, error)
	SaveJob(ctx context.Context, in *SaveJobRequest, opts ...grpc.CallOption) (*SaveJobResponse, error)
	UpdateJob(ctx context.Context, in *UpdateJobRequest, opts ...grpc.CallOption) (*UpdateJobResponse, error)
	DeleteJob(ctx context.Context, in *DeleteJobRequest, opts ...grpc.CallOption) (*DeleteJobResponse, error)
	GetJobByCompanyId(ctx context.Context, in *GetJobByCompanyIdRequest, opts ...grpc.CallOption) (*GetJobByCompanyIdResponse, error)
	GetJobByStartDate(ctx context.Context, in *GetJobByStartDateRequest, opts ...grpc.CallOption) (*GetJobByStartDateResponse, error)
	GetJobByEndDate(ctx context.Context, in *GetJobByEndDateRequest, opts ...grpc.CallOption) (*GetJobByEndDateResponse, error)
	GetJobByStream(ctx context.Context, in *GetJobByStreamRequest, opts ...grpc.CallOption) (*GetJobByStreamResponse, error)
	GetProjectName(ctx context.Context, in *GetProjectNameRequest, opts ...grpc.CallOption) (*GetProjectNameResponse, error)
	RegisterStudentForJob(ctx context.Context, in *RegisterStudentForJobRequest, opts ...grpc.CallOption) (*RegisterStudentForJobResponse, error)
	GetRegisteredStudentsByJobId(ctx context.Context, in *GetRegisteredStudentsByJobIdRequest, opts ...grpc.CallOption) (*GetRegisteredStudentsByJobIdResponse, error)
}

type jobServiceClient struct {
	cc grpc.ClientConnInterface
}

func NewJobServiceClient(cc grpc.ClientConnInterface) JobServiceClient {
	return &jobServiceClient{cc}
}

func (c *jobServiceClient) GetAllJobs(ctx context.Context, in *GetAllJobsRequest, opts ...grpc.CallOption) (*GetAllJobsResponse, error) {
	out := new(GetAllJobsResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getAllJobs", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetJobById(ctx context.Context, in *GetJobByIdRequest, opts ...grpc.CallOption) (*GetJobByIdResponse, error) {
	out := new(GetJobByIdResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getJobById", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) SaveJob(ctx context.Context, in *SaveJobRequest, opts ...grpc.CallOption) (*SaveJobResponse, error) {
	out := new(SaveJobResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/saveJob", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) UpdateJob(ctx context.Context, in *UpdateJobRequest, opts ...grpc.CallOption) (*UpdateJobResponse, error) {
	out := new(UpdateJobResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/updateJob", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) DeleteJob(ctx context.Context, in *DeleteJobRequest, opts ...grpc.CallOption) (*DeleteJobResponse, error) {
	out := new(DeleteJobResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/deleteJob", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetJobByCompanyId(ctx context.Context, in *GetJobByCompanyIdRequest, opts ...grpc.CallOption) (*GetJobByCompanyIdResponse, error) {
	out := new(GetJobByCompanyIdResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getJobByCompanyId", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetJobByStartDate(ctx context.Context, in *GetJobByStartDateRequest, opts ...grpc.CallOption) (*GetJobByStartDateResponse, error) {
	out := new(GetJobByStartDateResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getJobByStartDate", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetJobByEndDate(ctx context.Context, in *GetJobByEndDateRequest, opts ...grpc.CallOption) (*GetJobByEndDateResponse, error) {
	out := new(GetJobByEndDateResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getJobByEndDate", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetJobByStream(ctx context.Context, in *GetJobByStreamRequest, opts ...grpc.CallOption) (*GetJobByStreamResponse, error) {
	out := new(GetJobByStreamResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getJobByStream", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetProjectName(ctx context.Context, in *GetProjectNameRequest, opts ...grpc.CallOption) (*GetProjectNameResponse, error) {
	out := new(GetProjectNameResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getProjectName", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) RegisterStudentForJob(ctx context.Context, in *RegisterStudentForJobRequest, opts ...grpc.CallOption) (*RegisterStudentForJobResponse, error) {
	out := new(RegisterStudentForJobResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/registerStudentForJob", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *jobServiceClient) GetRegisteredStudentsByJobId(ctx context.Context, in *GetRegisteredStudentsByJobIdRequest, opts ...grpc.CallOption) (*GetRegisteredStudentsByJobIdResponse, error) {
	out := new(GetRegisteredStudentsByJobIdResponse)
	err := c.cc.Invoke(ctx, "/com.jobportal.jobserviceproto.JobService/getRegisteredStudentsByJobId", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// JobServiceServer is the server API for JobService service.
// All implementations must embed UnimplementedJobServiceServer
// for forward compatibility
type JobServiceServer interface {
	GetAllJobs(context.Context, *GetAllJobsRequest) (*GetAllJobsResponse, error)
	GetJobById(context.Context, *GetJobByIdRequest) (*GetJobByIdResponse, error)
	SaveJob(context.Context, *SaveJobRequest) (*SaveJobResponse, error)
	UpdateJob(context.Context, *UpdateJobRequest) (*UpdateJobResponse, error)
	DeleteJob(context.Context, *DeleteJobRequest) (*DeleteJobResponse, error)
	GetJobByCompanyId(context.Context, *GetJobByCompanyIdRequest) (*GetJobByCompanyIdResponse, error)
	GetJobByStartDate(context.Context, *GetJobByStartDateRequest) (*GetJobByStartDateResponse, error)
	GetJobByEndDate(context.Context, *GetJobByEndDateRequest) (*GetJobByEndDateResponse, error)
	GetJobByStream(context.Context, *GetJobByStreamRequest) (*GetJobByStreamResponse, error)
	GetProjectName(context.Context, *GetProjectNameRequest) (*GetProjectNameResponse, error)
	RegisterStudentForJob(context.Context, *RegisterStudentForJobRequest) (*RegisterStudentForJobResponse, error)
	GetRegisteredStudentsByJobId(context.Context, *GetRegisteredStudentsByJobIdRequest) (*GetRegisteredStudentsByJobIdResponse, error)
	mustEmbedUnimplementedJobServiceServer()
}

// UnimplementedJobServiceServer must be embedded to have forward compatible implementations.
type UnimplementedJobServiceServer struct {
}

func (UnimplementedJobServiceServer) GetAllJobs(context.Context, *GetAllJobsRequest) (*GetAllJobsResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetAllJobs not implemented")
}
func (UnimplementedJobServiceServer) GetJobById(context.Context, *GetJobByIdRequest) (*GetJobByIdResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetJobById not implemented")
}
func (UnimplementedJobServiceServer) SaveJob(context.Context, *SaveJobRequest) (*SaveJobResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method SaveJob not implemented")
}
func (UnimplementedJobServiceServer) UpdateJob(context.Context, *UpdateJobRequest) (*UpdateJobResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method UpdateJob not implemented")
}
func (UnimplementedJobServiceServer) DeleteJob(context.Context, *DeleteJobRequest) (*DeleteJobResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method DeleteJob not implemented")
}
func (UnimplementedJobServiceServer) GetJobByCompanyId(context.Context, *GetJobByCompanyIdRequest) (*GetJobByCompanyIdResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetJobByCompanyId not implemented")
}
func (UnimplementedJobServiceServer) GetJobByStartDate(context.Context, *GetJobByStartDateRequest) (*GetJobByStartDateResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetJobByStartDate not implemented")
}
func (UnimplementedJobServiceServer) GetJobByEndDate(context.Context, *GetJobByEndDateRequest) (*GetJobByEndDateResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetJobByEndDate not implemented")
}
func (UnimplementedJobServiceServer) GetJobByStream(context.Context, *GetJobByStreamRequest) (*GetJobByStreamResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetJobByStream not implemented")
}
func (UnimplementedJobServiceServer) GetProjectName(context.Context, *GetProjectNameRequest) (*GetProjectNameResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetProjectName not implemented")
}
func (UnimplementedJobServiceServer) RegisterStudentForJob(context.Context, *RegisterStudentForJobRequest) (*RegisterStudentForJobResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method RegisterStudentForJob not implemented")
}
func (UnimplementedJobServiceServer) GetRegisteredStudentsByJobId(context.Context, *GetRegisteredStudentsByJobIdRequest) (*GetRegisteredStudentsByJobIdResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetRegisteredStudentsByJobId not implemented")
}
func (UnimplementedJobServiceServer) mustEmbedUnimplementedJobServiceServer() {}

// UnsafeJobServiceServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to JobServiceServer will
// result in compilation errors.
type UnsafeJobServiceServer interface {
	mustEmbedUnimplementedJobServiceServer()
}

func RegisterJobServiceServer(s grpc.ServiceRegistrar, srv JobServiceServer) {
	s.RegisterService(&JobService_ServiceDesc, srv)
}

func _JobService_GetAllJobs_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetAllJobsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetAllJobs(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getAllJobs",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetAllJobs(ctx, req.(*GetAllJobsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetJobById_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetJobByIdRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetJobById(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getJobById",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetJobById(ctx, req.(*GetJobByIdRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_SaveJob_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(SaveJobRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).SaveJob(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/saveJob",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).SaveJob(ctx, req.(*SaveJobRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_UpdateJob_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(UpdateJobRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).UpdateJob(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/updateJob",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).UpdateJob(ctx, req.(*UpdateJobRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_DeleteJob_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(DeleteJobRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).DeleteJob(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/deleteJob",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).DeleteJob(ctx, req.(*DeleteJobRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetJobByCompanyId_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetJobByCompanyIdRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetJobByCompanyId(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getJobByCompanyId",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetJobByCompanyId(ctx, req.(*GetJobByCompanyIdRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetJobByStartDate_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetJobByStartDateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetJobByStartDate(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getJobByStartDate",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetJobByStartDate(ctx, req.(*GetJobByStartDateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetJobByEndDate_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetJobByEndDateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetJobByEndDate(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getJobByEndDate",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetJobByEndDate(ctx, req.(*GetJobByEndDateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetJobByStream_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetJobByStreamRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetJobByStream(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getJobByStream",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetJobByStream(ctx, req.(*GetJobByStreamRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetProjectName_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetProjectNameRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetProjectName(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getProjectName",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetProjectName(ctx, req.(*GetProjectNameRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_RegisterStudentForJob_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(RegisterStudentForJobRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).RegisterStudentForJob(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/registerStudentForJob",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).RegisterStudentForJob(ctx, req.(*RegisterStudentForJobRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _JobService_GetRegisteredStudentsByJobId_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetRegisteredStudentsByJobIdRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(JobServiceServer).GetRegisteredStudentsByJobId(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.jobportal.jobserviceproto.JobService/getRegisteredStudentsByJobId",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(JobServiceServer).GetRegisteredStudentsByJobId(ctx, req.(*GetRegisteredStudentsByJobIdRequest))
	}
	return interceptor(ctx, in, info, handler)
}

// JobService_ServiceDesc is the grpc.ServiceDesc for JobService service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var JobService_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "com.jobportal.jobserviceproto.JobService",
	HandlerType: (*JobServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "getAllJobs",
			Handler:    _JobService_GetAllJobs_Handler,
		},
		{
			MethodName: "getJobById",
			Handler:    _JobService_GetJobById_Handler,
		},
		{
			MethodName: "saveJob",
			Handler:    _JobService_SaveJob_Handler,
		},
		{
			MethodName: "updateJob",
			Handler:    _JobService_UpdateJob_Handler,
		},
		{
			MethodName: "deleteJob",
			Handler:    _JobService_DeleteJob_Handler,
		},
		{
			MethodName: "getJobByCompanyId",
			Handler:    _JobService_GetJobByCompanyId_Handler,
		},
		{
			MethodName: "getJobByStartDate",
			Handler:    _JobService_GetJobByStartDate_Handler,
		},
		{
			MethodName: "getJobByEndDate",
			Handler:    _JobService_GetJobByEndDate_Handler,
		},
		{
			MethodName: "getJobByStream",
			Handler:    _JobService_GetJobByStream_Handler,
		},
		{
			MethodName: "getProjectName",
			Handler:    _JobService_GetProjectName_Handler,
		},
		{
			MethodName: "registerStudentForJob",
			Handler:    _JobService_RegisterStudentForJob_Handler,
		},
		{
			MethodName: "getRegisteredStudentsByJobId",
			Handler:    _JobService_GetRegisteredStudentsByJobId_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "jobService.proto",
}
