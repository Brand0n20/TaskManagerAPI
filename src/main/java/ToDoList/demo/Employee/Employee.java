package ToDoList.demo.Employee;

import ToDoList.demo.Task.Task;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // will map this class to database, this one if for hibernate
@Table  // this one is for the actual table
public class Employee {

    public Employee() {
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation is what's needed to auto generate a primary key
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    private String jobTitle;
    private String Department;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return Department;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(String department) {
        Department = department;
    }


    public Employee(String firstName, String lastName, String email, String jobTitle, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.Department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", jobTitle='" + jobTitle + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }
}
