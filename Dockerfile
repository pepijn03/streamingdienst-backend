FROM openjdk:18.0.2
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]