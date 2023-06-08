package ToDoList.demo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {


    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}/tasks")
    public ResponseEntity<List<Task>> getTasksByEmployeeId(@PathVariable long id) {
        return new ResponseEntity<>(taskService.getTasksByEmployeeId(id), HttpStatus.OK);
    }


}
