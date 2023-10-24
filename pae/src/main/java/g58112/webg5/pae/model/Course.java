package g58112.webg5.pae.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @NotBlank @NotNull @Size(min=4 , max=10, message = "Le nombre de caractère doit etre compris entre 4 et 10 caractères !") 
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]*$",message="Le sigle est composé de chiffres et de lettres et doit commencer par une lettre.")
    @Id
    private String id;

    @NotBlank @NotNull @Size(max=100)
    private String title;

    @NotNull @Positive
    private int credits;
}
