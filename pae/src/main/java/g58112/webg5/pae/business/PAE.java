package g58112.webg5.pae.business;

import java.util.ArrayList;
import java.util.List;

import g58112.webg5.pae.model.Course;

public class PAE {
    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Mat1", "Maths", 5));
        courses.add(new Course("WEBG5", "Développement web", 5));
        return courses;
    }
}
