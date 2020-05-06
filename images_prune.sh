#!/bin/bash

docker container stop server
docker container rm server
docker image rm server

docker container stop client
docker container rm client
docker image rm client

docker container stop metadata
docker container rm metadata
docker image rm metadata

docker container stop profile
docker container rm profile
docker image rm profile

docker container stop content
docker container rm content
docker image rm content

echo "Building image based on Java with Filebeat installed"
docker image rm javafilebeat
docker image build -t javafilebeat ./filebeat
