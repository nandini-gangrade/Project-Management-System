package dao;

import entity.Employee;
import entity.Project;
import entity.Task;
import exception.EmployeeNotFoundException;
import exception.ProjectNotFoundException;

import java.util.List;

public interface IProjectRepository {
    boolean createEmployee(Employee emp);
    
    boolean deleteEmployee(int employeeId) throws EmployeeNotFoundException; // Update here

    boolean createProject(Project pj);

    boolean deleteProject(int projectId) throws ProjectNotFoundException; // Update here

    boolean createTask(Task task);

    boolean assignProjectToEmployee(int projectId, int employeeId);

    boolean assignTaskInProjectToEmployee(int taskId, int projectId, int employeeId);

    List<Task> getAllTasks(int empId, int projectId);
}
