# spring data jpa

## repositories

- PersonCrudRepository
- CrudRepositoryConfig

- PersonPagingAndSortingRepository
- PagingAndSortingRepositoryConfig

- PersonJpaRepository
- JpaRepositoryConfig

## associations

- FatherRepository
- SonRepository
- AssociationConfig

## optionals

- BookRepository
- OptionalsConfig

## derived queries

- ProfileRepository
- ProfileRepositoryTest

## custom queries

- PlayerRepository
- PlayerRepositoryTest

## configure logging for transactions

logging.level: org.springframework.transaction: TRACE

## spring boot prevent creation of db

spring.jpa.hibernate.ddl-auto: none

validate (validate the schema)
update (update the schema if are changes)
create (create the schema)
create-drop (create the schema and drop it at the end)

## validations

- User
- UserRepository
- add validations to User
    - ValidationsConfig
- used dto in service
    - UserDto
    - UserMapper
- UserService

