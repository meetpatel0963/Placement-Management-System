from protobuf import articleService_pb2_grpc
from protobuf.articleService_pb2 import *
from google.protobuf.json_format import ParseDict
import grpc
from concurrent.futures import ThreadPoolExecutor
from sql_app import database
from sql_app.crud import article as crud
from dynaconf import settings


class ArticleServiceServicer(articleService_pb2_grpc.ArticleServiceServicer):
     def __init__(self):
          self.sess = database.SessionLocal()
          print("initialized session")
          
     
     def cast_time(self,ob):
          ob.createdAt = str(ob.createdAt)
          ob.updatedAt = str(ob.updatedAt)
          return ob
          
     
     def getAllArticles(self, request, context):
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
          resp = SaveArticleResponse()
          try:
               msg_id = crud.create_article(db=self.sess, article=request.article)
          except:
               resp.message = "Couldn't save it"
          else:
               resp.message = "Success"
               resp.articleId = msg_id
          return resp
     
     def deleteArticle(self, request, context):
          resp = DeleteArticleResponse()
          msg = crud.delete_article(db=self.sess, article_id=request.articleId)
          resp.message = msg
          return resp


     def updateArticle(self, request, context):
          resp = UpdateArticleResponse()
          msg = crud.update_article(article=request.article, db=self.sess)
          resp.message = msg['message']
          return resp


     
