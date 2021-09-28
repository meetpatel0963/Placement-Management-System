from typing import List, Optional

from fastapi import Depends, APIRouter, HTTPException
from sqlalchemy.orm import Session
from datetime import datetime
from grpc_service.sql_app import models, schemas
from grpc_service.sql_app.crud import comment as crud
from grpc_service.sql_app.database import SessionLocal, engine
from py_zipkin.zipkin import zipkin_span, create_http_headers_for_new_span, ZipkinAttrs, Kind, zipkin_client_span
from py_zipkin.request_helpers import create_http_headers
from py_zipkin.encoding import Encoding
from pydantic import BaseModel
import requests
from dynaconf import settings


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


@router.get("/comments", response_model=List[schemas.Comment])
def read_comments(db:Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='read-all-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        comments = crud.get_all_comments(db=db)
        return comments

@router.get("/articles/{article_id}/comments", response_model=List[schemas.Comment])
def read_all_comments_by_article_id(article_id: int, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='read-articlewise-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        comments = crud.get_all_comments_by_article(db=db, article_id=article_id)
        return comments

@router.get("/comments/{comment_id}", response_model=schemas.Comment)
def read_comment(comment_id: int, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='read-unique-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        comment = crud.get_comment(db=db, comment_id=comment_id)
        if comment is None:
            raise HTTPException(status_code=404, detail="Comment not found")
        return comment

@router.post("/articles/{article_id}/comments", response_model=ID)
def create_comment(article_id:int, comment: schemas.CommentCreate, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='create-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        comment.articleId = article_id
        resp = ID()
        try:
            resp.id =  crud.create_comment(comment=comment, db=db)
            resp.message = "Success"
        except:
            resp.message = "Couldn't Save it"
        finally:
            return resp
    


@router.put("/articles/{article_id}/comments", response_model=ID)
def update_comment(article_id:int, comment: schemas.CommentUpdate, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='update-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        comment.articleId = article_id
        return crud.update_comment(comment=comment, db=db)

@router.delete("/comments/{comment_id}")
def delete_article(comment_id: int, db: Session = Depends(get_db)):
    with zipkin_span(
        service_name='comment-service',
        span_name='delete-call',
        port=int(settings.get_fresh('REST_PORT')),
        sample_rate=int(settings.get_fresh('SAMPLING_RATE_ZIPKIN')),
        encoding=Encoding.V2_JSON,
        transport_handler=default_handler
    ):
        return {
        'message': crud.delete_comment(comment_id=comment_id, db=db)
        }