# Use Java 17 runtime
FROM eclipse-temurin:17-jdk-jammy

# Create app directory
WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

# Expose backend port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
