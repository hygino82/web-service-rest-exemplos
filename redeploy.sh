#!/bin/bash
/home/hygino/Payara_Server/bin/asadmin undeploy jakartaee-rest-example
mvn clean package
/home/hygino/Payara_Server/bin/asadmin deploy --contextroot web-service-rest-produto target/jakartaee-rest-example.war
