# Etapa de construcción
FROM eclipse-temurin:24-jdk AS builder
WORKDIR /app

# Copiamos archivos Maven Wrapper (incluyendo la carpeta .mvn)
COPY calmsphere/.mvn .mvn
COPY calmsphere/mvnw .
COPY calmsphere/pom.xml .
COPY calmsphere/src ./src

# Instalamos utilidades necesarias
RUN apt-get update && apt-get install -y dos2unix

# Damos permisos, normalizamos saltos de línea y construimos
RUN dos2unix mvnw && chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:24-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]