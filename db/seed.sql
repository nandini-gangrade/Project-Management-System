-- Seed data for Project table
INSERT INTO Project (projectName, description, start_date, status) VALUES 
('Project Alpha', 'Initial project for testing purposes', '2024-01-01', 'started'),
('Project Beta', 'Development of the beta version of the product', '2024-02-01', 'dev'),
('Project Gamma', 'Marketing and research project', '2024-03-01', 'build'),
('Project Delta', 'Final deployment project', '2024-04-01', 'test'),
('Project Epsilon', 'Data analysis project', '2024-05-01', 'deployed'),
('Project Zeta', 'User feedback collection', '2024-06-01', 'started'),
('Project Eta', 'Internal tools development', '2024-07-01', 'dev'),
('Project Theta', 'A/B testing project', '2024-08-01', 'build'),
('Project Iota', 'Enhancements based on user feedback', '2024-09-01', 'test'),
('Project Kappa', 'Legacy system migration', '2024-10-01', 'deployed');

-- Seed data for Employee table
INSERT INTO Employee (name, designation, gender, salary, project_id) VALUES 
('Alice Smith', 'Project Manager', 'Female', 80000, 1),
('Bob Johnson', 'Developer', 'Male', 60000, 1),
('Charlie Brown', 'Designer', 'Male', 55000, 1),
('Diana Prince', 'Developer', 'Female', 62000, 2),
('Ethan Hunt', 'QA Tester', 'Male', 50000, 2),
('Fiona Green', 'Business Analyst', 'Female', 72000, 3),
('George Baker', 'Developer', 'Male', 61000, 3),
('Hannah Williams', 'Marketing Specialist', 'Female', 48000, NULL),
('Ian Wright', 'Support Engineer', 'Male', 40000, NULL),
('Jane Doe', 'Data Scientist', 'Female', 70000, 4);

-- Seed data for Task table
INSERT INTO Task (task_name, project_id, employee_id, status) VALUES 
('Define project scope', 1, 1, 'Assigned'),
('Develop application features', 1, 2, 'Assigned'),
('Design user interface', 1, 3, 'Assigned'),
('Write unit tests', 2, 4, 'Assigned'),
('Conduct QA testing', 2, 5, 'Assigned'),
('Gather requirements', 3, 6, 'Assigned'),
('Implement backend logic', 3, 7, 'Assigned'),
('Create marketing strategy', 3, 8, 'Assigned'),
('Compile project report', 4, 9, 'Assigned'),
('Conduct user training', 4, 1, 'Assigned');
