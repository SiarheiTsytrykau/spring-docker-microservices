FROM java:8-jdk-alpine
COPY ./target/client-0.0.1-SNAPSHOT.jar /usr/target/client/
WORKDIR /usr/target/client
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]