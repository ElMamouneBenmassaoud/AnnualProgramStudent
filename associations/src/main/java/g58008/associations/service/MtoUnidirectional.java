package g58008.associations.service;

import g58008.associations.database.SchoolRepository;
import g58008.associations.database.StudentRepository;
import g58008.associations.model.School;
import g58008.associations.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Crée une association entre Student et School en uni-directional et Many To One.
 * Le lien est créé via un attribut school dans la table Student.
 * WARNING : Aucune vérification, aucun display, que des urls.
 * WARNING : School doit être créé avant Student.
 * HELP :
 * /school/create -> create and store an employee in the database
 * /student/create -> create and store a department in the database
 */
@Service
public class MtoUnidirectional {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    public void addStudent(Long id, String name, School school) {
        studentRepository.save(new Student(id, name, school));
    }

    public void addSchool(Long id, String name) {
        schoolRepository.save(new School(id, name));
    }
}
