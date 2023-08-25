
FROM amazoncorretto:17.0.8-al2-native-jdk

# Copia el archivo JAR generado de tu proyecto Spring Boot al contenedor
COPY target/bazar-0.0.1-SNAPSHOT.jar /bazar.jar

# Expone el puerto en el que se ejecuta tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar tu aplicación Spring Boot al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "/bazar.jar"]

