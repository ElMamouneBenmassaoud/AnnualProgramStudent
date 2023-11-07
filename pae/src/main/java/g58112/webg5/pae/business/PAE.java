package g58112.webg5.pae.business;

import java.util.Optional;

import g58112.webg5.pae.database.CourseDB;
import g58112.webg5.pae.database.StudentDB;
import g58112.webg5.pae.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g58112.webg5.pae.model.Course;

@Service
@Slf4j
public class PAE {
    @Autowired
    private CourseDB courseDB;
    @Autowired
    private StudentDB studentDB;

    public Iterable<Student> getStudents() throws Exception{
        try {
            log.info("Tous les étudiants: " + studentDB.findAll());
            return studentDB.findAll();
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void addStudent(Student student) {
        if(studentDB.existsById(student.getId())){
            log.error("Erreur lors de la création du student en DB:" + student);
            throw new IllegalArgumentException("This student already exists in our database : " + student.getId());
        }
        studentDB.save(student);
        log.debug("Nouveau student ajouté : " + student);
    }

    public Student getStudent(int studentId) throws Exception{
        if(studentDB.existsById(studentId) && studentDB.findById(studentId).isPresent()){
            return studentDB.findById(studentId).get();
        }
        throw new IllegalArgumentException("Cet étudiant n'existe pas " + studentId);
    }

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

    public Course getCourse(String courseId) throws Exception{
        if(courseDB.existsById(courseId) && courseDB.findById(courseId).isPresent()){
            return courseDB.findById(courseId).get();
        }
        throw new IllegalArgumentException("Ce cours n'existe pas " + courseId);
    }
}
