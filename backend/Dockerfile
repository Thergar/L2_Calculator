FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY gradlew ./
COPY gradle/ ./gradle/
COPY settings.docker.gradle.kts ./settings.gradle.kts

RUN sed -i 's/\r$//' gradlew && chmod +x gradlew

COPY backend/build.gradle.kts backend/
COPY backend/src backend/src
COPY dto/ dto/

RUN ./gradlew --no-daemon :backend:bootJar

FROM eclipse-temurin:21-jre
USER root

RUN apt-get update && apt-get install -y --no-install-recommends curl \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

RUN useradd -u 10001 -r -s /bin/false appuser

COPY --from=build /app/backend/build/libs/*.jar /app/app.jar
RUN chown -R appuser:appuser /app
USER 10001

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]