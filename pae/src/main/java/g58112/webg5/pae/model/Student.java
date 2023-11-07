package g58112.webg5.pae.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotNull
    @GeneratedValue(generator = "matricule_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "matricule_gen", sequenceName = "matricule_seq", allocationSize = 50)
    @Id
    private int id;

    @NotBlank @NotNull @Size(max=100)
    @Pattern(regexp = "^[A-Za-z\\- ']+$", message = "Le nom doit être composé que de lettres.")
    private String name;

    @NotNull @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull @Enumerated(EnumType.STRING)
    private Section section;
}
