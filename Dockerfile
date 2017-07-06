#FROM nexus-registry.cn133.azure.net/baselibrary/openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine

ADD build/libs/demo-project-0.1.0.jar /app/demo-project.jar

WORKDIR /app
CMD ["java", "-jar", "demo-project.jar"]