FROM javafilebeat:latest
ADD ./target/server-0.0.1-SNAPSHOT.jar /usr/bin/spring-app.jar
RUN chmod 777 /usr/bin/spring-app.jar
EXPOSE 8761
CMD ["/usr/local/bin/start.sh"]