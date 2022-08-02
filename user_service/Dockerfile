FROM openjdk:11-jdk-slim
MAINTAINER ITAcademy
COPY target/user_service-1.0.0.jar user_service-1.0.0.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/user_service-1.0.0.jar"]