FROM java:8-jdk-alpine
COPY ./target/client-0.0.1-SNAPSHOT.jar /usr/bin/
WORKDIR /usr/bin/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]