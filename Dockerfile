FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/spring-data-jpa-docker-0.0.1-SNAPSHOT.jar spring-data-jpa.jar
ENTRYPOINT ["java", "-jar","spring-data-jpa.jar"]