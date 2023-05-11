# phonebook-service

Phone Book Service [Spring Boot - Java]
The service provides CRUD apis for a contact. 

## Requirements

For building and running the application you need:

- [JDK 1.5](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

```shell
mvn clean install
java -jar phonebook-service-0.0.1-SNAPSHOT.jar
```

## Swagger

The aplication contains swagger document.
```shell
http://localhost:8080/swagger-ui/index.html#/phone-book-controller
```

The Apis supported:

* Create a Contact
* Update a contact
* Delete a contact
* Get All contacts
