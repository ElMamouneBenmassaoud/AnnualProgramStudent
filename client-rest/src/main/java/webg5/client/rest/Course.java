package webg5.client.rest;
import lombok.Getter;

@Getter
public class Course {
    private String id;
    private String title;
    private int credits;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
