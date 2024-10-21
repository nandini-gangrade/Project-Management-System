package test;

package dao;

import entity.Employee;
import entity.Project;
import entity.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectRepositoryImplTest {
    private ProjectRepositoryImpl repository;

    @Before
    public void setUp() {
        repository = new ProjectRepositoryImpl(); // Make sure this initializes DB connection correctly
    }

    @Test
    public void testCreateEmployee() {
        Employee emp = new Employee(0, "John Doe", "Developer", "Male", 60000, 0);
        boolean result = repository.createEmployee(emp);
        assertTrue("Employee should be created successfully", result);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task(0, "Complete Documentation", 1, 1, "Assigned");
        boolean result = repository.createTask(task);
        assertTrue("Task should be created successfully", result);
    }

    @Test
    public void testSearchProjectsAndTasksAssignedToEmployee() {
        // This should be a valid employee ID and project ID in your database
        int empId = 1; // Replace with a valid employee ID
        int projectId = 1; // Replace with a valid project ID
        var tasks = repository.getAllTasks(empId, projectId);
        assertNotNull("Tasks should not be null", tasks);
        assertFalse("Tasks should contain at least one task", tasks.isEmpty());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void testEmployeeNotFoundException() {
        int invalidEmployeeId = -1; // Use an ID that does not exist
        repository.deleteEmployee(invalidEmployeeId); // Should throw exception
    }

    @Test(expected = ProjectNotFoundException.class)
    public void testProjectNotFoundException() {
        int invalidProjectId = -1; // Use an ID that does not exist
        repository.deleteProject(invalidProjectId); // Should throw exception
    }
}
