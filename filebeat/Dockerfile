
### This image will be used as base for service images that need filebeat preinstalled
# Filebeat 7.6.1

FROM openjdk:8

###############################################################################
#                                INSTALLATION
###############################################################################

### install Filebeat

ENV FILEBEAT_VERSION 7.6.1

RUN apt-get update -qq \
 && apt-get install -qqy curl \
 && apt-get clean

# download Filebeat from https://www.elastic.co/de/downloads/beats/filebeat
RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-amd64.deb \
 && dpkg -i filebeat-${FILEBEAT_VERSION}-amd64.deb \
 && rm filebeat-${FILEBEAT_VERSION}-amd64.deb


###############################################################################
#                                CONFIGURATION
###############################################################################

### configure Filebeat
## Home path: [/usr/share/filebeat] Config path: [/etc/filebeat] Data path: [/var/lib/filebeat] Logs path: [/var/log/filebeat]

# config file
ADD filebeat.yml /etc/filebeat/filebeat.yml
    #sets the file permissions flags: 6 - rw for owner; 4- r for group; 4 - r for others
RUN chmod 644 /etc/filebeat/filebeat.yml

# CA cert
    # -p create parent dir too
RUN mkdir -p /etc/pki/tls/certs
ADD logstash-beats.crt /etc/pki/tls/certs/logstash-beats.crt

# prepare folder for log-files.
# each app stores logs in this folder, then filebeat will transport logs via TLS to logstash -> elastic -> kibana
RUN mkdir -p /logs
RUN chmod 777 /logs
#/var/log/filebeat

# create template based on filebeat version (assumption: it is the same version as elasticsearch version)
RUN filebeat export template --es.version ${FILEBEAT_VERSION} > /etc/filebeat/filebeat.template.json

###############################################################################
#                                    START
###############################################################################

ADD ./start.sh /usr/local/bin/start.sh
RUN chmod +x /usr/local/bin/start.sh
CMD [ "/usr/local/bin/start.sh" ]
