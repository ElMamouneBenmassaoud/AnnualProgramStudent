package g58112.webg5.pae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PaeRestController {

    @GetMapping("/courses")
    public List<Course> courses(){
        return PAE.getCourses();
    }

    @GetMapping("/course/{id}")
    public String courses(@PathVariable("id") String id){
        return id;
    }
}
