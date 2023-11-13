package g58008.associations;

import g58008.associations.service.OtmUnidirectional;
import g58008.associations.service.OtoUnidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtoUnidirectionalController {
    @Autowired
    private OtoUnidirectional otoUnidirectional;

    @GetMapping("/parking/create")
    public ResponseEntity<String> createDpt(Model model) {
        otoUnidirectional.addParking(1L);
        return new ResponseEntity<>("Parking created", HttpStatus.OK);
    }

    @GetMapping("/car/create")
    public ResponseEntity<String> createEmp(Model model) {
        otoUnidirectional.addCar(1L);
        return new ResponseEntity<>("Car created", HttpStatus.OK);
    }

    /*@GetMapping("/dpt/addEmp/{dptId}/{empId}")
    public ResponseEntity<String> addEmpToDpt(Model model, @PathVariable("dptId") Long dptId, @PathVariable("empId") Long empId) {
        otmUnidirectional.addEmployeeToDepartment(empId, dptId);
        return new ResponseEntity<>("Employee added to department", HttpStatus.OK);
    }*/
}
