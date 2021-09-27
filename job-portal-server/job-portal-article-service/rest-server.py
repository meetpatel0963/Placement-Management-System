from typing import List, Optional

from fastapi import Depends, FastAPI, HTTPException
from sqlalchemy.orm import Session
from datetime import datetime
from grpc_service.sql_app import crud, models, schemas
from grpc_service.sql_app.database import SessionLocal, engine
from rest_routers import article,comment
from dynaconf import settings 
import uvicorn

app = FastAPI()
app.include_router(article.router,prefix="/api/v1")
app.include_router(comment.router,prefix="/api/v1")

@app.get("/")
def changedName():
     return {'app_name':settings.get_fresh('APP_NAME')}
