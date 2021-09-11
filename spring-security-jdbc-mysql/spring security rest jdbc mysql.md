# spring security jdbc mysql

Spring security using predefined mysql database schema and jdbc authentication.

# persistence config

TODO setup mysql database

    application.yml   

TODO create mysql database

    use from resources
        schema.sql - schema of the database
        data.sql - user data

[bcrypt generator](https://bcrypt-generator.com/)

pass = {bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi

# security config

TODO setup authentication with jdbc

    SecurityConfig

# web

    UserController

# how to run

in postman:

[/principal](http://localhost:8081/principal)

    Authorization: Basic Auth
    admin / pass
