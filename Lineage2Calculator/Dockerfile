FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY gradlew ./
COPY gradle/ ./gradle/
COPY settings.gradle.kts ./

RUN sed -i 's/\r$//' gradlew && chmod +x gradlew

COPY Lineage2Calculator/build.gradle.kts Lineage2Calculator/
COPY Lineage2Calculator/src Lineage2Calculator/src

RUN ./gradlew --no-daemon :backend:bootJar

FROM eclipse-temurin:21-jre
USER root

RUN apt-get update && apt-get install -y --no-install-recommends curl \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

RUN useradd -u 10001 -r -s /bin/false appuser

COPY --from=build /app/Lineage2Calculator/build/libs/*.jar /app/app.jar
RUN chown -R appuser:appuser /app
USER 10001

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]