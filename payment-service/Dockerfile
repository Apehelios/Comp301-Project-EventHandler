# ----------- Build stage -----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /repo

# Copy entire monorepo so parent pom.xml exists
COPY . .

# Build only this module + required parents
RUN chmod +x mvnw && ./mvnw -pl payment-service -am clean package -DskipTests

# ----------- Run stage -----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy only the payment-service jar
COPY --from=build /repo/payment-service/target/*.jar app.jar

EXPOSE 8080
CMD ["sh","-c","java -Dserver.port=${PORT:-8080} -jar app.jar"]
