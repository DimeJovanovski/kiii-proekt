FROM openjdk:17
MAINTAINER dimitar.jovanovski@students.finki.ukim.mk
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
