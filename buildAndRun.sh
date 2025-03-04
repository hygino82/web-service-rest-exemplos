#!/bin/sh
mvn clean package && docker build -t br.dev.hygino/RestApiExemplo .
docker rm -f RestApiExemplo || true && docker run -d -p 9080:9080 -p 9443:9443 --name RestApiExemplo br.dev.hygino/RestApiExemplo