FROM maven:3.6.3-ibmjava-8-alpine AS counter-back

WORKDIR /usr/src/counter
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /counter
COPY --from=counter-back /usr/src/counter/target/counter-service.jar ./

EXPOSE 8084

CMD ["java", "-jar", "counter-service.jar"]