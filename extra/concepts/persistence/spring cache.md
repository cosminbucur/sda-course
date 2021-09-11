# spring cache

## dependencies

    spring-boot-starter-cache

## config

TODO main class

TODO configure h2 database

    application.yml

TODO configure caching

    CachingConfig
        @EnableCaching

## spring cache

TODO add caching to the service layer

    Car
    CarRepository
    ICarService
    CarService
        @Cacheable
            key
            unless
            condition
        @CachePut
        @CacheEvict
            allEntries

## integration test

TODO test cache in integration test

    CarServiceTest
        CacheManager
        Cache

TODO order tests

    @TestMethodOrder
    @Order