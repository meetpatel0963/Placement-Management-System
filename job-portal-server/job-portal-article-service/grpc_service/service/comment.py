from grpc_service.protobuf import articleService_pb2_grpc
from grpc_service.protobuf.articleService_pb2 import *
import grpc
from google.protobuf.json_format import ParseDict
from concurrent.futures import ThreadPoolExecutor
from grpc_service.sql_app import database
from grpc_service.sql_app.crud import comment as crud
from py_zipkin.zipkin import zipkin_span, create_http_headers_for_new_span, ZipkinAttrs, Kind, zipkin_client_span
from py_zipkin.request_helpers import create_http_headers
from py_zipkin.encoding import Encoding
import requests
from dynaconf import settings

class CommentServiceServicer(articleService_pb2_grpc.CommentServiceServicer):
     def __init__(self):
          self.sess = database.SessionLocal()
          print("Session Initialized")

     def cast_time(self,ob):
          ob.createdAt = str(ob.createdAt)
          ob.updatedAt = str(ob.updatedAt)
          return ob

     def default_handler(self,encoded_span):
          body = encoded_span

          return requests.post(
               "{}/api/v2/spans".format(settings.get_fresh('ZIPKIN_SERVER')),
               data=body,
               headers={'Content-Type': 'application/json'},
          )
          
     def getAllComments(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='read-all-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               comments = crud.get_all_comments(db=self.sess)
               resp = GetAllCommentsResponse()
               try:
                    for i in comments:
                         k = self.cast_time(i)
                         resp.comments.append(ParseDict(k.__dict__, Comment(), ignore_unknown_fields=True))
               except:
                    pass
               finally:
                    self.sess.close()
                    return resp
     
     def getAllCommentsByArticleId(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='read-all-by-article-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               comments = crud.get_all_comments_by_article(article_id=request.articleId, db=self.sess)
               resp = GetAllCommentsByArticleIdResponse()
               try:
                    for i in comments:
                         k = self.cast_time(i)
                         resp.comments.append(ParseDict(k.__dict__, Comment(), ignore_unknown_fields=True))
               except:
                    pass
               finally:
                    self.sess.close()
                    return resp
     
     def getCommentById(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='read-unique-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               comment = crud.get_comment(comment_id=request.commentId, db=self.sess)
               resp = GetCommentByIdResponse()
               try:
                    comment = self.cast_time(comment)
                    ParseDict(comment.__dict__, resp.comment, ignore_unknown_fields=True)
               except:
                    pass
               finally:
                    self.sess.close()
                    return resp


     def saveComment(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='create-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = SaveCommentResponse()
               try:
                    msg = crud.create_comment(comment=request.comment, db=self.sess)
               except:
                    resp.message = "Couldn't save it"
               else:
                    if(msg == -1):
                         resp.message = "Article Doesn't Exists"
                    else:
                         resp.message = "Success"
                         resp.commentId = msg
               return resp

     def deleteComment(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='delete-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = DeleteCommentResponse()
               try:
                    msg = crud.delete_comment(comment_id=request.commentId, db=self.sess)
               except:
                    resp.message = "Coudn't delete it"
               else:
                    resp.message = msg
               return resp


     def updateComment(self, request, context):
          with zipkin_span(
               service_name='comment-service-grpc',
               span_name='update-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = UpdateCommentResponse()
               try:
                    msg = crud.update_comment(comment=request.comment, db=self.sess)
               except:
                    resp.message = "Couldn't save it"
               else:
                    resp.message = msg['message']
               return resp
         

