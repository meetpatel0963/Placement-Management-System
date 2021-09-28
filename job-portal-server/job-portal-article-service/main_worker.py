import requests, json
from dynaconf import settings
from subprocess import Popen, call
import time
import signal
import os

commands = [
     "uvicorn rest-server:app --port {}".format(settings.get_fresh('REST_PORT')),
     #'uvicorn grpc-server:serve --port 8000 --app-dir ./grpc_service'
     'py grpc_service/grpc-server.py',
     #'py naming_server.py'
]


def startListening():
     process = [Popen(cmd) for cmd in commands]

     # time.sleep(14)
     # for i in range(len(process)):
     #      process[i].terminate()
     #      time.sleep(15)
     #      process[i] = Popen(commands[i])
     # r=requests.get(settings.get_fresh('CONFIG_SERVER'))
     # resp = r.json()
     # if(resp.get('status',0) == 404):
     #      print('Unable to connect')
     #      return
     # else:
     #      resp = resp['propertySources'][0]['source']
     #      json.dump(resp,open("./env.json","w"))
         
     #      return

startListening()
