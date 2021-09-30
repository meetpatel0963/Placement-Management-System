from grpc_service.protobuf import articleService_pb2_grpc
from grpc_service.protobuf.articleService_pb2 import *
from google.protobuf.json_format import ParseDict
import grpc
from concurrent.futures import ThreadPoolExecutor
from grpc_service.sql_app import database
from grpc_service.sql_app.crud import article as crud
from dynaconf import settings
from py_zipkin.zipkin import zipkin_span, create_http_headers_for_new_span, ZipkinAttrs, Kind, zipkin_client_span
from py_zipkin.request_helpers import create_http_headers
from py_zipkin.encoding import Encoding
import requests


class ArticleServiceServicer(articleService_pb2_grpc.ArticleServiceServicer):
     def __init__(self):
          self.sess = database.SessionLocal()
          print("initialized session")
     
     
     def default_handler(self,encoded_span):
          body = encoded_span

          return requests.post(
               "{}/api/v2/spans".format(settings.get_fresh('ZIPKIN_SERVER')),
               data=body,
               headers={'Content-Type': 'application/json'},
          )
          
     
     def cast_time(self,ob):
          ob.createdAt = str(ob.createdAt)
          ob.updatedAt = str(ob.updatedAt)
          return ob
          
     
     def getAllArticles(self, request, context):
          with zipkin_span(
               service_name='article-service-grpc',
               span_name='read-all-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               articles = crud.get_all_articles(db=self.sess)
               resp = GetAllArticlesResponse()
               
               for i in articles:
                    k = self.cast_time(i)
                    related = (ParseDict(k.__dict__,Article(),ignore_unknown_fields=True))
                    #print('here')
                    # try:
                    #      print(type(i.__getattribute__('comments')))
                    # except:
                    #      print('error')
                    for j in k.comments:
                         k = self.cast_time(j)
                         related.comments.append(ParseDict(k.__dict__,Comment(), ignore_unknown_fields=True)) 
                    resp.articles.append(related)
               self.sess.close()
               return resp
     
     def getArticleById(self, request, context):
          with zipkin_span(
               service_name='article-service-grpc',
               span_name='read-unique-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = GetArticleByIdResponse()
               article = crud.get_article(article_id=request.articleId, db=self.sess)
               try:
                    article = self.cast_time(article)
                    ParseDict(article.__dict__,resp.article,ignore_unknown_fields=True)
                    for j in article.comments:
                         k = self.cast_time(j)
                         resp.article.comments.append(ParseDict(k.__dict__,Comment(), ignore_unknown_fields=True))
               except:
                    pass
               finally:
                    self.sess.close()
                    return resp
     
     def saveArticle(self, request, context):
          with zipkin_span(
               service_name='article-service-grpc',
               span_name='create-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = SaveArticleResponse()
               try:
                    msg_id = crud.create_article(db=self.sess, article=request.article)
               except:
                    resp.message = "Couldn't save it"
               else:
                    if(msg_id != -1):
                         resp.message = "Success"
                         resp.articleId = msg_id
                    else:
                         resp.message = "Couldn't save it"
               return resp
     
     def deleteArticle(self, request, context):
          with zipkin_span(
               service_name='article-service-grpc',
               span_name='delete-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = DeleteArticleResponse()
               msg = crud.delete_article(db=self.sess, article_id=request.articleId)
               resp.message = msg
               return resp


     def updateArticle(self, request, context):
          with zipkin_span(
               service_name='article-service-grpc',
               span_name='update-call',
               port=int(settings.get_fresh('REST_PORT')),
               sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
               encoding=Encoding.V2_JSON,
               transport_handler=self.default_handler
          ):
               resp = UpdateArticleResponse()
               msg = crud.update_article(article=request.article, db=self.sess)
               resp.message = msg['message']
               return resp


     
