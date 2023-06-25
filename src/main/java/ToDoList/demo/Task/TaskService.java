package ToDoList.demo.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final Logger logger = LogManager.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

     public List<Task> getAllTasks() {
         List<Task> tasksFound = null;
        try {
            tasksFound = taskRepository.findAll();

        } catch (DataAccessException exception) {
            logger.error(exception.getMessage());
            System.out.println("Couldn't access the tasks");
        }
        return tasksFound;
    }

    public List<Task> getTasksByEmployeeId(long employeeId) {
         List<Task> tasksFound = null;
         try {
            tasksFound = taskRepository.findTasksByEmployeeID(employeeId);
         } catch (DataAccessException exception) {
             logger.error(exception.getMessage());
             System.out.println("Couldn't access the tasks of the employee");
         }
         return tasksFound;
    }

    public Task getTaskById(long taskId) {
        Task taskToFind = null;
        try {
            taskToFind = taskRepository.findById(taskId).orElse(null);

        } catch (DataAccessException exception) {
            logger.error(exception.getMessage());
            System.out.println("Couldn't find the task by this id");
        }
        return taskToFind;
    }

    public Task getSingleTaskByEmployeeId(long employeeId, long taskId) {
        Task task = null;
            List<Task> tasks = getTasksByEmployeeId(employeeId);
            for (Task singleTask: tasks) {
                if (singleTask.getId() == taskId) {
                    try {
                        task = getTaskById(taskId);
                    } catch (DataAccessException exception) {
                        logger.error(exception.getMessage());
                        System.out.println("Couldn't find task");
                    }
                }
            }
            return task;
    }

    public Task createTask(Task task) {
        try {
            taskRepository.save(task);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            System.out.println("Couldn't save task");
        }
        return task;
    }

    public void deleteTask (Long taskId) {
        try {
            taskRepository.deleteById(taskId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.out.println("Couldn't delete task");
        }
    }


}
