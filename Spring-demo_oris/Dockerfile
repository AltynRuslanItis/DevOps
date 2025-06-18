# === STAGE 1: сборка (Maven + JDK17) ===
FROM maven:3-openjdk-17 AS builder
WORKDIR /workspace
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B

# === STAGE 2: рантайм (JDK17 slim) ===
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
