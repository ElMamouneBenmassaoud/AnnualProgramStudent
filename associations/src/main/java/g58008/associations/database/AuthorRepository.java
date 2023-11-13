package g58008.associations.database;

import g58008.associations.model.Author;
import g58008.associations.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
