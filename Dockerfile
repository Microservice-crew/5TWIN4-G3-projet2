FROM openjdk:8
EXPOSE 8089
ADD /target/Kaddem.jar  kaddem.jar
ENTRYPOINT ["java", "-jar", "kaddem.jar"]