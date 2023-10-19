package g58112.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import g58112.webg5.pae.model.Course;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PAE {
    
    @Getter
    private final static List<Course> courses = new ArrayList<>();
    
    static {
        courses.add(new Course("INT1", "Introduction I", 10));
        courses.add(new Course("DEV3", "Développement III", 5));
        courses.add(new Course("WEBG5", "Web III", 5));
    }


    public static void addCourse(Course course) {
        log.info("Nouveau cours ajouté : " + course.toString());
        courses.add(course);
    }

    public static Course getCourse(String courseId){
        for(Course course : courses){
            if(Objects.equals(course.getId(), courseId)) return course;
        }
        throw new IllegalArgumentException("This course was not provide in our datbase" + courseId);
    }

}
