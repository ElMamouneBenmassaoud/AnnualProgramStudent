package g58112.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import g58112.webg5.pae.business.PAE;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", PAE.getCourses());
        return "home";
    }
}
