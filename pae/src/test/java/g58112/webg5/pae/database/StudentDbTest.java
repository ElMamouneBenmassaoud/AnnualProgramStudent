package g58112.webg5.pae.database;

import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Gender;
import g58112.webg5.pae.model.Section;
import g58112.webg5.pae.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentDbTest {

    @Autowired
    private StudentDB studentDB;

    @Autowired
    private CourseDB courseDB;

    @BeforeEach
    public void setUp() {
        // Supprimer toutes les données de la base de données de test avant chaque test
        studentDB.deleteAll();
    }

    @Test
    public void getStudentNames() {
        Student student1 = new Student("John", Gender.FEMALE, Section.RESEAU);
        Student student2 = new Student("Mamoun", Gender.MALE, Section.GESTION);
        studentDB.save(student1);
        studentDB.save(student2);

        List<String> excepted = new ArrayList<>(Arrays.asList("John", "Mamoun"));
        List<String> found = studentDB.getStudentNames();
        assertEquals(excepted, found);
        assertEquals(2, found.size());
    }

}
