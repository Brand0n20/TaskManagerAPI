package ToDoList.demo.Task;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String assignee;

    private Date dueDate;

    private String department;

    public Task() {
    }

    public Task(String name, String assignee, Date dueDate, String department) {
        this.name = name;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
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
                "name='" + name + '\'' +
                ", assignee='" + assignee + '\'' +
                ", dueDate=" + dueDate +
                ", department='" + department + '\'' +
                '}';
    }
}

