package g58112.webg5.pae.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("students")
public class Student {

    @GeneratedValue(generator = "matricule_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "matricule_gen", sequenceName = "matricule_seq", initialValue = 2)
    @Id
    private int id;

    @NotBlank(message = "Name must be specified")
    @Size(max=100,  message = "The name is too long (max 100char)")
    @Pattern(regexp = "^[A-Za-z\\- ']+$", message = "Le nom doit être composé que de lettres.")
    private String name;


    @NotNull(message = "Gender must be specified")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Section must be specified")
    @Enumerated(EnumType.STRING)
    private Section section;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Course> courses;

    public Student(String name, Gender gender, Section section) {
        this.name = name;
        this.gender = gender;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", section=" + section +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && gender == student.gender && section == student.section;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, section);
    }
}
