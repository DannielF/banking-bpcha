FROM docker.io/eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
LABEL maintainer="dannielf"
VOLUME /main-app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]
