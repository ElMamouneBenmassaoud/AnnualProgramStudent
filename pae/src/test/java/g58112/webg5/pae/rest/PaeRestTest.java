package g58112.webg5.pae.rest;

import g58112.webg5.pae.business.PAE;
import g58112.webg5.pae.business.StudentService;
import g58112.webg5.pae.database.StudentDB;
import g58112.webg5.pae.model.Course;
import g58112.webg5.pae.model.Gender;
import g58112.webg5.pae.model.Section;
import g58112.webg5.pae.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PaeRestTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PAE paeService;

    @Test
    public void testGetStudents() throws Exception {
        mvc.perform(get("/api/students/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCourses() throws Exception {
        mvc.perform(get("/api/courses"))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentById() throws Exception {
        String name = "Mamoun";
        Student student = new Student(name, Gender.MALE, Section.GESTION);
        Mockito.when(paeService.getStudent(student.getId())).thenReturn(student);
        mvc.perform(get("/api/students/" + student.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));
    }


    @Test
    public void getCourseById() throws Exception {
        String id = "WEBG5";
        String title = "Web";
        int ects = 5;
        Course course = new Course(id, title, ects);
        Mockito.when(paeService.getCourse(id)).thenReturn(course);
        mvc.perform(get("/api/courses/" + course.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(title));
    }

}
