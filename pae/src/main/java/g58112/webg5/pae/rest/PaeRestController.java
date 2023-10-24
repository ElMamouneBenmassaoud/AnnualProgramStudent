package g58112.webg5.pae.rest;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.model.Course;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Slf4j
public class PaeRestController {

    @Autowired
    private PAE pae;

     /**
     * REST API to get every courses in the PAE
     * @return json object with all courses
     */
    @GetMapping("/courses")
    public Iterable<Course>  courses() throws Exception {
        return pae.getCourses();
    }

    /**
     * REST API to search a course with his id
     * @param courseId course's id
     * @return json object with the chosen course
     */
    @GetMapping("/course/{id}")
    public Course courses(@PathVariable("id") String id){
        try{
            return pae.getCourse(id);
        }catch(Exception e){
            throw new NoSuchElementException();
        }
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
