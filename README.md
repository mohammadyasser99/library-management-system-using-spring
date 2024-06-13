## Library Management System using
Spring Boot


## Project Description

 Library Management System API using Spring Boot. The system allows librarians
to manage books, patrons, and borrowing records.

## Entities:
-Book: Includes attributes like ID, title, author, publication year, ISBN, etc.
-Patron: Contains details like ID, name, contact information.
-Borrowing Record: Tracks the association between books and patrons,
including borrowing and return dates.

## API Endpoints:
# Book management endpoints :
●GET /api/books: Retrieve a list of all books. <br />
●GET /api/books/{id}: Retrieve details of a specific book by ID. <br />
● POST /api/books: Add a new book to the library.<br />
● PUT /api/books/{id}: Update an existing book's information.<br />
● DELETE /api/books/{id}: Remove a book from the library.<br />
● Patron management endpoints:<br />
● GET /api/patrons: Retrieve a list of all patrons.<br />
● GET /api/patrons/{id}: Retrieve details of a specific patron by ID.<br />
● POST /api/patrons: Add a new patron to the system.<br />
● PUT /api/patrons/{id}: Update an existing patron's information.<br />
● DELETE /api/patrons/{id}: Remove a patron from the system.<br />
● Borrowing endpoints:<br />
● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to
borrow a book.<br />
● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.<br />


## Data storage :
this project uses Spring JPA with mysql database .

## Validation and Error Handling:
● Implementing input validation for API requests using spring validator .

## Security:
● Implementing JWT-based authorization using spring security to protect the API endpoints.

## Aspects :
● Implementing logging using Aspect-Oriented Programming (AOP) to log some method calls, exceptions, and performance metrics of certain operations like book additions, updates, and patron transactions.

## Caching (Optional - for extra credit):
● Utilize Spring's caching mechanisms to cache frequently accessed data, such as book details or patron information, to improve system performance.

## Transaction Management:
● Implementing declarative transaction management using Spring's @Transactional annotation to ensure data integrity during critical operations.

## Testing:
writing unit tests to validate the functionality of the API Using JUNIT and Mockito .



# Before running this application, you need to have the following software installed:

- Java Development Kit (JDK) 8 or higher
- Maven



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









