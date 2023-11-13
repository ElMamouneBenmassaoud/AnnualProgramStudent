package g58008.associations.service;

import g58008.associations.database.ActorRepository;
import g58008.associations.database.MovieRepository;
import g58008.associations.model.Actor;
import g58008.associations.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crée une association entre Movie et Actor en bi-directional et Many To Many
 * WARNING : Aucune vérification, aucun display, que des urls.
 * HELP :
 * /movie/create -> create and store a movie in the database
 * /actor/create -> create and store an actor in the database
 * /movie/addActor/{moveId}/{actorId} -> add an actor to a movie (create a link between them in the db)
 */
@Service
public class MtmBidirectional {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Long id, String title) {
        movieRepository.save(new Movie(id, title));
    }

    public void addActor(Long id, String name) {
        actorRepository.save(new Actor(id, name));
    }

    public void addActorToMovie(Long movieId, Long actorId) {
        Movie movie = movieRepository.findById(movieId).get();
        Actor actor = actorRepository.findById(actorId).get();
        movie.addActor(actor);
        movieRepository.save(movie);
    }
}

