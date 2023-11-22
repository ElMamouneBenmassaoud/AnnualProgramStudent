package g58112.webg5.pae.business;

import g58112.webg5.pae.database.CourseDB;
import g58112.webg5.pae.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseDB courseDB;

    @BeforeEach
    public void setUp() {
        Mockito.reset(courseDB);
    }

    @Test
    public void testGetCourses() throws Exception {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Course course2 = new Course("ATLG4", "ATELIER LOGICIEL",5); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.findAll()).thenReturn(Arrays.asList(course1, course2));

        Iterable<Course> courses = courseService.getCourses();

        Iterator<Course> courseIterator = courses.iterator();
        Course foundCourse1 = courseIterator.next();
        Course foundCourse2 = courseIterator.next();
        assertEquals(foundCourse1, course1);
        assertEquals(foundCourse2, course2);
    }

    @Test
    public void testAddCourse() {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(false);

        courseService.addCourse(course1);

        Mockito.verify(courseDB, Mockito.times(1)).save(course1);
    }

    @Test
    public void testAddCourseAlreadyExists() {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> courseService.addCourse(course1));

        Mockito.verify(courseDB, Mockito.times(0)).save(course1);
    }

    @Test
    public void testGetCourse() throws Exception {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(true);
        Mockito.when(courseDB.findById(any())).thenReturn(java.util.Optional.of(course1));

        Course foundCourse = courseService.getCourse(course1.getId());

        assertEquals(foundCourse, course1);
    }

    @Test
    public void testGetCourseNotFound() throws Exception {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> courseService.getCourse(course1.getId()));
    }

    @Test
    public void testUpdateCourse() {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(true);

        courseService.updateCourse(course1);

        Mockito.verify(courseDB, Mockito.times(1)).save(course1);
    }

    @Test
    public void testUpdateCourseNotFound() {
        Course course1 = new Course("WEBG4", "DEVELOPPEMENT WEB",3); // Remplacez par vos valeurs réelles
        Mockito.when(courseDB.existsById(any())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> courseService.updateCourse(course1));

        Mockito.verify(courseDB, Mockito.times(0)).save(course1);
    }
}
