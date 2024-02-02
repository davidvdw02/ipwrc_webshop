FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/ipwrc_webshop-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
