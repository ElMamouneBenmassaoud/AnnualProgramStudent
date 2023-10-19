package webg5.client.rest;

import org.springframework.web.client.RestTemplate;

public class ClientRest {
     private final static RestTemplate restTemplate = new RestTemplate();

    /**
     * Connect to the api and return his content
     * @param url url of the api
     * @return an array with the different courses
     */
    public static Course[] callRestCourses(String url) {
        try {
            return restTemplate.getForObject(url, Course[].class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new Course[0];
        }
    }

}
