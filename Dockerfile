FROM openjdk:17-oracle

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} watchit.jar
ENTRYPOINT ["java","-jar","watchit.jar"]
