# spring boot redis

## docs

[spring redis cache](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-caching.html#boot-features-caching-provider-redis)

## dependencies

    spring-boot-starter-redis
    jedis
    jackson

## config

TODO configure h2 database

    application.yml

TODO configure redis template to write values as json

    RedisConfig
        @EnableCaching
        JedisConnectionFactory
        RedisTemplate
        Jackson2JsonRedisSerializer

## spring redis cache

TODO add caching to the service layer

    Car
    CarRepository
    ICarService
    CarService
        @CacheConfig
        @Cacheable
        @CachePut
        @CacheEvict

## integration test

TODO test cache in integration test

    RedisServiceTest
        CacheManager
        Cache

TODO order tests

    @TestMethodOrder
    @Order

## tools

TODO check results in redis desktop manager

    redis desktop manager
