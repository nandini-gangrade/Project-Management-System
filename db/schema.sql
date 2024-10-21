-- Project Table
CREATE TABLE Project (
    id INT PRIMARY KEY IDENTITY(1,1),
    projectName NVARCHAR(100) NOT NULL,
    description NVARCHAR(255),
    start_date DATE NOT NULL,
    status NVARCHAR(20) CHECK (status IN ('started', 'dev', 'build', 'test', 'deployed'))
);

-- Employee Table
CREATE TABLE Employee (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    designation NVARCHAR(50) NOT NULL,
    gender NVARCHAR(10) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES Project(id)
);

-- Task Table
CREATE TABLE Task (
    task_id INT PRIMARY KEY IDENTITY(1,1),
    task_name NVARCHAR(100) NOT NULL,
    project_id INT,
    employee_id INT,
    status NVARCHAR(20) CHECK (status IN ('Assigned', 'started', 'completed')),
    FOREIGN KEY (project_id) REFERENCES Project(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);
