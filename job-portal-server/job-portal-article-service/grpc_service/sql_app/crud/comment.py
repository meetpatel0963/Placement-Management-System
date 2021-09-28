from sqlalchemy.orm import Session
from datetime import date, datetime
from .. import models,schemas

def get_all_comments(db: Session):
    comments =  db.query(models.Comment).all()
    return comments

def get_comment(db:Session, comment_id:int):
    db_comment = db.query(models.Comment).filter(models.Comment.id == comment_id)
    if db_comment is None:
        return None 
    return db_comment.first()

def create_comment(db:Session, comment:schemas.CommentCreate):
    db_comment = models.Comment(
        body = comment.body,
        author = comment.author,
        articleId = comment.articleId,
        createdAt = datetime.now(),
        updatedAt = datetime.now()
    )
    try:
        db.add(db_comment)
        db.commit()
        db.refresh(db_comment)
        return db_comment.id
    except:
        db.rollback()
        return -1

def update_comment(db:Session, comment:schemas.CommentUpdate):
    db_comment = db.query(models.Comment).filter(models.Comment.id == comment.id)
    fetched = db_comment.first()
    if db_comment.first() is None:
        return {'message':"Comment Not Found"}
    else:
        try:
            count = db_comment.update({
                models.Comment.body: comment.body if (comment.body != None) else fetched.body,
                models.Comment.author: comment.author if (comment.author != None) else fetched.author, 
                models.Comment.updatedAt: datetime.now(),
                models.Comment.upvotes: comment.upvotes if (comment.upvotes != None) else fetched.upvoted,
                models.Comment.downvotes: comment.downvotes if (comment.downvotes != None) else fetched.downvotes
            })
            db.commit()
            if count != 0:
                return {
                    'message':"Comment Updated",
                    'id':comment.id
                }
            else:
                return {
                    'message':"Comment Not Updated",
                }
        except:
            db.rollback()
            return {
                'message': "Unable to Update"
            }
    

def delete_comment(comment_id: int, db: Session):
    db_Comment = db.query(models.Comment).filter(models.Comment.id == comment_id)
    if db_Comment.first() is None:
        return "Comment Not Exists"
    db_Comment.delete()
    db.commit()
    return "Comment Deleted"

def get_all_comments_by_article(article_id: int, db:Session):
     db_comments = db.query(models.Comment).filter(models.Comment.articleId == article_id).all()
     return db_comments