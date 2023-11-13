package g58008.associations;

import g58008.associations.service.MtmBidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MtmBidirectionalController {
    @Autowired
    private MtmBidirectional mtmBidirectional;

    @GetMapping("/movie/create")
    public ResponseEntity<String> createMovie(Model model) {
        mtmBidirectional.addMovie(1L, "Les films de Mams");
        return new ResponseEntity<>("Movie created", HttpStatus.OK);
    }

    @GetMapping("/actor/create")
    public ResponseEntity<String> createActor(Model model) {
        mtmBidirectional.addActor(1L, "Mamoun");
        return new ResponseEntity<>("Actor created", HttpStatus.OK);
    }

    @GetMapping("/movie/addActor/{movieId}/{actorId}")
    public ResponseEntity<String> addActorToMovie(Model model, @PathVariable("movieId") Long movieId, @PathVariable("actorId") Long actorId) {
        mtmBidirectional.addActorToMovie(movieId, actorId);
        return new ResponseEntity<>("Actor added to a movie", HttpStatus.OK);
    }
}
