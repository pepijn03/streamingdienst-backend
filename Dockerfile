FROM maven:3.8-openjdk-18 as maven-builder

COPY src /app/src

COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package -DskipTests

FROM openjdk:18-alpine



COPY --from=maven-builder app/target/Streamingdienst-backend-2-0.0.1-SNAPSHOT.jar /app-service/Streamingdienst-backend-2-0.0.1-SNAPSHOT.jar

WORKDIR /app-service

EXPOSE 8080

ENTRYPOINT ["java","-jar","Streamingdienst-backend-2-0.0.1-SNAPSHOT.jar"]