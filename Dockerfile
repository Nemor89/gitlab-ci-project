FROM bellsoft/liberica-openjdk-alpine:latest
COPY ./target/gitlab-local-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","gitlab-local-0.0.1-SNAPSHOT.jar"]