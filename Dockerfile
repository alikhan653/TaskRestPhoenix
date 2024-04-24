FROM eclipse-temurin:17.0.8_7-jre
EXPOSE 8080
WORKDIR /opt/app
COPY build/libs/*.jar TaskRestPhoenix-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","TaskRestPhoenix-0.0.1-SNAPSHOT.jar"]

