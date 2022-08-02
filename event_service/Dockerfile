FROM openjdk:11-jdk-slim
MAINTAINER ITAcademy
COPY target/event_service-1.0.0.jar event_service-1.0.0.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/event_service-1.0.0.jar"]