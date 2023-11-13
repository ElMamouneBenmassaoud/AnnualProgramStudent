package g58008.associations.service;

import g58008.associations.database.AuthorRepository;
import g58008.associations.database.BookRepository;
import g58008.associations.model.Author;
import g58008.associations.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crée une association entre Author et Book en uni-directional et Many To Many
 * WARNING : Aucune vérification, aucun display, que des urls.
 * HELP :
 * /author/create -> create and store an author in the database
 * /book/create -> create and store a book in the database
 * /book/addAuth/{authId}/{bookId} -> add an author to a book (create a link between them in the db)
 */
@Service
public class MtmUnidirectional {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void addBook(Long id, String name) {
        bookRepository.save(new Book(id, name));
    }

    public void addAuthor(Long id, String name) {
        authorRepository.save(new Author(id, name));
    }

    public void addAuthorToBook(Long bookId, Long authId) {
        Book book = bookRepository.findById(bookId).get();
        Author author = authorRepository.findById(authId).get();
        book.addAuthor(author);
        bookRepository.save(book);
    }
}
