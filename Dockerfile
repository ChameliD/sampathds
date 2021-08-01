FROM openjdk8
ADD target\newsampathds-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","app.jar"]