Java-full-stack-dev-challenge - Spring Boot
====================================


#### Requirements
1. Java 8
2. Tomcat 8

> apache-maven-3.6.1


#### Intellij IDE Tips
1. Install Lombok Plugin
2. Enable Lombok Annotation Processing
    - File-> Settings
    - Expand `Build, Execution, Deployment`
    - Expand `Compiler`
    - In `Annotation Processors` check **Enable annotation processing**
    - _You may need to re-open the project to get the settings to take effect_.

#### Run it!
```
mvn clean install
```
```
mvn spring-boot:run
```

## Accessing Application
Based on the properties specified to start application, producto can be accessed at:
```
http://localhost:8183/api/v1/producto
```

## Following are payload

##POST producto

POST - http://localhost:8181/api/v1/producto

    {
           "productoNombre": "Ghulam"
           ...     
     }
        

##Get All producto

Get -  http://localhost:8282/api/v1/producto

##Get producto by Id
    
Get -  http://localhost:8282/api/v1/producto/1
        
##Delete producto By Id
Delete - http://localhost:8282/api/v1/producto/1

## For More --> Swagger - Rest Api Documentation
Rest services can be tested directly through Swagger UI.
[http://localhost:8181/swagger-ui.html](http://localhost:8181/swagger-ui.html)

