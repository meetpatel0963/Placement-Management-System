from sqlalchemy import Boolean, Column, ForeignKey, Integer, String, DateTime
from sqlalchemy.orm import backref, relationship
from sqlalchemy.sql.expression import null

from .database import Base


class Article(Base):
    __tablename__ = "articles"

    id = Column(Integer, primary_key=True, index=True)
    title = Column(String, index=True, nullable=False)
    body = Column(String,nullable=False)
    author = Column(String)
    company = Column(String, default=0)
    upvotes = Column(Integer, default=0)
    downvotes = Column(Integer, default=0)
    createdAt = Column(DateTime,default=None)
    updatedAt = Column(DateTime,default=None)
    comments = relationship("Comment")


class Comment(Base):
    __tablename__ = "comments"

    id = Column(Integer, primary_key=True, index=True)
    body = Column(String, nullable=False)
    author = Column(String)
    upvotes = Column(Integer, default=0)
    downvotes = Column(Integer, default=0)
    articleId = Column(Integer, ForeignKey("articles.id", ondelete="CASCADE"))
    createdAt = Column(DateTime,default=None)
    updatedAt = Column(DateTime,default=None)