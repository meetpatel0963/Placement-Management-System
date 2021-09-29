from sqlalchemy.orm import Session, joinedload
from datetime import date, datetime
from .. import models,schemas
from dynaconf import settings
from grpc_service.service.student import studentServicer

obj = studentServicer["data"]
studentFinder = studentServicer["method"]

def get_all_articles(db: Session):
    return db.query(models.Article).all()

def get_article(db:Session, article_id:int):
    db_article = db.query(models.Article).filter(models.Article.id == article_id)
    if db_article is None:
        return None 
    return db_article.first()

def create_article(db:Session, article:schemas.ArticleCreate):
    obj.studentId = article.studentId
    found = studentFinder(obj)
    # print(found.error,"here")
    if(found.student):
        pass
    
    author = found.student.personalDetails.firstName + " " + found.student.personalDetails.lastName

    db_article = models.Article(
        title = article.title,
        body = article.body,
        author = author,
        company = article.company,
        createdAt = datetime.now(),
        updatedAt = datetime.now()
    )
    try:
        db.add(db_article)
        db.commit()
        db.refresh(db_article)
        return db_article.id
    except:
        return -1

def update_article(db:Session, article:schemas.ArticleUpdate):
    db_article = db.query(models.Article).filter(models.Article.id == article.id)
    fetched = db_article.first()
    if db_article.first() is None:
        return {'message':"Article Not Found"}
    else:
        try:
            count = db_article.update({
                models.Article.title: article.title if (article.title != None) else fetched.title,
                models.Article.body: article.body if (article.body != None) else fetched.body,
                models.Article.company: article.company if (article.company != None) else fetched.company,
                models.Article.updatedAt: datetime.now(),
                models.Article.upvotes: article.upvotes if (article.upvotes != None) else fetched.upvoted,
                models.Article.downvotes: article.downvotes if (article.downvotes != None) else fetched.downvotes
            })
            db.commit()
            if count != 0:
                return {
                    'message':"Article Updated",
                    'id':article.id
                }
        except:
            pass
        return {
                    'message':"Article Not Updated",
                }


def delete_article(article_id: int, db: Session):
    db_article = db.query(models.Article).filter(models.Article.id == article_id)
    if db_article.first() is None:
        return "Article Not Exists"
    db_article.delete()
    db.commit()
    return "Article Deleted"