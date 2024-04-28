FROM eclipse-temurin:17.0.8_7-jre
EXPOSE 8080
WORKDIR /opt/app
COPY target/*.jar TaskRestPhoenix.jar
ENTRYPOINT ["java","-jar","TaskRestPhoenix.jar"]

