FROM openjdk:11-slim

WORKDIR /app

COPY target/flnk-*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
