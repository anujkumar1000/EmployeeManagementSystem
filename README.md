# Spring Boot Training API

## Prerequisites for running the project in local
* docker ce installed and running
* MySQL running in docker, you can can give any name, volume location, password
> docker run --name mysqldockerdb -v mysqldbvol:/usr/local/var/mysqldockerdbvol -p 3306:3306 -e MYSQL_ROOT_PASSWORD=rootpass -d mysql:8.3.0 mysqld --log_bin_trust_function_creators=1 --default-authentication-plugin=mysql_native_password
* create schema that is to be used when running the application
> e.g. employeemgt
* create schema that is to be used when running jooq code generation
> e.g. employeemgt_jooq
* install sdkman
* clone repository
* cd into cloned location
* install the appropriate JDK
> sdk env install


### generate jooq classes
* docker with mysql and schema available
* set env variable applicable to your local setup
> EM_FW_JDBC_URL, EM_FW_JDBC_USERNAME, EM_FW_JDBC_PASSWORD, EM_FW_SCHEMAS
* add any new flyway scripts under <project root>/db-schema-jooq/src/main/resources/db/migration
* to generate new/updated jooq genarated java classes run 
> ./gradlew :db-schema-jooq:clean :db-schema-jooq:classes :db-schema-jooq:flywayClean :db-schema-jooq:generateJooq


### run integration test
* docker running
* generate any jooq classes if required <project root>/
* make sure docker is running
* run
> ./gradlew integrationTest
* test reports will be available under <project root>/app/build/reports/tests/integrationTest/index.html
* jacoco reports will be available under <project root>/app/build/reports/jacoco/index.html

### clean db schema used for application run
* docker with mysql and schema available
* set env variable to enable flywayClean
> FLYWAY_CLEAN_DISABLED=false
* set env variable applicable to your local setup
> EM_FW_JDBC_URL, EM_FW_JDBC_USERNAME, EM_FW_JDBC_PASSWORD, EM_FW_SCHEMAS
* run flyway clean
> ./gradlew flywayClean

### apply any pending db migrations for application run
* docker with mysql and schema available
* set env variable applicable to your local setup
> EM_FW_JDBC_URL, EM_FW_JDBC_USERNAME, EM_FW_JDBC_PASSWORD, EM_FW_SCHEMAS
* run flyway migrate
> ./gradlew flywayMigrate

### run application
* docker with mysql and schema available
* set env variable applicable to your local setup for flyway migrate if required
> EM_FW_JDBC_URL, EM_FW_JDBC_USERNAME, EM_FW_JDBC_PASSWORD, EM_FW_SCHEMAS
* apply flyway migration if any
> ./gradlew flywayMigrate
* set env variable applicable to your local setup for application
> EM_R2DBC_URL, EM_R2DBC_USERNAME, EM_R2DBC_PASSWORD
* run app
> ./gradlew bootRun