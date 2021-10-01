# syntax=docker/dockerfile:1

FROM python:3.6.15-slim

WORKDIR /

COPY requirements.txt requirements.txt

RUN pip install --upgrade pip

RUN apt-get update && \
    apt-get -y install gcc && \
    apt-get update

RUN pip3 install -r requirements.txt

COPY . .

EXPOSE 8001

CMD ["python","main_worker.py"]