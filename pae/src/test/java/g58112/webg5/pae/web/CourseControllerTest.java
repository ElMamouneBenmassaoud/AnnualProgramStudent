package g58112.webg5.pae.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCoursesHome() throws Exception {
        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(view().name("courses"))
                .andExpect(content().string(Matchers.containsString("WEBG5")));
    }

    @Test
    public void testStudentsHome() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"))
                .andExpect(content().string(Matchers.containsString("Mamoun El Benmassoud")));
    }

    @Test
    public void testStudentDetails() throws Exception {
        mockMvc.perform(get("/students/1/details"))
                .andExpect(status().isOk())
                .andExpect(view().name("student"))
                .andExpect(content().string(Matchers.containsString("MALE")));
    }

    @Test
    public void testStudentDetailsNotFound() throws Exception {
        mockMvc.perform(get("/students/999/details"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(content().string(Matchers.containsString("ERROR 404")));
    }
}
