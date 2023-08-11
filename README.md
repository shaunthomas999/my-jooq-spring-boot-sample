# JOOQ - Spring-Boot Sample

## Reference

* https://boottechnologies-ci.medium.com/spring-boot-with-jooq-and-postgresql-4a86378a4e5e (not that easy to follow along)
  * Code reference - https://github.com/anicetkeric/spring-boot-jooq
* https://www.baeldung.com/jooq-with-spring
  * https://www.baeldung.com/spring-boot-support-for-jooq
## Database setup

* Connect to local Postgresql database using command `psql -U postgres`

```sql
CREATE ROLE dev SUPERUSER LOGIN PASSWORD 'qwerty';
CREATE DATABASE "librarydb" OWNER "dev";
```
