FROM maven:3.6.3-ibmjava-8-alpine AS centralregistry-back

WORKDIR /usr/src/config
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /eureka
COPY --from=centralregistry-back /usr/src/config/target/centralregistry-service.jar ./

EXPOSE 8083

CMD ["java", "-jar", "centralregistry-service.jar"]