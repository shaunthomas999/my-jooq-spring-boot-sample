# JOOQ - Spring-Boot Sample

[![Java CI with Maven](https://github.com/shaunthomas999/my-jooq-spring-boot-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/shaunthomas999/my-jooq-spring-boot-sample/actions/workflows/maven.yml)

## Reference

* https://boottechnologies-ci.medium.com/spring-boot-with-jooq-and-postgresql-4a86378a4e5e (not that easy to follow along)
  * Code reference - https://github.com/anicetkeric/spring-boot-jooq
* https://www.baeldung.com/jooq-with-spring
  * https://www.baeldung.com/spring-boot-support-for-jooq
* https://www.jooq.org/doc/latest/manual/code-generation/codegen-jpa/

## Database setup

* Connect to local Postgresql database using command `psql -U postgres`

```sql
CREATE ROLE dev SUPERUSER LOGIN PASSWORD 'qwerty';
CREATE DATABASE "librarydb" OWNER "dev";
```

## Notes

* Database POJOs are generated from real database schema, table, columns etc. So connection to database is required during CI build
* Usually, jooq-codegen generated Table, Record and Pojo classes are committed to git as a solution to above problem
* Another solution is to use Jooq JPADatabase - https://www.jooq.org/doc/latest/manual/code-generation/codegen-jpa/
  * Generate Jooq Table, Record, Pojo etc. classes from Entity classes
  * Use Hibernate and H2 to create a temp database which can be used by jooq-codegen
