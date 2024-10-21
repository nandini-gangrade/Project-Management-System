import dao.ProjectRepositoryImpl;
import entity.Employee;
import entity.Project;
import entity.Task;
// import exception.EmployeeNotFoundException;
// import exception.ProjectNotFoundException;
import exception.EmployeeNotFoundException;
import exception.ProjectNotFoundException;

import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        ProjectRepositoryImpl repository = new ProjectRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Add Project");
            System.out.println("3. Add Task");
            System.out.println("4. Assign Project to Employee");
            System.out.println("5. Assign Task within a Project to Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Delete Project");
            System.out.println("8. List All Tasks for an Employee");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String empName = scanner.nextLine();
                    System.out.print("Enter Designation: ");
                    String empDesignation = scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String empGender = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double empSalary = scanner.nextDouble();
                    System.out.print("Enter Project ID (or 0 if none): ");
                    int empProjectId = scanner.nextInt();
                    Employee emp = new Employee(0, empName, empDesignation, empGender, empSalary, empProjectId);
                    repository.createEmployee(emp);
                    break;

                case 2:
                    System.out.print("Enter Project Name: ");
                    String projName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String projDescription = scanner.nextLine();
                    System.out.print("Enter Start Date (yyyy-mm-dd): ");
                    String projStartDate = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String projStatus = scanner.nextLine();
                    Project proj = new Project(0, projName, projDescription, projStartDate, projStatus);
                    repository.createProject(proj);
                    break;

                case 3:
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Project ID: ");
                    int taskProjId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int taskEmpId = scanner.nextInt();
                    System.out.print("Enter Status: ");
                    String taskStatus = scanner.next();
                    Task task = new Task(0, taskName, taskProjId, taskEmpId, taskStatus);
                    repository.createTask(task);
                    break;

                case 4:
                    System.out.print("Enter Project ID: ");
                    int projId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    repository.assignProjectToEmployee(projId, employeeId);
                    break;

                case 5:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    System.out.print("Enter Project ID: ");
                    int projectId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    repository.assignTaskInProjectToEmployee(taskId, projectId, empId);
                    break;

                 case 6:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteEmpId = scanner.nextInt();
                    try {
                        repository.deleteEmployee(deleteEmpId);
                        System.out.println("Employee deleted successfully.");
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Enter Project ID to delete: ");
                    int deleteProjId = scanner.nextInt();
                    try {
                        repository.deleteProject(deleteProjId);
                        System.out.println("Project deleted successfully.");
                    } catch (ProjectNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.print("Enter Employee ID: ");
                    int listEmpId = scanner.nextInt();
                    System.out.print("Enter Project ID: ");
                    int listProjId = scanner.nextInt();
                    repository.getAllTasks(listEmpId, listProjId).forEach(t -> System.out.println(t.getTaskName()));
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
        scanner.close();
    }
}
