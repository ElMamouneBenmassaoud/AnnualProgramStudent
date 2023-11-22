package g58112.webg5.pae.business;

import g58112.webg5.pae.database.CourseDB;
import g58112.webg5.pae.database.StudentDB;
import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Gender;
import g58112.webg5.pae.model.Section;
import g58112.webg5.pae.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDB studentDB;

    @BeforeEach
    public void setUp() {
        Mockito.reset(studentDB);
    }

    @Test
    public void testGetStudents() throws Exception {
        Student student = new Student("Mamoun", Gender.MALE, Section.RESEAU);
        List<Student> expected = List.of(student);
        Mockito.when(studentDB.findAll()).thenReturn(expected);
        Iterable<Student> found = studentService.getStudents();
        assertEquals(expected, found);
    }

    @Test
    public void findByNameContainingIgnoreCase() throws Exception {
        String name = "mam";
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        List<Student> expected = List.of(student);
        Mockito.when(studentDB.findByNameContainingIgnoreCase(name)).thenReturn(expected);
        Iterable<Student> found = studentService.getStudentsNameContaining(name);
        assertEquals(expected, found);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(true);

        studentService.updateStudent(student);

        Mockito.verify(studentDB, Mockito.times(1)).save(student);
    }

    @Test
    public void testUpdateStudentNotFound() {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(student));

        Mockito.verify(studentDB, Mockito.times(0)).save(student);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(false);

        studentService.addStudent(student);

        Mockito.verify(studentDB, Mockito.times(1)).save(student);
    }

    @Test
    public void testAddStudentAlreadyExists() {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(student));

        Mockito.verify(studentDB, Mockito.times(0)).save(student);
    }

    @Test
    public void testGetStudent() throws Exception {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(true);
        Mockito.when(studentDB.findById(any())).thenReturn(java.util.Optional.of(student));

        Student foundStudent = studentService.getStudent(student.getId());

        assertEquals(foundStudent, student);
    }

    @Test
    public void testGetCourseNotFound() throws Exception {
        Student student = new Student("Mamoun", Gender.MALE, Section.GESTION);
        Mockito.when(studentDB.existsById(any())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> studentService.getStudent(student.getId()));
    }

}
