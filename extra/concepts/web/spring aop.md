# spring aop

## logging dependencies

    logback classic

## config logger

TODO configure logback to write in console and file

    logback.xml      
      console appender
      file appender

## read from properties file

TODO read from properties file using @Value

    application.properties
    VersionService
      @Value
    AppConfig
      @PropertySource

## aop dependencies

    aspectjweaver
    aspectjrt

## config aop

    AppConfig
      @EnableAspectJAutoProxy

## execution aspect

TODO write an aspect using execution designator

    BookServiceAspect
      @Before
      @After
      @AfterReturning
      @AfterThrowing
      @Around

## @annotation aspect

TODO write an aspect using annotation designator to count method calls

    @Countable
    CountingAspect
    TimeService
    OutputService

## @annotation aspect

TODO write an aspect using annotation designator to log method info

    @Loggable
    LoggingAspect
