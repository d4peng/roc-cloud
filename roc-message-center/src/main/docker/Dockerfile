FROM openjdk:8
MAINTAINER d4peng@qq.com
RUN mkdir -p /roc/{lib,templates,config}
WORKDIR /roc
ADD ./lib /roc/lib
ADD ./roc-message-center-1.0.0.jar /roc
ADD ./templates /roc/templates
ENV ACTIVE=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","roc-message-center-1.0.0.jar","--spring.profiles.active=${ACTIVE}"]