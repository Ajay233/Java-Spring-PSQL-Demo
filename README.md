# Demo app using Java, Spring and PostgreSQL

## Dependencies selected on initialisation
- Web
- Thymeleaf
- JDBC
- PostgreSQL

To setup the database run:
- ```CREATE DATABASE account```
- Connect to the ```account``` database (```psql account```)
- ```CREATE TABLE details ('name' varchar(35), 'account' int, 'pin' int, 'balance' decimal)```