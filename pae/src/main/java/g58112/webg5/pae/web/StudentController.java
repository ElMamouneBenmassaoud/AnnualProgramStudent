package g58112.webg5.pae.web;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Student;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    private PAE pae;
    @ModelAttribute(name = "students")
    public Iterable<Student> students(Model model) throws Exception {
        return pae.getStudents();
    }

    @ModelAttribute(name = "student")
    public Student student(Model model) {
        return new Student();
    }

    @GetMapping("/students")
    public String home(Model model) {
        return "students";
    }

    @GetMapping("/student/{studentId}/details")
    public String detail(@PathVariable int studentId, Model model) throws Exception {
        model.addAttribute("student", pae.getStudent(studentId));
        return "student";
    }

    @PostMapping("/student/create")
    public String create(@Valid Student student, Errors errors) {
        if (errors.hasErrors()){
            return "students";
        }
        try {
            pae.addStudent(student);
            return "redirect:/students";
        } catch(IllegalArgumentException e) {
            errors.reject("100", null, e.getMessage());
            log.error("the following student cannot be added : " + student.toString());
            return "students";
        }
    }
}
