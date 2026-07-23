# Use Java 21 Runtime
FROM eclipse-temurin:21-jre

# Create working directory
WORKDIR /app

# Copy any generated JAR file
COPY target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
