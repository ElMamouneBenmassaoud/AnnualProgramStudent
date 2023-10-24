package g58112.webg5.pae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PAE pae;
    @GetMapping("/courses")
    public Iterable<Course>  courses() throws Exception {
        return pae.getCourses();
    }

    @GetMapping("/course/{id}")
    public String courses(@PathVariable("id") String id){
        return id;
    }
}
