FROM openjdk:11
COPY target/*.jar user-msa.jar
ENV JAVA_OPTS=""
EXPOSE 52002
# pull image
FROM centos

# set work directory
WORKDIR /var/www

ENTRYPOINT ["java", "-jar", "user-msa.jar"]