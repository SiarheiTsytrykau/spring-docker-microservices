#!/bin/bash

echo "Building the Server service"
docker container stop server
docker container rm server
docker image rm server
cd server
./mvnw clean package -DskipTests=true
#docker image build -t server .
cd ..

echo "Building the Client service"
docker container stop client
docker container rm client
docker image rm client
cd client
./mvnw clean package -DskipTests=true
#docker image build -t client .
cd ..

echo "Building the Metadata service"
docker container stop metadata
docker container rm metadata
docker image rm metadata
cd metadata
./mvnw clean package -DskipTests=true
cd ..

echo "Building the Profile service"
docker container stop profile
docker container rm profile
docker image rm profile
cd profile
./mvnw clean package -DskipTests=true
cd ..

echo "Building the Content service"
docker container stop content
docker container rm content
docker image rm content
cd content
./mvnw clean package -DskipTests=true
cd ..
