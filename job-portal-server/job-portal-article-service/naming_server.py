from py_eureka_client.eureka_client import EurekaClient
import threading
from dynaconf import settings

def setInterval(func,time):
    e = threading.Event()
    while not e.wait(time):
        func()



client = EurekaClient(
     eureka_server=settings.get_fresh('EUREKA_SERVER'),
     app_name=settings.get_fresh('APP_NAME'),
     instance_port=int(settings.get_fresh('REST_PORT')),
     instance_ip=settings.get_fresh('INSTANCE_IP'),
     instance_host=settings.get_fresh('INSTANCE_HOST'),
     renewal_interval_in_secs=int(settings.get_fresh('RENEWAL')),
     duration_in_secs=int(settings.get_fresh('DURATION'))
    )

client.start()

# res = client.do_service("article","/")
# # print(res)
# # client.close()
setInterval(client.send_heartbeat,int(settings.get_fresh('DURATION')))