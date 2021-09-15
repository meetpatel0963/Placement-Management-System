from typing import List, Optional

from fastapi import Depends, FastAPI, HTTPException
from sqlalchemy.orm import Session
from datetime import datetime
from grpc_service.sql_app import crud, models, schemas
from grpc_service.sql_app.database import SessionLocal, engine

from pydantic import BaseModel

class ID(BaseModel):
    id: Optional[int] = 0
    message: Optional[str] = ""

models.Base.metadata.create_all(bind=engine)

app = FastAPI()


# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@app.post("/article", response_model=ID)
def create_article(article: schemas.ArticleCreate, db: Session = Depends(get_db)):
    resp = ID()
    try:
        resp.id = crud.create_article(db=db, article=article)
    except:
        resp.message = "Unable to Save"
    else:
        resp.message = "Success"
    return resp

@app.get("/articles", response_model=List[schemas.Article])
def read_articles(db:Session = Depends(get_db)):
    articles = crud.get_all_articles(db=db)
    return articles

@app.get("/article/{article_id}", response_model=schemas.Article)
def read_article(article_id: int, db: Session = Depends(get_db)):
    article = crud.get_article(db=db, article_id=article_id)
    if article is None:
        raise HTTPException(status_code=404, detail="Article not found")
    return article

@app.put("/article", response_model=ID)
def update_article(article: schemas.ArticleUpdate, db: Session = Depends(get_db)):
    return crud.update_article(article=article, db=db)

@app.delete("/article/{article_id}")
def delete_article(article_id: int, db: Session = Depends(get_db)):
    return {
        'message': crud.delete_article(article_id=article_id, db=db)
    }
