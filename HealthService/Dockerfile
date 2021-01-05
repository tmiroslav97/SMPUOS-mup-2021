FROM maven:3.6.3-ibmjava-8-alpine AS health-back

WORKDIR /usr/src/health
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /health
COPY --from=health-back /usr/src/health/target/health-service.jar ./

EXPOSE 8086

CMD ["java", "-jar", "health-service.jar"]