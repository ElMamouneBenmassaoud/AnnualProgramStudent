package g58112.webg5.pae.model;

import lombok.Data;

@Data
public class Course {
    private String id;
    private String title;
    private int credits;

    public Course(String id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    public Course() {
        this.id = "";
        this.title = "";
        this.credits = 0;
    }
}
