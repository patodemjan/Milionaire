# Použijeme JDK 21 base image
FROM eclipse-temurin:21-jdk

# Nastav pracovný adresár v kontejnere
WORKDIR /app

# Skopíruj všetky súbory z tvojho projektu do kontajnera
COPY . .

# Spusti Maven build (preskočí testy, aby to šlo rýchlejšie)
RUN ./mvnw clean package -DskipTests

# Spusti aplikáciu pomocou jar súboru, ktorý vznikol buildom
CMD ["java", "-jar", "target/Milionaire-0.0.1-SNAPSHOT.jar"]
