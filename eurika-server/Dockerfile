FROM maven:3.8.6-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21.0.1-slim
LABEL authors="orazboyevolmosbek"
WORKDIR /app
COPY --from=build /app/target/eurika-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
HEALTHCHECK --interval=30s --timeout=30s --start-period=10s --retries=3 CMD curl -f http://localhost:8761/actuator/health || exit 1
ENTRYPOINT ["java", "-jar", "app.jar"]
