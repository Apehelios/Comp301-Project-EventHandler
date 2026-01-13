FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /repo
COPY . .
RUN chmod +x mvnw && ./mvnw -pl event-catalog-service -am clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /repo/event-catalog-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
