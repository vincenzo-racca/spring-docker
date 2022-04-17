FROM openjdk:17
LABEL maintainer="vincenzo.racca22@gmail.com"
RUN adduser spring
USER spring
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://polar-postgres-catalog:5432/spring-docker
ENV SPRING_DATASOURCE_USERNAME=user
ENV SPRING_DATASOURCE_PASSWORD=password
EXPOSE 8081/tcp
ARG VERSION=0.0.1-SNAPSHOT
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-docker.jar
ENTRYPOINT ["java", "-jar", "spring-docker.jar"]