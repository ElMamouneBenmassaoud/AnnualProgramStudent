package g58112.webg5.pae.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;
import jakarta.validation.Valid;

@Controller
public class CourseController {

    @ModelAttribute(name = "courses")
    public List<Course> courses(Model model) {
        return PAE.getCourses();
    }

    @ModelAttribute(name = "course")
    public Course course(Model model) {
        return new Course();
    }

    @GetMapping("/courses")
    public String home(Model model) {
        return "courses";
    }

    @GetMapping("/course/{courseId}/details")
    public String detail(Model model) {
        return "course";
    }

    @PostMapping("/course/create")
    public String create(@Valid Course course, Errors errors) {
        if (errors.hasErrors()){
            return "courses";
        }
        PAE.addCourse(course);
        return "redirect:/courses";
    }

}
