package entity;

public class Project {
    private int id;
    private String projectName;
    private String description;
    private String startDate;
    private String status;

    // Constructors
    public Project() {}

    public Project(int id, String projectName, String description, String startDate, String status) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
