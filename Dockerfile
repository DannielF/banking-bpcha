FROM docker.io/eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY *.jar bpcha.jar
ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar bpcha.jar" ]