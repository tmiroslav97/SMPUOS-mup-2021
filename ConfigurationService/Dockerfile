FROM maven:3.6.3-ibmjava-8-alpine AS config-back

WORKDIR /usr/src/config
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY --from=config-back /usr/src/config/target/configuration-service.jar ./

EXPOSE 8888

CMD ["java", "-jar", "configuration-service.jar"]