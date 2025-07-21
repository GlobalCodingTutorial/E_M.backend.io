# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-focal as build
WORKDIR /app
# Install Maven within the build stage
RUN apt-get update && apt-get install -y maven

COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
# Copy the built JAR from the build stage
COPY --from=build /app/target/coding.jar /app/app.jar
# Expose the port the application runs on
EXPOSE 8080
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]