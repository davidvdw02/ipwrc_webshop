FROM openjdk:17-jre-slim

WORKDIR /src

COPY ipwrc_webshop.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
