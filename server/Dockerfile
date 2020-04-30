FROM java:8-jdk-alpine
COPY ./target/server-0.0.1-SNAPSHOT.jar /usr/bin/
WORKDIR /usr/bin/
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]