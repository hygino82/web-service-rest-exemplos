@echo off

call asadmin undeploy jakartaee-rest-example
call mvn clean package
call asadmin deploy target/jakartaee-rest-example.war
pause
