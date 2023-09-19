package webg5.spring.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WelcomeControllerTest {

@Autowired
private MockMvc mockMvc; // Permet de simuler le navigateur

 @Test
 public void testWelcomePage() throws Exception {
    mockMvc.perform( get("/welcome?name=mcd")) // L’url à tester
    .andExpect(status().isOk()) // La page est retournée
    .andExpect(view().name("welcome")) // Générée à partir du template welcome
    // Elle contient le texte attendu
    .andExpect(content().string(Matchers.containsString("mcd"))
 );
 }
 }