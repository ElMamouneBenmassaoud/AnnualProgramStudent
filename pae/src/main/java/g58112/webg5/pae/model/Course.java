package g58112.webg5.pae.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Course {
    @NotBlank @NotNull @Size(min=4 , max=10, message = "Le nombre de caractère doit etre compris entre 4 et 10 caractères !") 
    @Pattern(regexp = "[A-Za-z][A-Za-z0-9]∗",message="Le login est composé de chiffres et de lettres et doit commencer par une lettre.")
    private String id;

    @NotBlank @NotNull @Size(max=100)
    private String title;

    @NotBlank @NotNull @Positive
    private int credits;

    public Course(String id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    public Course() {
        this.id = "";
        this.title = "";
        this.credits = 0;
    }
}
