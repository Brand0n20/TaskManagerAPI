package ToDoList.demo.Employee;

import jakarta.persistence.*;

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
    private int taskNumber;

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

    public int getTaskNumber() {return taskNumber;}

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

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
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
