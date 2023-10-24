package g58112.webg5.pae.database;

import g58112.webg5.pae.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import g58112.webg5.pae.database.CourseDB;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Launcher implements CommandLineRunner{

    @Autowired
    private CourseDB courseDB;

    @Override
    public void run(String... args) {
        log.info("CourseTable:" + courseDB.findAll().toString());
        log.info("CourseTable:" + courseDB.findAll().toString());
    }
}
