# FROM and CMD are required !!!
FROM javafilebeat:latest
ADD ./target/client-0.0.1-SNAPSHOT.jar /usr/bin/spring-app.jar
RUN chmod 777 /usr/bin/spring-app.jar
EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]
CMD ["/usr/local/bin/start.sh"]

# Understand how CMD and ENTRYPOINT interact
# https://docs.docker.com/engine/reference/builder/#understand-how-cmd-and-entrypoint-interact
# https://habr.com/ru/company/southbridge/blog/329138/
# https://goinbigdata.com/docker-run-vs-cmd-vs-entrypoint/
