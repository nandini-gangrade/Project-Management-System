package dao;

import entity.Employee;
import entity.Project;
import entity.Task;
import util.DBConnectionUtil;
import exception.EmployeeNotFoundException;
import exception.ProjectNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements IProjectRepository {
    private Connection connection;

    public ProjectRepositoryImpl() {
        this.connection = DBConnectionUtil.getConnection();
    }

    @Override
    public boolean createEmployee(Employee emp) {
        String query = "INSERT INTO Employee (name, designation, gender, salary, project_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getDesignation());
            pstmt.setString(3, emp.getGender());
            pstmt.setDouble(4, emp.getSalary());
            pstmt.setInt(5, emp.getProjectId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean createProject(Project pj) {
        String query = "INSERT INTO Project (projectName, description, start_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pj.getProjectName());
            stmt.setString(2, pj.getDescription());
            stmt.setString(3, pj.getStartDate());
            stmt.setString(4, pj.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createTask(Task task) {
        String query = "INSERT INTO Task (task_name, project_id, employee_id, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, task.getTaskName());
            stmt.setInt(2, task.getProjectId());
            stmt.setInt(3, task.getEmployeeId());
            stmt.setString(4, task.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean assignProjectToEmployee(int projectId, int employeeId) {
        String query = "UPDATE Employee SET project_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, projectId);
            stmt.setInt(2, employeeId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean assignTaskInProjectToEmployee(int taskId, int projectId, int employeeId) {
        String query = "UPDATE Task SET project_id = ?, employee_id = ? WHERE task_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, projectId);
            stmt.setInt(2, employeeId);
            stmt.setInt(3, taskId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) throws EmployeeNotFoundException {
        String query = "DELETE FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProject(int projectId) throws ProjectNotFoundException {
        String query = "DELETE FROM Project WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, projectId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new ProjectNotFoundException("Project with ID " + projectId + " not found.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @Override
    public List<Task> getAllTasks(int empId, int projectId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM Task WHERE employee_id = ? AND project_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, empId);
            pstmt.setInt(2, projectId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getInt("project_id"),
                        rs.getInt("employee_id"),
                        rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
