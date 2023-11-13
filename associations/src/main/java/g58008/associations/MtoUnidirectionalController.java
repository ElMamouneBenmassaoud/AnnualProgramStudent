package g58008.associations;

import g58008.associations.model.School;
import g58008.associations.service.MtoUnidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MtoUnidirectionalController {
    @Autowired
    private MtoUnidirectional mtoUnidirectional;

    @GetMapping("/student/create")
    public ResponseEntity<String> createDpt(Model model) {
        School school = new School(1L, "ESI");
        mtoUnidirectional.addStudent(1L, "Cameron", school);
        return new ResponseEntity<>("Student created", HttpStatus.OK);
    }

    @GetMapping("/school/create")
    public ResponseEntity<String> createEmp(Model model) {
        mtoUnidirectional.addSchool(1L, "ESI");
        return new ResponseEntity<>("School created", HttpStatus.OK);
    }
}
