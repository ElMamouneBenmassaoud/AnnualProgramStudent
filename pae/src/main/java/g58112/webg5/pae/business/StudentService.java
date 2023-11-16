package g58112.webg5.pae.business;

import g58112.webg5.pae.database.CourseDB;
import g58112.webg5.pae.database.StudentDB;
import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class StudentService {

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

    /**
     * Update a student in the list
     * [DEBUG] put a log (type: debug) when the student is updated
     * @param student the student to update
     */
    public void updateStudent(Student student) {
        if(!studentDB.existsById(student.getId())) {
            log.error(PAE.class + "(updateStudent) This student does not exist in our database : " + student);
            throw new IllegalArgumentException("This student does not exist in our database : " + student.getId());
        }
        studentDB.save(student);
        log.info(PAE.class + "(updateStudent) The student has been updated : " + student);
    }

    public Iterable<Student> getStudentsNameContaining(String name) throws Exception{
        try {
            log.info("Tous les étudiants: " + studentDB.findAll());
            return studentDB.findByNameContainingIgnoreCase(name);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
