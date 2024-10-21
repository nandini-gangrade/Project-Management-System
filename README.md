# Project Management System

This Project Management System is a console-based application designed to help manage projects, tasks, and employees. It includes the following features:
- Create, update, delete, and view employees, projects, and tasks.
- Assign projects to employees and tasks to employees within those projects.
- Generate reports for assigned tasks.
- Ensure exception handling and unit testing.

The project is built using Java and SQL Server, with a focus on Object-Oriented Design and Exception Handling.

## Project Structure

```
Project Management System/
├── dao/
│   ├── IProjectRepository.java
│   └── ProjectRepositoryImpl.java
├── entity/
│   ├── Employee.java
│   ├── Project.java
│   └── Task.java
├── util/
│   ├── DBConnectionUtil.java
│   └── DBPropertyUtil.java
├── exception/
│   ├── EmployeeNotFoundException.java
│   └── ProjectNotFoundException.java
├── db/
│   ├── schema.sql
│   └── seed.sql
├── test/
│   └── ProjectRepositoryImplTest.java
├── mysql-connector-j-9.1.0.jar
└── MainModule.java
```

### Explanation of Folders:

- **dao**: 
   - `IProjectRepository.java`: Interface defining methods for managing employees, projects, and tasks.
   - `ProjectRepositoryImpl.java`: Implementation of the repository methods to handle database operations.
  
- **entity**: 
   - Contains the model classes (`Employee.java`, `Project.java`, and `Task.java`) that represent the database schema.

- **util**:
   - `DBConnectionUtil.java`: Establishes a connection to the SQL Server database using the connection string.
   - `DBPropertyUtil.java`: Fetches database connection properties such as server name and database name from a properties file.

- **exception**: 
   - Contains custom exceptions (`EmployeeNotFoundException.java` and `ProjectNotFoundException.java`) for handling specific errors.

- **db**: 
   - `schema.sql`: Contains the SQL statements to create the database schema.
   - `seed.sql`: Contains SQL scripts for inserting seed data into the database tables.

- **test**: 
   - Contains the unit test file `ProjectRepositoryImplTest.java` to verify that repository methods work as expected.

- **mysql-connector-j-9.1.0.jar**: 
   - This JAR file is required to connect the Java application to the MySQL database.

- **MainModule**: 
   - The main class (`MainModule.java`) that runs the console-based application, allowing users to manage projects, tasks, and employees through a menu-driven interface.

## Process of Running the Project

### Step 1: Set Up the Database

1. Use SQL Server Management Studio (SSMS) to create the necessary tables by executing the `schema.sql` file located in the `db/` folder.
2. Insert seed data by executing the `seed.sql` file in SSMS.
3. Ensure to modify these details with the database name as `your_database_name` and the server name as `your_server_name` you'll find by right-clicking on the database and going to 'Properties' in SSMS. Update the String url in the `DBConnectionUtil.java` file as follows:
```java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:sqlserver://<your_server_name>;databaseName=<your_database_name>";
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
```

### Step 2: Running the Project

1. **MainModule.java**: 
   - Run this class to start the application. It provides a menu-driven interface where you can add, view, delete, and assign employees, projects, and tasks.
   - Database operations are performed through the `ProjectRepositoryImpl.java` class, using methods defined in `IProjectRepository.java`.

2. **Data Fetching**: 
   - Data is fetched from the database using `DBConnectionUtil.java`, which manages the SQL connection based on the configuration in `DBPropertyUtil.java`.
   - The repository layer (`ProjectRepositoryImpl.java`) interacts with the database to retrieve and update data.

3. **Error Handling**: 
   - If an invalid Employee ID or Project ID is entered during deletion or assignment, custom exceptions (`EmployeeNotFoundException.java` or `ProjectNotFoundException.java`) are thrown and handled in the `MainModule.java`.

4. **Unit Testing**: 
   - Unit tests are provided in the `test/ProjectRepositoryImplTest.java` file to ensure system reliability. Run these tests to verify that key functionalities work correctly and exceptions are handled properly.

### Step 3: Running the Unit Tests

1. Open `test/ProjectRepositoryImplTest.java`.
2. Run the unit tests using your preferred IDE or testing framework (such as JUnit).

<br>

---

<br>

## Requirements for Running the Project on Another Machine

### Software Requirements

- **JDK 11 or higher**: Ensure that the correct version of Java is installed.
- **SQL Server**: You need SQL Server installed with a database named `PMS`. The server name should be `DESKTOP-NVORRLQ\SQLEXPRESS`.
- **SQL Server Management Studio (SSMS)**: To execute the `schema.sql` and `seed.sql` files to set up the database schema and seed data.

### Steps for Running on Another Computer

1. **Clone the Project**: 
   - Clone the project from GitHub:
   ```bash
   git clone <your-github-repo-url>
   cd Project Management System
   ```

2. **Database Setup**: 
   - Open SSMS and execute the `schema.sql` and `seed.sql` files located in the `db/` folder.
   - Ensure the database name is set to `PMS` and the server name is `DESKTOP-NVORRLQ\SQLEXPRESS`. You can modify these details in the `DBPropertyUtil.java` file if needed.

3. **MySQL Connector**: 
   - Ensure the `mysql-connector-j-9.1.0.jar` file is in the project directory for database connectivity.
   - To compile the project with the JAR:
   ```bash
   javac -cp "mysql-connector-j-9.1.0.jar" MainModule.java
   ```

4. **Running the Project**: 
   ```bash
   java -cp ".;mysql-connector-j-9.1.0.jar" MainModule
   ```

5. **Running Unit Tests**: 
   - Run the tests in `test/ProjectRepositoryImplTest.java` using your IDE or any testing framework like JUnit.

<br>

---
### **Thank you for exploring the Project Management System, and we hope it serves as a valuable learning tool and foundation for your future projects! 😃**
