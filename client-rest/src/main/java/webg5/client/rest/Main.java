package webg5.client.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    /**
	 * WARNING: this client is set on the port: 8081 because it has to be launch in the same time as the service app
	 * To change the port : main -> java -> resources -> application.properties
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Course[] courses = ClientRest.callRestCourses("http://localhost:8080/api/courses");
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}

}
