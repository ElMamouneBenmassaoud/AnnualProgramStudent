package g58112.webg5.pae.model;

import g58112.webg5.pae.BeanValidationUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTest {

    @Autowired
    private BeanValidationUtil<Course> validator;

    @Test
    public void entityIsValid() {
        Course course = new Course("PAE2", "Projet d'Application en Entreprise", 5);
        validator.assertIsValid(course);
    }

    @Test
    public void idIsBlank() {
        Course course = new Course(null, "Projet d'Application en Entreprise", 5);
        validator.assertHasError(course, "id", NotBlank.class);
    }

    @Test
    public void idSizeIsLessThan4() {
        Course course = new Course("PA", "Projet d'Application en Entreprise", 5);
        validator.assertHasError(course, "id", Size.class);
    }

    @Test
    public void idSizeIsMoreThan10() {
        Course course = new Course("PAE2PAE2PAE2", "Projet d'Application en Entreprise", 5);
        validator.assertHasError(course, "id", Size.class);
    }

    @Test
    public void idPatternIsNotValid() {
        Course course = new Course("2PAE2", "Projet d'Application en Entreprise", 5);
        validator.assertHasError(course, "id", Pattern.class);
    }

    @Test
    public void titleIsBlank() {
        Course course = new Course("PAE2", "", 5);
        validator.assertHasError(course, "title", NotBlank.class);
    }

    @Test
    public void titleSizeIsMoreThan100() {
        Course course = new Course("PAE2", "Morbi leo mi, nonummy eget, tristique non, rhoncus non, leo. Nullam faucibus mi quis velit. Integer in sapien. Fusce tellus odio, dapibus id, fermentum quis, suscipit id, erat. Fusce aliquam vestibulum ipsum. Aliquam erat volutpat. Pellentesque sapien. Cras elementum. Nulla pulvinar eleifend sem. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque porta. Vivamus porttitor turpis ac leo. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere.", 5);
        validator.assertHasError(course, "title", Size.class);
    }

    @Test
    public void creditsIsNegative() {
        Course course = new Course("PAE2", "Projet d'Application en Entreprise", -5);
        validator.assertHasError(course, "credits", Positive.class);
    }

    @Test
    public void creditsIsZero() {
        Course course = new Course("PAE2", "Projet d'Application en Entreprise", 0);
        validator.assertHasError(course, "credits", Positive.class);
    }

    @Test
    public void creditsIsPositive() {
        Course course = new Course("PAE2", "Projet d'Application en Entreprise", 5);
        validator.assertIsValid(course);
    }
}