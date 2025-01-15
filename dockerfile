# Use the official Maven image to build the app
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG CACHEBUST=123
COPY ./target/BookMyShow-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/BookMyShow
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=Himalayan@2024R
ENV SPRING_PROFILES_ACTIVE=docker
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]