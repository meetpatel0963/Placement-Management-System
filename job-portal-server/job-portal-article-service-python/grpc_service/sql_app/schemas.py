import datetime
from typing import List, Optional
from datetime import datetime as timestamp

from pydantic import BaseModel
from sqlalchemy.sql.expression import update

class CommentBase(BaseModel):
    author: str
    body: str
    article_id: int

class CommentCreate(CommentBase):
    pass

class Comment(CommentBase):
    upvotes: int
    downvotes: int
    creation_date: timestamp
    updation_date: timestamp
    id: int

    class Config:
        orm_mode = True

class ArticleBase(BaseModel):
    title: str
    body: str
    author: str
    company: str

class ArticleCreate(ArticleBase):
    pass

class ArticleUpdate(ArticleBase):
    id: int
    upvotes: Optional[int] = 0
    downvotes: Optional[int] = 0
    title: Optional[str] = None
    body: Optional[str] = None
    company: Optional[str] = None
    author: Optional[str] = None

class Article(ArticleBase):
    id: int
    upvotes: int
    downvotes: int
    comments: List[Comment] = []
    creation_time: Optional[timestamp]
    updation_time: Optional[timestamp]

    class Config:
        orm_mode = True