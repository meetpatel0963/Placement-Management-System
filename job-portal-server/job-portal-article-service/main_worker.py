import requests, json
from dynaconf import settings
from subprocess import Popen, call
import time
import signal
import os
import pika, sys, os
import json

commands = [
     "uvicorn rest-server:app --port {} --host 0.0.0.0".format(settings.get_fresh('REST_PORT')),
     #'uvicorn grpc-server:serve --port 8000 --app-dir ./grpc_service'
     
     'python ./grpc-server.py',
     'python ./naming_server.py'
]

def updateConfigEnv():
     r=requests.get(settings.get_fresh('CONFIG_SERVER'))
     resp = r.json()
     if(resp.get('status',0) == 404):
          print('Unable to connect')
          return
     else:
          resp = resp['propertySources'][0]['source']
          json.dump(resp,open("./env.json","w"))
          return

def startListening():
     process = [Popen(cmd, shell=True) for cmd in commands]

     time.sleep(14)
     # for i in range(len(process)):
     #      process[i].terminate()
     #      time.sleep(15)
     #      process[i] = Popen(commands[i])
     updateConfigEnv()
     broker()

#startListening()
def broker():
     connection = pika.BlockingConnection(
          pika.ConnectionParameters(
               host=settings.get_fresh('AMQP_HOST'),
               port=int(settings.get_fresh('AMQP_PORT')),
               credentials=pika.PlainCredentials(settings.get_fresh('AMQP_USER'),settings.get_fresh('AMQP_USER')), 
               virtual_host='/'))
     channel = connection.channel()
     
     result = channel.queue_declare(queue=settings.get_fresh('APP_NAME'), exclusive=True)
     queue_name = result.method.queue

     channel.queue_bind(exchange='springCloudBus', queue=queue_name, routing_key='#')

     def callback(ch, method, properties, body):  
          updated_config = json.loads(body.decode('utf-8'))
          #print(updated_config)
          updateConfigEnv()

     channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

     print(' [*] Waiting for messages. To exit press CTRL+C')
     channel.start_consuming()

startListening()