package com.example.springwebclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CourseService {


    private final WebClient webClient;

    public CourseService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Course save(Course course) {

        return new Course();
         }



         public List<Course> findall() {
             return this.webClient
                     .get()
                     .uri("/get")
                     .retrieve()
                     .bodyToMono(new ParameterizedTypeReference<List<Course>>() {})
                     .block();
         }
         public List<Example> findLaptops(){

             return this.webClient
                     .get()
                     .uri("/users")
                     .retrieve()
                     .bodyToMono(new ParameterizedTypeReference<List<Example>>() {})
                     .block();

         }

         public Course saveCourse(Course course){
             return course = webClient
                     .post()
                     .uri("/add")
                     .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                     .body(Mono.just(course), Course.class)
                     .retrieve()
                     .bodyToMono(Course.class)
                     .block();
         }
}
