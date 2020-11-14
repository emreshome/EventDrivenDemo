FROM openjdk:8-jdk-alpine
ADD target/consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "consumer-0.0.1-SNAPSHOT.jar"]
