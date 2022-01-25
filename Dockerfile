FROM openjdk:11
VOLUME /tmp
COPY target/*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 52002
ENTRYPOINT ["java", "-jar", "/app.jar"]
