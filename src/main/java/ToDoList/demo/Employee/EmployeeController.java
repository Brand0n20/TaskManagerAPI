package ToDoList.demo.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/employees")
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

@GetMapping(value = "/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Employee> postEmployee(@RequestBody Employee newEmployee) {
    return new ResponseEntity<>(employeeService.saveEmployee(newEmployee), HttpStatus.CREATED);
}

@PutMapping(value = "/{id}")
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
    return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
}
@DeleteMapping(value= "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
