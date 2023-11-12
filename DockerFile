FROM openjdk:8
EXPOSE 8089
ADD /target/kaddem.jar  kaddem.jar
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
                                           