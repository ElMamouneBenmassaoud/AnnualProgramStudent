package g58112.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import g58112.webg5.pae.database.CourseDB;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g58112.webg5.pae.model.Course;
import lombok.Getter;

@Service
@Slf4j
public class PAE {
    @Autowired
    private CourseDB courseDB;

    public Iterable<Course> getCourses() throws Exception{
        try {
            log.info("Tous les cours: " + courseDB.findAll());
            return courseDB.findAll();
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void addCourse(Course course) {
        if(courseDB.existsById(course.getId())){
            log.error("Erreur lors de la création du cours en DB:" + course);
            throw new IllegalArgumentException("This course already exists in our database : " + course.getId());
        }
        courseDB.save(course);
        log.debug("Nouveau cours ajouté : " + course);
    }

    public Optional<Course> getCourse(String courseId) throws Exception{
        if(courseDB.existsById(courseId)){
            return courseDB.findById(courseId);
        }
        throw new IllegalArgumentException("Ce cours n'existe pas " + courseId);
    }

}
