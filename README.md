# Student Management System - Java JDBC Console Application

A simple Java console application for managing student information using JDBC with a MySQL database. The app enables you to perform CRUD (Create, Read, Update, Delete) operations on student records through a user-friendly menu-driven interface.

---

## Setup Instructions

### 1. Database Setup

- Ensure MySQL server is installed and running.
- Create the required database and table by executing:

```
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    contact VARCHAR(15),
    email VARCHAR(100),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 2. Project Setup

- Java 11 or higher is recommended.
- Add the MySQL Connector/J driver to your project.
  - **Maven:**  
    Add this to your `pom.xml`:
    ```
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <version>8.1.0</version>
    </dependency>
    ```
  - **Without Maven:**  
    Download the connector JAR from [MySQL's website](https://dev.mysql.com/downloads/connector/j/) and add it to your classpath.

### 3. Configure & Run

- Update database connection details (URL, username, password) in the `DBConnectionSingleton` class.
- Compile and run the application. Follow the on-screen menu to manage student records.

---

## Notes

- Assumes a local MySQL server and valid credentials.
- `students` table uses a `TIMESTAMP` column for registration date.
- Student `id` is a unique integer primary key.
- Basic input validation is present; runtime errors may occur with invalid input.
- JDBC exceptions are handled and printed for user feedback.

---

## Summary

Demonstrates practical use of JDBC with the Singleton pattern and a console UI for managing student data.  


---
