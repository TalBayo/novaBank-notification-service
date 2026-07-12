#stage 1: Build
FROM maven:3.9.12-amazoncorretto-25 AS build
WORKDIR /app

#Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

#To compile the service into a jar excecutable file
COPY src ./src
RUN mvn clean package -DskipTests

#Stage 2: Runtime
FROM amazoncorretto:25
WORKDIR /app

#Copy the jar
COPY --from=build /app/target/*.jar app.jar

#Expose the port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]