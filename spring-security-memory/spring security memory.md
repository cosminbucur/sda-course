# spring security memory

Spring security using h2 database schema and in memory authentication.

## spring security default (basic auth)

- add spring security
- default username = user
- default password = generated in console

## roles

TODO spring security in memory authentication using roles

    DefaultController    
    SecurityConfig - roles

## authorities

TODO spring security in memory authentication using authorities

    DefaultController
    SecurityConfig - authorities
        PasswordEncoder

TODO security util to get current username

    SecurityUtils

# tools

[base64 encoder](https://www.base64encode.org/)

# how to run

in postman:

[/api/public](http://localhost:8081/api/public)

[/api/role](http://localhost:8081/api/role)

[/api/authority](http://localhost:8081/api/authority)