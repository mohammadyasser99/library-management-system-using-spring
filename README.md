## Library management system

## Introduction

Library management system Project is a web application built using Spring Boot framework. It provides API for manageing books , users and patrons .

Before running this application, you need to have the following software installed:

- Java Development Kit (JDK) 8 or higher
- Maven

- ## Description :
- this project using spring boot with spring JPA and spring security , and  JUNIT and mocketio  for testing .
- this project implementing JWT strategy for securing the apis .
- you can make CRUD operations for books, patrons , and borrowing .
- for sensitive database operation transactions is being used .


## installation 

1-in command line clone the project: 
```bash
git@github.com:mohammadyasser99/library-management-system-using-spring.git
```


2-Navigate to the project directory:

```bash
cd /library-management-system-using-spring
```

3-Build the project using Maven:
```bash
mvn clean install
```
4-create a table in mysql with name : library-management-system

5-start the application :
```bash
java -jar target/library-management-system-using-spring.jar
```

## Usage :
1- you should register :
[http://localhost:3000](http://localhost:3000/api/login)

2-to login (get request) :
[http://localhost:3000](http://localhost:3000/api/login)
and use Basic authentication with username and password field 
ti will return in the header :
X-XSRF-TOKEN and
Authorization

3-every request with secured api you should include X-XSRF-TOKEN and Authorzation to access the data









