A demo Spring project which implemets a simple REST client for retrieving general sports matches data.

## REQUIREMENTS
* Java 8
* Setup JAVA_HOME environment variable pointing to java install direcotry
* Maven

## CONFIGURATION
You can configure data source url by setting a custom value in '\src\main\resources\application.properties'

## BUILD
    mvn package

## TEST
You can manually run tests with command:

    .\mvnw test


## RUNNING
To start the application on default Tomcat server, run the following command in a command prompt:

    mvn spring-boot:run

You can stop the application with:
    
    mvn spring-boot:stop

## USE
Exposed API and its use can be seen and tested on Swagger user interface, avaliable on: http://localhost:8080/swagger-ui/index.html

