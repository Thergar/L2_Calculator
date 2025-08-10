FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/*.jar app.jar
COPY .env .env
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]