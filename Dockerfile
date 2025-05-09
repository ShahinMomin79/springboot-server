FROM eclipse-temurin:21-jdk as builder
WORKDIR /app

# 1. First copy ONLY the wrapper files
COPY .mvn/ .mvn
COPY mvnw ./

# 2. Make mvnw executable BEFORE running it
RUN chmod +x mvnw  # ← THIS IS CRITICAL

# 3. Then copy rest and build
COPY pom.xml ./
COPY src src
RUN ./mvnw clean package -DskipTests  # Now it will work

# ... rest of your Dockerfile ...