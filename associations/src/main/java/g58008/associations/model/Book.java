package g58008.associations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    private Set<Author> authors;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        this.authors.add(author);
    }
}

