FROM openjdk:21-jdk-slim
WORKDIR /app
ARG JAR_FILE=build/libs/L2_Calculator.jar
COPY ${JAR_FILE} app.jar
COPY .env .env
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
