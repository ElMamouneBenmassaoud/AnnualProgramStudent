package g58112.webg5.pae.business;

import g58112.webg5.pae.database.CourseDB;
import g58112.webg5.pae.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourseService {

    @Autowired
    private CourseDB courseDB;

    /**
     * Get all courses in DB
     * @return all courses as an Iterable<Course>
     */
    public Iterable<Course> getCourses() throws Exception{
        try {
            log.info("Tous les cours: " + courseDB.findAll());
            return courseDB.findAll();
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Add a course in the list
     * [DEBUG] put a log (type: debug) when the course is created
     * @param course the course to create
     */
    public void addCourse(Course course) {
        if(courseDB.existsById(course.getId())){
            log.error("Erreur lors de la création du cours en DB:" + course);
            throw new IllegalArgumentException("This course already exists in our database : " + course.getId());
        }
        courseDB.save(course);
        log.debug("Nouveau cours ajouté : " + course);
    }

    /**
     * Provide a specific course by his id in the database
     *
     * @param courseId The unique identifier of the course to retrieve.
     * @return The course with the specified ID, if found.
     * @throws IllegalArgumentException If no course is found with the given ID.
     */

    public Course getCourse(String courseId) throws Exception{
        if(courseDB.existsById(courseId) && courseDB.findById(courseId).isPresent()){
            return courseDB.findById(courseId).get();
        }
        throw new IllegalArgumentException("Ce cours n'existe pas " + courseId);
    }

    /**
     * Update an existing course in the list
     * [DEBUG] put a log (type: debug) when the course is updated
     * @param course the course to update
     */
    public void updateCourse(Course course) {
        if(!courseDB.existsById(course.getId())) {
            log.error(PAE.class + "(updateCourse) This course does not exist in our database : " + course);
            throw new IllegalArgumentException("This course does not exist in our database : " + course.getId());
        }
        courseDB.save(course);
        log.info(PAE.class + "(updateCourse) The course has been updated : " + course);
    }

}
