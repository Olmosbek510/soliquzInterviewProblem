FROM eclipse-temurin:21
LABEL authors="orazboyevolmosbek"
WORKDIR /app
COPY target/card-service.jar app.jar
EXPOSE 8082
CMD ["java", "-jar", "app.jar"]