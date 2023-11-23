package g58112.webg5.pae.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
public class Course {
    @NotBlank @Size(min=4 , max=10, message = "Le nombre de caractère doit etre compris entre 4 et 10 caractères !")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]*$",message="Le sigle est composé de chiffres et de lettres et doit commencer par une lettre.")
    @Id
    private String id;

    @NotBlank @Size(max=100)
    private String title;

    @NotNull @Positive
    private int credits;

    public Course(String id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    @ManyToMany
    @JsonIgnore
    private Set<Student> students;


}
