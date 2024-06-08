FROM eclipse-temurin:21
WORKDIR /app
LABEL authors="orazboyevolmosbek"
COPY target/user-service.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]