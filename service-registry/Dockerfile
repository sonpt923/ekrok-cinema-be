# Stage 1: Build jar từ Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY service-registry /app/service-registry
WORKDIR /app/service-registry
RUN mvn clean package -DskipTests

# Stage 2: Run app với OpenJDK
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=builder /app/service-registry/target/service-registry-1.0.jar app.jar

VOLUME /tmp
ENV JAVA_OPTS="-Xmx256m -Xms128m"
EXPOSE 8761
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
