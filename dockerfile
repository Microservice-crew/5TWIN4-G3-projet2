FROM openjdk:8
ADD target/kaddem-0.0.1-20231024.101819-1.jar kaddem.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
