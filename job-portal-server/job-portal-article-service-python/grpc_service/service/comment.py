from protobuf import articleService_pb2_grpc
from protobuf.articleService_pb2 import *
import grpc
from google.protobuf.json_format import ParseDict
from concurrent.futures import ThreadPoolExecutor
from sql_app import crud, database

class CommentServiceServicer(articleService_pb2_grpc.CommentServiceServicer):
     def __init__(self):
          self.sess = database.SessionLocal()
          print("Session Initialized")
          
     def getAllComments(self, request, context):
          comments = self.fetchAll()
          resp = GetAllCommentsResponse()
          for i in comments:
               comment = resp.comments.add()
               for key,value in i.items():
                   comment.key = value
          return resp
     
     def getAllCommentsByArticleId(self, request, context):
         return self.fetchByArticleId(request.articleId)
     
     def getCommentById(self, request, context):
         return self.fetchByCommentId(request.commentId)

     def saveComment(self, request, context):
          resp = SaveCommentResponse()
          try:
               msg = self.save(request.article)
          except:
               resp.message = "Couldn't save it"
          else:
               resp.message = "Success"
               resp.commentId = msg.id
          return resp

     def deleteComment(self, request, context):
          resp = DeleteCommentResponse()
          try:
               msg = self.delete(request.commentId)
          except:
               resp.message = "Coudn't delete it"
          else:
               resp.message = "Success"
          return resp


     def updateArticle(self, request, context):
          resp = UpdateCommentResponse()
          try:
              msg = self.update(request.comment)
          except:
               resp.message = "Countn't save it"
          else:
               resp.message = "Success"
         

class ArticleServiceServicer(articleService_pb2_grpc.ArticleServiceServicer):
     def getAllArticles(self, request, context):
          articles = self.fetchAll()
          resp = GetAllArticlesResponse()
          for i in articles:
              article = resp.articles.add()
              for key,value in i.items():
                   article.key = value
          return resp
     
     def getAllArticles(self, request, context):
          article = self.fetchById(request.articleId)
          return article
     
     def saveArticle(self, request, context):
          resp = SaveArticleResponse()
          try:
               msg = self.save(request.article)
          except:
               resp.message = "Couldn't save it"
          else:
               resp.message = "Success"
               resp.articleId = msg.id
          return resp
     
     def deleteArticle(self, request, context):
          resp = DeleteArticleResponse()
          try:
               msg = self.delete(request.articleId)
          except:
               resp.message = "Coudn't delete it"
          else:
               resp.message = "Success"
          return resp


     def updateArticle(self, request, context):
          resp = UpdateArticleResponse()
          try:
              msg = self.update(request.article)
          except:
               resp.message = "Countn't save it"
          else:
               resp.message = "Success"
     


     
