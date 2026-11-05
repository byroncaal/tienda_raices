# Etapa 1: compilar el jar con Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Cachear dependencias
COPY mvnw pom.xml ./
COPY .mvn ./.mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw package -DskipTests -B

# Etapa 2: imagen liviana solo con el JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render asigna el puerto en la variable PORT (application.properties ya la lee)
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]