FROM openjdk:11-jdk-slim
MAINTAINER ITAcademy
COPY target/classifier_service-1.0.0.jar classifier_service-1.0.0.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/classifier_service-1.0.0.jar"]