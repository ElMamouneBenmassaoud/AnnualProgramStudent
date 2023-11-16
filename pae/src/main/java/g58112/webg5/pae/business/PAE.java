package g58112.webg5.pae.business;

import g58112.webg5.pae.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g58112.webg5.pae.model.Course;

@Service
@Slf4j
public class PAE {

    @Autowired
    private StudentService studentService;

    @Autowired
    CourseService courseService;

    public Iterable<Student> getStudents() throws Exception{
        return studentService.getStudents();
    }

    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    public Student getStudent(int studentId) throws Exception{
        return studentService.getStudent(studentId);
    }

    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }

    public Iterable<Course> getCourses() throws Exception{
        return courseService.getCourses();
    }

    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    public Course getCourse(String courseId) throws Exception{
        return courseService.getCourse(courseId);
    }

    public void enrollStudentToCourse(int studentId, String courseId) throws Exception {
        System.out.println("enrollStudentToCourse PAE");

        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        if (course.getStudents().contains(student)) {
            throw new IllegalArgumentException("This student is already enrolled in this course");
        }
        enrollStudent(course, student);
        courseService.updateCourse(course);
    }

    /**
     * Enroll a student in the course
     * this function keep consistency.
     * @param course the course to register
     * @param student the student to enroll
     */
    private void enrollStudent(Course course, Student student) {
        System.out.println("enrollStudent private");
        course.getStudents().add(student);
        student.getCourses().add(course);
    }

    public Iterable<Student> getStudentsNameContaining(String name) throws Exception{
        return studentService.getStudentsNameContaining(name);
    }
}
