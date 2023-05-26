package ToDoList.demo.Task;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String description;

    private long employeeID;

    private Date dueDate;

    private String department;

    public Task() {
    }

    public Task(String description, long employeeID, String department) {
        this.description = description;
        this.employeeID = employeeID;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", assignee='" + employeeID + '\'' +
                ", dueDate=" + dueDate +
                ", department='" + department + '\'' +
                '}';
    }
}

