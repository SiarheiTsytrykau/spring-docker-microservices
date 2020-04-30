#!/bin/bash

echo "Building the Server service"
cd server
docker container rm server
docker image rm server
./mvnw clean package -DskipTests=true
docker image build -t server .
cd ..

echo "Building the Client service"
cd client
docker container rm client
docker image rm client
./mvnw clean package -DskipTests=true
docker image build -t client .
cd ..
