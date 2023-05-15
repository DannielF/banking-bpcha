FROM docker.io/adoptopenjdk:11-jdk-hotspot

WORKDIR /app

COPY ./build.gradle .
COPY ./settings.gradle .

COPY src/ src/

RUN ./gradlew build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/your-application.jar"]