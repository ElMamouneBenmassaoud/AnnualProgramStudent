package g58008.associations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Actor {

    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Actor(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}