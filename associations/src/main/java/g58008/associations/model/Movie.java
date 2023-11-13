package g58008.associations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    public void addActor(Actor actor) {
        actors.add(actor);
        actor.addMovie(this);
    }

    public Movie(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}