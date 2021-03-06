from grpc_service.service import article, comment
from grpc_service.protobuf import articleService_pb2_grpc
# from dotenv import dotenv_values
import grpc
from concurrent.futures import ThreadPoolExecutor
from dynaconf import settings

# config = dict(dotenv_values(".env"))

def serve():
     server = grpc.server(ThreadPoolExecutor(max_workers=10))
     articleService_pb2_grpc.add_ArticleServiceServicer_to_server(
          article.ArticleServiceServicer(),
          server
     )
     articleService_pb2_grpc.add_CommentServiceServicer_to_server(
          comment.CommentServiceServicer(),
          server
     )
     server.add_insecure_port('[::]:{}'.format(settings.get_fresh('GRPC_PORT')))
     server.start()
     server.wait_for_termination()

serve();
print("gRPC Server Started")
