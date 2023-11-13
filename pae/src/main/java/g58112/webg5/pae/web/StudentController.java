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

    @GetMapping("/{studentId}/registerCourse/{courseId}")
    public String enrollStudentToCourse(Model model, @PathVariable("courseId") String courseId, @PathVariable("studentId") int studentId, HttpServletRequest request) {
        try {
            pae.enrollStudentToCourse(studentId, courseId);
        } catch (Exception e) {
            model.addAttribute("enrollmentError", "Error: " + e.getMessage());
            log.error("The following student cannot be enrolled to the course: " + studentId + " " + courseId);
            return "course";
        }
        return "redirect:" + getPreviousPageUrl(request);
    }

    /**
     *
     * @param request the request
     * @return the previous page url
     */
    private String getPreviousPageUrl(HttpServletRequest request) {
        return request.getHeader("referer");
    }

}
