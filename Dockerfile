FROM nexus-registry.cn133.azure.net/baselibrary/openjdk:8-jdk-alpine

ADD build/libs/demo-project-0.1.0.jar /app/demo-project.jar

RUN \
    addgroup -S app && adduser -S -g app app && \
    chown -R app:app /app

WORKDIR /app
USER app

CMD ["java", "-jar", "demo-project.jar"]