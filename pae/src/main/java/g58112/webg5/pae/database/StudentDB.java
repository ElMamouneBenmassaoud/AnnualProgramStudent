package g58112.webg5.pae.database;

import g58112.webg5.pae.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDB extends CrudRepository<Student, Integer> {
    
}
