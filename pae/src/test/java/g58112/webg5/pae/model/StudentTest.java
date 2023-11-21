package g58112.webg5.pae.model;

import g58112.webg5.pae.BeanValidationUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
    @Autowired
    private BeanValidationUtil<Student> validator;

    @Test
    public void entityIsValid() {
        Student student = new Student("Mamoun", Gender.MALE, Section.RESEAU);
        validator.assertIsValid(student);
    }

    @Test
    public void nameIsBlank() {
        Student student = new Student(null, Gender.MALE, Section.RESEAU);
        validator.assertHasError(student, "name", NotBlank.class);
    }

    @Test
    public void nameSizeIsMoreThan100() {
        Student student = new Student("MaurisMaurisMaurMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMaurisMauris",Gender.FEMALE, Section.INDUSTRIELLE);
        validator.assertHasError(student, "name", Size.class);
    }

    @Test
    public void namePatternIsNotValid(){
        Student student = new Student("P1#AE", Gender.FEMALE, Section.RESEAU);
        validator.assertHasError(student, "name", Pattern.class);
    }

    @Test
    public void genderIsNull(){
        Student student = new Student("MAMOUN", null, Section.RESEAU);
        validator.assertHasError(student, "gender", NotNull.class);
    }

    @Test
    public void sectionIsNull(){
        Student student = new Student("MAMOUN", Gender.FEMALE, null);
        validator.assertHasError(student, "section", NotNull.class);
    }
}
