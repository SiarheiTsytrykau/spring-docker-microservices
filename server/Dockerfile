FROM java:8-jdk-alpine
COPY ./target/server-0.0.1-SNAPSHOT.jar /usr/target/server/
WORKDIR /usr/target/server
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]