@echo off
call mvn clean package
call docker build -t br.dev.hygino/RestApiExemplo .
call docker rm -f RestApiExemplo
call docker run -d -p 9080:9080 -p 9443:9443 --name RestApiExemplo br.dev.hygino/RestApiExemplo