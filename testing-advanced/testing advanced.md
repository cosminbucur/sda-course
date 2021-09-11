# testing advanced

## profile config

TODO setup profiles for test and dev env

    application.yml
    application-dev.yml
    application-test.yml
    ApplicationProperties

## persistence config

TODO setup persistence config for mysql

    PersistenceJpaConfig

TODO setup persistence config for tests using h2

    H2TestProfileJpaConfig

## spring rest CRUD

    Book
    BookRepository
    
    BookRequest
    BookResponse
    BookMapper

    BookService
    
    BookController

# testing

## dto unit test

TODO unit test the dto

    BookMapperTest

## service test

TODO unit test for the service layer

    BookServiceTest
        @ExtendWith(MockitoExtension.class)
        @Mock
        @InjectMocks

TODO integration test for the service layer

    BookServiceIntegrationTest
        @SpringBootTest

## controller test

TODO unit test for controller layer

    BookControllerTest

TODO integration test for controller layer using spring mock mvc

    ControllerMockMvcIntegrationTest
        @ActiveProfiles
        @ExtendWith(SpringExtension.class)
        @AutoConfigureMockMvc
        @SpringBootTest

TODO integration test for controller layer using rest template

    ControllerRestTemplateIntegrationTest
        @ActiveProfiles
        @ExtendWith(SpringExtension.class)
        @SpringBootTest

TODO integration test for controller layer using rest assured

    ControllerRestAssuredIntegrationTest
        @ActiveProfiles("test")
        @ExtendWith(SpringExtension.class)
        @SpringBootTest
