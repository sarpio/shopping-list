#
#   Build stage
#
FROM maven:3.9.6-amazoncorretto-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
#
#   Package stage
#
FROM bellsoft/liberica-openjdk-alpine:21
COPY --from=build /home/app/target/shopping-list-backend-0.0.1.jar /usr/local/lib/backend.jar
ENTRYPOINT ["java", "-jar", "usr/local/lib/backend.jar"]
EXPOSE 8080
