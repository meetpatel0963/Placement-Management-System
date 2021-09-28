from typing import List, Optional
from py_zipkin.zipkin import zipkin_span, create_http_headers_for_new_span, ZipkinAttrs, Kind, zipkin_client_span
from py_zipkin.request_helpers import create_http_headers
from py_zipkin.encoding import Encoding
from fastapi import Depends, APIRouter, HTTPException
from sqlalchemy.orm import Session
from datetime import datetime
from grpc_service.sql_app import models, schemas
from grpc_service.sql_app.crud import article as crud
from grpc_service.sql_app.database import SessionLocal, engine
import requests
from dynaconf import settings


from pydantic import BaseModel

class ID(BaseModel):
    id: Optional[int] = 0
    message: Optional[str] = ""

models.Base.metadata.create_all(bind=engine)


# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter()

def default_handler(encoded_span):
    body = encoded_span

    return requests.post(
        "{}/api/v2/spans".format(settings.get_fresh('ZIPKIN_SERVER')),
        data=body,
        headers={'Content-Type': 'application/json'},
    )



@router.post("/articles", response_model=ID)
def create_article(article: schemas.ArticleCreate, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='article-service',
        span_name='create-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        resp = ID()
        try:
            resp.id = crud.create_article(db=db, article=article)
        except:
            resp.message = "Unable to Save"
        else:
            resp.message = "Success"
        return resp

@router.get("/articles", response_model=List[schemas.Article])
def read_articles(db:Session = Depends(get_db)):
    with zipkin_span(
        service_name='article-service',
        span_name='read-all-call',
        port=8001,
        sample_rate=100,
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        articles = crud.get_all_articles(db=db)
        return articles

@router.get("/articles/{article_id}", response_model=schemas.Article)
def read_article(article_id: int, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='article-service',
        span_name='read-unique-call',
        port=8001,
        sample_rate=100,
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        article = crud.get_article(db=db, article_id=article_id)
        if article is None:
            raise HTTPException(status_code=404, detail="Article not found")
        return article

@router.put("/articles", response_model=ID)
def update_article(article: schemas.ArticleUpdate, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='article-service',
        span_name='update-call',
        port=8001,
        sample_rate=100,
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        return crud.update_article(article=article, db=db)

@router.delete("/articles/{article_id}")
def delete_article(article_id: int, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='article-service',
        span_name='delete-call',
        port=8001,
        sample_rate=100,
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        return {
            'message': crud.delete_article(article_id=article_id, db=db)
        }