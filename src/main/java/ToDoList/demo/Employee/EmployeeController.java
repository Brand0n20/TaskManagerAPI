package ToDoList.demo.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    Logger logger = LogManager.getLogger(EmployeeController.class);
@Autowired
EmployeeService employeeService;

EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
}

@GetMapping
public ResponseEntity<List<Employee>> getEmployees() {
    return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
}

@GetMapping(value = "/{email}")
public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
    return new ResponseEntity<>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Employee> postEmployee(@RequestBody Employee newEmployee) {
    return new ResponseEntity<>(employeeService.saveEmployee(newEmployee), HttpStatus.CREATED);
}
@DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long employeeId) throws IllegalAccessException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
