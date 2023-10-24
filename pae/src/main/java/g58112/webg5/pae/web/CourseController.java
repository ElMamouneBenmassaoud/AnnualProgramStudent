package g58112.webg5.pae.web;

import java.util.List;

import g58112.webg5.pae.business.PAE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import g58112.webg5.pae.model.Course;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CourseController {

    @Autowired
    private PAE pae;
    @ModelAttribute(name = "courses")
    public Iterable<Course> courses(Model model) throws Exception {
        return pae.getCourses();
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
    public String detail(@PathVariable String courseId, Model model) throws Exception {
        model.addAttribute("course", pae.getCourse(courseId));
        return "course";
    }

    @PostMapping("/course/create")
    public String create(@Valid Course course, Errors errors) {
        if (errors.hasErrors()){
            return "courses";
        }
        try {
            pae.addCourse(course);
            return "redirect:/courses";
        } catch(IllegalArgumentException e) {
            errors.reject("100", null, e.getMessage());
            log.error("the following course cannot be added : " + course.toString());
            return "courses";
        }
    }
}
