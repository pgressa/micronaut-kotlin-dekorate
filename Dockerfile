FROM openjdk:14-alpine
COPY build/libs/foo-*-all.jar foo.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "foo.jar"]