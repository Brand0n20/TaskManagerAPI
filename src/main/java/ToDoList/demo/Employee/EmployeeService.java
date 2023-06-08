package ToDoList.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** this will let the Controller know that this service class is a spring bean, and it's
 * been initialized
 */
@Service
public class EmployeeService {

    private final Logger logger = LogManager.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;    // the "final" is to keep it constant
                                                            // it's also prevent overriding and inheritance
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Couldn't find employees");
        }

    }

    public Employee getEmployeeByEmail(String email) {
        Employee employee;
        try {
            employee = employeeRepository.findByEmail(email);
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
        if (employee != null) {
            return employee;
        } else {
            logger.error("There is no employee with that email");
            throw new RuntimeException(String.valueOf(HttpStatus.CONFLICT));
        }
    }

    public Employee saveEmployee(Employee employeeToSave) {
        Employee savedEmployee;
        try {
            savedEmployee = employeeRepository.save(employeeToSave);
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
        return savedEmployee;
    }

    public void deleteEmployee(long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (existingEmployee != null) {
            try {
                employeeRepository.deleteById(employeeId);
            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                throw new RuntimeException();
            }
        } else {
            logger.error("There is no employee with that email");
            throw new NoSuchElementException();
        }

    }
}
