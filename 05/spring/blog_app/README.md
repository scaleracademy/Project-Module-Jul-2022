# Blogging App (Spring Boot)

## Development 

### Database Setup 

1. Create a  database
2. Create a user
3. Create a password
4. Grant access to created database to user

#### Postgres 


```postgresql
CREATE DATABASE blog;
CREATE USER blogadmin WITH ENCRYPTED PASSWORD 'blogpass';
GRANT ALL PRIVILEGES ON DATABASE blog TO blogadmin;
```

#### MySQL

```mysql
CREATE DATABASE blog;
CREATE USER 'blogadmin'@'localhost' IDENTIFIED BY 'blogpass';
GRANT ALL PRIVILEGES ON blog.* TO 'blogadmin'@'localhost';
```