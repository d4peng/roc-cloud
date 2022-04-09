FROM openjdk:8
MAINTAINER d4peng@qq.com
RUN mkdir -p /roc/{lib,config}
WORKDIR /roc
ADD ./lib /roc/lib
ADD ./roc-cache-center-1.0.0.jar /roc
ENV ACTIVE=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","roc-cache-center-1.0.0.jar","--spring.profiles.active=${ACTIVE}"]