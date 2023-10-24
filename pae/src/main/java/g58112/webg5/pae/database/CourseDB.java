package g58112.webg5.pae.database;

import org.springframework.data.repository.CrudRepository;

import g58112.webg5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {
    
}
