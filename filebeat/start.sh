#!/bin/bash

curl -XPUT -H "Content-Type: application/json" 'http://elk:9200/_template/filebeat?pretty' -d@/etc/filebeat/filebeat.template.json
# run filebeat which will transport logs to logstash
/etc/init.d/filebeat start
#run spring application that will added in the image by each service (client, admin, etc..)
java -jar /usr/bin/spring-app.jar

tail -f /logs/spring.log
