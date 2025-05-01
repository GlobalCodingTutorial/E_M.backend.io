FROM eclipse-temurin:24-jdk@sha256:0907c8846ee238198f94a5679475858165a248823c691f947a27bc08f105e177
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
