# Build Stage
FROM maven:eclipse-temurin AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Deploy Stage
FROM tomcat:10.1.28-jdk21

ENV DB_USER=avnadmin
ENV DB_PASSWORD=AVNS_-QThPRlWRVnrd9qqvXk
ENV DB_PORT=19599
ENV DB_URL=jdbc:postgresql://pg-trocatine-dbtrocatine.l.aivencloud.com:19599/dbtrocatine1
ENV DB_DRIVER=org.postgresql.Driver

COPY --from=build /app/target/ServletTrocaTine-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ServletTrocaTine.war
