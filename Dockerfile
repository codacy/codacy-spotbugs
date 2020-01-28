FROM mozilla/sbt:8u212_1.2.8 AS builder

COPY . /workdir

WORKDIR /workdir

RUN \
    export AWS_REGION=eu-west-1 && \
    sbt docker:stage

# Run image
FROM openjdk:8-jre-alpine

LABEL maintainer="rodrigo@codacy.com"

RUN mkdir -p /opt/docker

WORKDIR /opt/docker

RUN adduser -u 2004 -D docker

COPY --from=builder --chown=docker:docker /workdir/target/docker/stage/opt/docker /opt/docker

COPY --chown=docker:docker ./src/main/resources/docs /docs

USER docker

ENV JAVA_OPTS="-XX:MinRAMPercentage=50.0 -XX:MaxRAMPercentage=95.0"

ENTRYPOINT ["/opt/docker/bin/engine"]
CMD []
