# spring-docker-microservices

How to start all microservices:

1. Install Docker Desktop and set memory for Docker Desktop to 7GB 
    Click in tray 'docker icon' -> Settings -> Resources
    A minimum of 4GB RAM assigned to Docker (https://elk-docker.readthedocs.io/#prerequisites) 

2. run via bash (eg. https://cmder.net/):
      sh build.sh
   it will build whole the project and will create docker-image 'javafilebeat:latest' locally     

3. run docker-compose up

4. Go to Kibana UI by URL localhost:5601  
   Services is starting. It may take more than 2-4 minutes

ELK doesn't start issues:
    To see status of docker services: Click docker icon in tray -> Dashboard 
    https://elk-docker.readthedocs.io/#frequently-encountered-issues

Filebeat version must be the same as ELK stack's version
Additional comments located in client/Dokerfile 

Sample project from ELK team
https://github.com/spujadas/elk-docker.git

Help to start ELK and filebeat
https://elk-docker.readthedocs.io/

