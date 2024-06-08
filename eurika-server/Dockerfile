FROM eclipse-temurin:21
LABEL authors="orazboyevolmosbek"
WORKDIR /app
COPY target/eurika-server.jar app.jar
EXPOSE 8761
CMD ["java", "-jar", "app.jar"]