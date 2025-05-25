# Dockerfile
FROM openjdk:17
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 3030
CMD ["java", "-jar", "target/coding-0.0.1-SNAPSHOT.jar"]
