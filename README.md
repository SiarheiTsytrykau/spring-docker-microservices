# spring-docker-microservices

How to start all microservices:

1. Install Docker Desktop and set memory for Docker Desktop to 7GB 
    Click in tray 'docker icon' -> Settings -> Resources
    A minimum of 4GB RAM assigned to Docker (https://elk-docker.readthedocs.io/#prerequisites) 

2. run via bash (eg. https://cmder.net/):
      sh build.sh
   it will build whole the project and will create docker-image 'javafilebeat:latest' locally     

3. run docker-compose up

After the services started in 2-4 minutes check the URLs:
  Eureka            http://localhost:8761/
  Kibana            http://localhost:5601/
  Spring Boot Admin http://localhost:8082/
  Client service    http://localhost:8080/test
                    http://localhost:8080/get/profile/1 - client service will ask profile service to return profile with id = 1
    
Known issues and steps to do:
 1) ./filebeat/filebeat.yml
    How to replace elk in elk:5044 with the hostname or IP address of the ELK-serving host.
    Now it's looks like elk service accessible from localhost:5044.
    In cloud it will be a problem to get the service, as we don't know URL that will be assigned.    

ELK doesn't start issues:
    To see status of docker services: Click docker icon in tray -> Dashboard 
    https://elk-docker.readthedocs.io/#frequently-encountered-issues

Filebeat version must be the same as ELK stack's version
Additional comments located in client/Dokerfile 

Sample project from ELK team
https://github.com/spujadas/elk-docker.git

Help to start ELK and filebeat
https://elk-docker.readthedocs.io/

Networking in Compose
https://docs.docker.com/compose/networking/
https://www.slideshare.net/SreenivasMakam/docker-networking-overview