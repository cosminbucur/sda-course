# spring boot rest

## dependencies

    spring-boot-starter-web
    spring-boot-starter-actuator

## config

TODO configure h2 database and enable console

    application.yml

## spring rest CRUD

TODO create a spring rest controller

    Book
    BookRepository

    BookRequest
    BookResponse
    BookMapper    

    BookService
    
    BookController

## validation

TODO validate dto using @Valid

    BookRequest
    BookService

## rest exception handling

TODO add global exception handler

    NotFoundException
    DuplicateBookException
    RestExceptionHandler

## CORS

TODO configure CORS

    CorsConfig

## monitoring

TODO enable check monitoring endpoints using json view

    application.yml
    actuator

[actuator](http://localhost:8082/actuator)

    application
      /actuator
      /actuator/health
      /actuator/info
      /actuator/loggers

    spring stuff
      /actuator/env
      /actuator/beans
      /actuator/caches
      /actuator/mappings

## tools

TODO use json generator to create json objects

[json generator](http://www.objgen.com/json)

TODO use postman to test rest endpoints

    postman

TODO install json view chrome plugin

[JSONView](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc?hl=en)

TODO check in memory database

    h2 console
