# Use the official Maven image to build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/coding-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the application will run
EXPOSE 3030

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
