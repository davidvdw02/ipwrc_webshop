FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/target/your-spring-boot-app.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
