FROM maven:3.6.3-ibmjava-8-alpine AS centralregistry-back

WORKDIR /usr/src/centralregistry
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /centralregistry
COPY --from=centralregistry-back /usr/src/centralregistry/target/centralregistry-service.jar ./

EXPOSE 8083

CMD ["java", "-jar", "centralregistry-service.jar"]