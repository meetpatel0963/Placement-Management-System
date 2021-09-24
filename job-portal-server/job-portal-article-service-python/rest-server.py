from typing import List, Optional

from fastapi import Depends, FastAPI, HTTPException
from sqlalchemy.orm import Session
from datetime import datetime
from grpc_service.sql_app import crud, models, schemas
from grpc_service.sql_app.database import SessionLocal, engine
from rest_routers import article,comment


app = FastAPI()
app.include_router(article.router)
app.include_router(comment.router)