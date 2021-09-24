from protobuf import articleService_pb2_grpc
from protobuf.articleService_pb2 import *
import grpc
from google.protobuf.json_format import ParseDict
from concurrent.futures import ThreadPoolExecutor
from sql_app import database
from sql_app.crud import comment as crud

class CommentServiceServicer(articleService_pb2_grpc.CommentServiceServicer):
     def __init__(self):
          self.sess = database.SessionLocal()
          print("Session Initialized")

     def cast_time(self,ob):
          ob.createdAt = str(ob.createdAt)
          ob.updatedAt = str(ob.updatedAt)
          return ob
          
     def getAllComments(self, request, context):
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
          resp = SaveCommentResponse()
          try:
               msg = crud.create_comment(comment=request.comment, db=self.sess)
          except:
               resp.message = "Couldn't save it"
          else:
               resp.message = "Success"
               resp.commentId = msg
          return resp

     def deleteComment(self, request, context):
          resp = DeleteCommentResponse()
          try:
               msg = crud.delete_comment(comment_id=request.commentId, db=self.sess)
          except:
               resp.message = "Coudn't delete it"
          else:
               resp.message = msg
          return resp


     def updateComment(self, request, context):
          resp = UpdateCommentResponse()
          try:
              msg = crud.update_comment(comment=request.comment, db=self.sess)
          except:
               resp.message = "Couldn't save it"
          else:
               resp.message = msg['message']
          return resp
         

