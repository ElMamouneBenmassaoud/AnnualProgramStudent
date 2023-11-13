package g58008.associations;

import g58008.associations.service.OtmUnidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtmUnidirectionalController {

    @Autowired
    private OtmUnidirectional otmUnidirectional;

    @GetMapping("/dpt/create")
    public ResponseEntity<String> createDpt(Model model) {
        otmUnidirectional.addDepartment(1L, "Computer Science");
        return new ResponseEntity<>("Department created", HttpStatus.OK);
    }

    @GetMapping("/emp/create")
    public ResponseEntity<String> createEmp(Model model) {
        otmUnidirectional.addEmployee(1L, "John Doe", 1L);
        return new ResponseEntity<>("Employee created", HttpStatus.OK);
    }

    @GetMapping("/dpt/addEmp/{dptId}/{empId}")
    public ResponseEntity<String> addEmpToDpt(Model model, @PathVariable("dptId") Long dptId, @PathVariable("empId") Long empId) {
        otmUnidirectional.addEmployeeToDepartment(empId, dptId);
        return new ResponseEntity<>("Employee added to department", HttpStatus.OK);
    }
}

