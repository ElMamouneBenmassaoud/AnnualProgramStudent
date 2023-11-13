package g58008.associations;

import g58008.associations.model.Book;
import g58008.associations.model.School;
import g58008.associations.service.MtmUnidirectional;
import g58008.associations.service.MtoUnidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MtmUnidirectionalController {
    @Autowired
    private MtmUnidirectional mtmUnidirectional;

    @GetMapping("/book/create")
    public ResponseEntity<String> createBook(Model model) {
        mtmUnidirectional.addBook(1L, "Les histoires de Mams");
        return new ResponseEntity<>("Book created", HttpStatus.OK);
    }

    @GetMapping("/author/create")
    public ResponseEntity<String> createAuthor(Model model) {
        mtmUnidirectional.addAuthor(1L, "Mamoun");
        return new ResponseEntity<>("Author created", HttpStatus.OK);
    }

    @GetMapping("/book/addAuth/{authId}/{bookId}")
    public ResponseEntity<String> addEmpToDpt(Model model, @PathVariable("authId") Long authId, @PathVariable("bookId") Long bookId) {
        mtmUnidirectional.addAuthorToBook(authId, bookId);
        return new ResponseEntity<>("Author added to a book", HttpStatus.OK);
    }
}
