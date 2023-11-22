package g58112.webg5.pae.database;

import g58112.webg5.pae.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CourseDbTest {
    @Autowired
    private CourseDB courseDB;

    @BeforeEach
    public void setUp() {
        // Supprimer toutes les données de la base de données de test avant chaque test
        courseDB.deleteAll();
    }

    @Test
    public void findByCreditsGreaterThanEqual() {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Course course2 = new Course("ATLG4", "ATELIER LOGICIEL",5); // Remplacez par vos valeurs réelles
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> courses = courseDB.findByCreditsGreaterThanEqual(4);
        assertEquals(1, courses.size());
        assertTrue(courses.contains(course2));
    }

    @Test
    public void findByTitleContainingIgnoreCase() {
        Course course1 = new Course("ATLG2", "Atelier Logiciel 2",3); // Remplacez par vos valeurs réelles
        Course course2 = new Course("ATLG4", "ATELIER LOGICIEL",5);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> courses = courseDB.findByTitleContainingIgnoreCase("LOGICIEL");
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course2));
        assertTrue(courses.contains(course1));
    }
}
