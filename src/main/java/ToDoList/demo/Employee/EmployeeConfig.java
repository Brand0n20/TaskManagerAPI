package ToDoList.demo.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration      //  this annotation indicates that the class has @Bean definition methods.
                    // this also initializes the container and gets the spring bean objects
public class EmployeeConfig {
    @Bean
    /**
     * Because this class implements CommandLineRunner, the run method is executed as soon as the server
     * successfully starts, and before it begins accepting requests from the outside. Here, we use this
     * as a place to run some code that generates and saves an employee
     */
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee brandon = new  Employee("Brandon",
                    "Alfaro",
                    "brandonalfa@gamil.com",
                    "Software Engineer",
                    "IT");

            Employee mark = new Employee("Mark",
                    "Hannah",
                    "MarkHannah35@gamil.com",
                    "Product Owner",
                    "IT");
            repository.saveAll(List.of(brandon, mark));
        };
    }
}
