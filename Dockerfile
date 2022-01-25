FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar user-msa.jar
ENV JAVA_OPTS=""
EXPOSE 52002
ENTRYPOINT ["java", "-jar", "/user-msa.jar"]
