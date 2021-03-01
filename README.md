# automotiveInventory
 Automotive inventory nexos test
 
The following technologies were used in this project:
- Java 8
- Gradle
- Lombok
- Swagger
- DataFactory
- Spring Boot
  * Jpa
  * Web
  * Actuator
- PostgreSQL
- Flyway

## Requirements
- Java 8
- Gradle
- PostgreSQL
- Spring Boot
  * Jpa
  * Web


## Health
The health was added to be able to verify the status of the api

##### Check the status of the api
##### GET
```bash
http://localhost:8889/api/automotiveInventory/actuator/health
```

## Documentation
You can get more information in the Swagger documentation: 
```bash
http://localhost:8889/api/automotiveInventory/swagger-ui.html
```