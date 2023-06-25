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

    private String dueDate;

    private String department;

    public Task() {
    }

    public Task(String description, long employeeID, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.employeeID = employeeID;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
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

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", assignee='" + employeeID + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}

