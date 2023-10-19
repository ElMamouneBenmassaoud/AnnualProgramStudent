package g58112.webg5.pae.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PaeRestController {

    @GetMapping("/courses")
    public List<Course> courses(){
        return PAE.getCourses();
    }

   /**
     * REST API to search a course with his id
     * @param courseId course's id
     * @return json object with the chosen course
     */
    @GetMapping("/course/{courseId}")
    public Course course(@PathVariable("courseId") String courseId) {
        log.info("Rest: called /course/" + courseId);
        Course course = PAE.getCourse(courseId);
        return course;
    }

    /**
     * For all routes which do not exist in the app
     * @return an error 404 using http
     */
    @GetMapping("/**")
    public ResponseEntity<String> error404() {
        log.info("Rest: called /error404");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
