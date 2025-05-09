# Build stage
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built JAR (verify your exact JAR name)
COPY --from=builder /app/target/SpringbootWithReact-0.0.1-SNAPSHOT.jar app.jar

# Critical for Railway
EXPOSE 8080
ENV PORT 8080
ENTRYPOINT ["java", "-jar", "app.jar"]