# Use OpenJDK 17 image
FROM openjdk:17-jdk-slim

# App directory
WORKDIR /app

# Copy Maven build jar (adjust this if you rename jar)
COPY target/coding-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
