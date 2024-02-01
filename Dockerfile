FROM adoptopenjdk:17-jre-hotspot

WORKDIR /app

COPY target/your-spring-boot-app.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
