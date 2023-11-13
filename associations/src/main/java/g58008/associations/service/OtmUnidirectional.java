package g58008.associations.service;

import g58008.associations.database.DepartmentRepository;
import g58008.associations.database.EmployeeRepository;
import g58008.associations.model.Department;
import g58008.associations.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crée une association entre Department et Employee en uni-directional et One To Many
 * WARNING : Aucune vérification, aucun display, que des urls.
 * HELP :
 * /emp/create -> create and store an employee in the database
 * /dpt/create -> create and store a department in the database
 * /dpt/addEmp/{dptId}/{empId} -> add an employee to a department (create a link between them in the db)
 */
@Service
public class OtmUnidirectional {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addDepartment(Long id, String name) {
        departmentRepository.save(new Department(id, name));
    }

    public void addEmployee(Long id, String name, Long dptId) {
        employeeRepository.save(new Employee(id, name));
    }

    public void addEmployeeToDepartment(Long empId, Long dptId) {
        Employee employee = employeeRepository.findById(empId).get();
        Department department = departmentRepository.findById(dptId).get();
        department.addEmployee(employee);
        departmentRepository.save(department);
    }
}
