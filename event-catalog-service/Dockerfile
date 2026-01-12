# ----------- Build stage -----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the service source code
COPY . .

# Build jar (skip tests to speed up Render deploy)
RUN chmod +x mvnw && ./mvnw clean package -DskipTests


# ----------- Run stage -----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Render provides PORT at runtime
EXPOSE 8080

# Start Spring Boot using Render port
CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
