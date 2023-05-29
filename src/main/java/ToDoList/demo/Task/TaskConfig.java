package ToDoList.demo.Task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner taskCommandLineRunner(TaskRepository taskRepository) {
        return args -> {
            Task task1 = new Task("New task", 1, "IT");
            Task task2 = new Task("Another task", 2, "Tax");
            taskRepository.saveAll(List.of(task1, task2));
        };
    }

}
