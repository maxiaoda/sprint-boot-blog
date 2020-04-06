FROM openjdk:8u242-jdk

RUN mkdir /app

WORKDIR /app

COPY target/spring-boot-demo-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java","-jar","spring-boot-demo-0.0.1-SNAPSHOT.jar"]