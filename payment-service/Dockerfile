FROM eclipse-temurin:21
LABEL authors="orazboyevolmosbek"
WORKDIR /app
COPY target/payment-service.jar app.jar
EXPOSE 8083
CMD ["java", "-jar", "app.jar"]