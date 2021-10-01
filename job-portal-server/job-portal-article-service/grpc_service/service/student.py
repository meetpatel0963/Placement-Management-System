from dynaconf import settings
from grpc_service.protobuf import studentService_pb2_grpc,studentService_pb2
from google.protobuf.descriptor_pool import DescriptorPool
import grpc
from concurrent.futures import ThreadPoolExecutor

channel = grpc.insecure_channel('{}'.format(settings.get_fresh('STUDENT_GRPC_PORT')))
stub = studentService_pb2_grpc.StudentServiceStub(channel)

data = studentService_pb2.GetStudentByIdRequest()
# data.studentId = "6b1b3162-4c7e-45c9-880a-31746e739358"
# print(stub.getStudentById(data).student.personalDetails)

method = stub.getStudentById

studentServicer = {"data": data, "method":method}