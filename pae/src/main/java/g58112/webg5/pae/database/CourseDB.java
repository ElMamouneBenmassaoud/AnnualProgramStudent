package g58112.webg5.pae.database;

import org.springframework.data.repository.CrudRepository;

import g58112.webg5.pae.model.Course;

import java.util.List;

public interface CourseDB extends CrudRepository<Course, String> {

    /**
     * Find all courses with credits greater than or equal to the given credits
     * example of use : findByCreditsGreaterThanEqual(5)
     * using a template from JPA repositories to complete the function
     * @param credits the credits to compare
     * @return a list of courses
     */
    public List<Course> findByCreditsGreaterThanEqual(int credits);

    /**
     * Find all courses with title containing the given title
     * example of use : return courseRepository.findByTitleContaining("Organisation");
     * using a template from JPA repositories to complete the function
     * @param title the title to compare
     * @return a list of courses
     */
    public List<Course> findByTitleContainingIgnoreCase(String title);
}
