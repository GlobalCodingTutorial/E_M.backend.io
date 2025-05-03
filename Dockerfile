# Use Eclipse Temurin JDK 24 base image
FROM eclipse-temurin:24-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Pre-fetch dependencies
RUN ./mvnw dependency:go-offline

# Copy source files
COPY src src

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose the port used by Spring Boot
EXPOSE 3030

# Run the application
<<<<<<< HEAD
CMD ["java", "-jar", "target/coding-0.0.1-SNAPSHOT.jar"]
=======
CMD ["java", "-jar", "target/coding-0.0.1-SNAPSHOT.jar"]
>>>>>>> 4b1b5a8c640f6ec2355fec1132ec7db9f5568a4a
