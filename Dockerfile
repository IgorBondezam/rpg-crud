FROM maven:3.9.9-amazoncorretto-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/rpg-0.0.1-SNAPSHOT.jar"]