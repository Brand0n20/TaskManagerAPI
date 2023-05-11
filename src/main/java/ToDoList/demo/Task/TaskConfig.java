package ToDoList.demo.Task;

import ToDoList.demo.Employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    /**
     * Because this class implements CommandLineRunner, the run method is executed as soon as the server
     * successfully starts, and before it begins accepting requests from the outside. Here, we use this
     * as a place to run some code that generates and saves an employee
     */
    CommandLineRunner commandLineRunner() {

    }
}
