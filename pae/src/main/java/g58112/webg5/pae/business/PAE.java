package g58112.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import g58112.webg5.pae.model.Course;
import lombok.Getter;

@Service
public class PAE {
    
    @Getter
    private final static List<Course> courses = new ArrayList<>();
    public static final Logger log = LoggerFactory.getLogger(PAE.class);

    public static void addCourse(Course course) {
        log.info("Nouveau cours ajouté : " + course.toString());
        courses.add(course);
    }

}
