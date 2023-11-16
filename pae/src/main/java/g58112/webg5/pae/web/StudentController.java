package g58112.webg5.pae.web;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@Controller
@Slf4j
public class StudentController {

    private static boolean WITH_FILTER = false;
    private static String FILTERED_NAME = "";

    @Autowired
    private PAE pae;
    @ModelAttribute(name = "students")
    public Iterable<Student> students(Model model) throws Exception {
        return WITH_FILTER ? pae.getStudentsNameContaining(FILTERED_NAME) : pae.getStudents();
    }

    @ModelAttribute(name = "student")
    public Student student(Model model) {
        return new Student();
    }

    @PostMapping("")
    public String filterByName(@RequestParam("name") String name) {
        try {
            FILTERED_NAME = name;
            WITH_FILTER = true;
            return "redirect:/students";
        } catch (IllegalArgumentException e) {
            return "students";
        }
    }

    @GetMapping("")
    public String home(Model model) {
        return "students";
    }

    @GetMapping("/{studentId}/details")
    public String detail(@PathVariable int studentId, Model model) throws Exception {
        model.addAttribute("student", pae.getStudent(studentId));
        model.addAttribute("courses", pae.getCourses());
        return "student";
    }

    @PostMapping("/create")
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
