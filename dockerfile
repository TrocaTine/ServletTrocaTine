# Usar Maven com Java 11 no estágio de build
FROM maven:3.8.5-eclipse-temurin-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Usar Tomcat com Java 11 para o ambiente de execução
FROM tomcat:10.1.28-jdk11

# Variáveis de ambiente do banco de dados
ENV DB_USER=avnadmin
ENV DB_PASSWORD=AVNS_-QThPRlWRVnrd9qqvXk
ENV DB_PORT=19599
ENV DB_URL=jdbc:postgresql://pg-trocatine-dbtrocatine.l.aivencloud.com:19599/dbtrocatine1
ENV DB_DRIVER=org.postgresql.Driver

# Copiar o arquivo WAR para o Tomcat
COPY --from=build /app/target/ServletTrocaTine-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ServletTrocaTine.war
