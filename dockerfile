FROM openjdk:8
ADD target/kaddem-0.0.1-20231027.092649-13.jar kaddem.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
