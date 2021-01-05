FROM maven:3.6.3-ibmjava-8-alpine AS vehicle-back

WORKDIR /usr/src/vehicle
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /vehicle
COPY --from=vehicle-back /usr/src/vehicle/target/vehicle-service.jar ./

EXPOSE 8083

CMD ["java", "-jar", "vehicle-service.jar"]