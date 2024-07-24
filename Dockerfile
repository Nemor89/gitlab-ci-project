FROM bellsoft/liberica-openjdk-alpine:latest
COPY ./target/gitlab-local.jar .
CMD ["java","-jar","gitlab-local.jar"]