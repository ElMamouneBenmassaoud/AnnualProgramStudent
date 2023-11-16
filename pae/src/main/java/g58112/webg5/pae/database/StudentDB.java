package g58112.webg5.pae.database;

import g58112.webg5.pae.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDB extends CrudRepository<Student, Integer> {
    /**
     * Get all students name
     *
     * @return a list for all students with their name
     */
    @Query("SELECT s.name FROM Student s")
    public List<String> getStudentNames();

    /**
     * Get all students' id and their name
     *
     * @return a list for all students with their id and name as objects
     */
    @Query("SELECT s.name, s.id FROM Student s")
    public List<Object[]> getStudentNamesAndId();

    /**
     * Get all students' name and their total of credits
     *
     * @return a list for all students with their name and the total of credits as objects
     */
    @Query(value = "SELECT s.name, SUM(c.credits) FROM Student s JOIN s.courses c GROUP BY s.name")
    public List<Object[]> getStudentsNameAndTotalCredits();

    /**
     * Get all students who have their PAE with more credits that the given value
     *
     * @param credits the value to compare credits
     * @return all students as a list
     */
    @Query("SELECT s FROM Student s JOIN s.courses c GROUP BY s.name HAVING SUM(c.credits) > :credits")

    public List<Student> getStudentsMoreCreditsThan(int credits);

    /**
     * Find all students with name containing the given name
     * example of use : return studentRepository.findByNameContaining("John");
     * using a template from JPA repositories to complete the function
     *
     * @param name the name to compare
     * @return a list of students
     */
    public List<Student> findByNameContainingIgnoreCase(String name);
}
