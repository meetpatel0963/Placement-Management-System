from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
# from dotenv import dotenv_values
from dynaconf import settings

# config = dict(dotenv_values(".env"))

engine = create_engine(
    settings.get_fresh('SQLALCHEMY_DATABASE_URL')
)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()