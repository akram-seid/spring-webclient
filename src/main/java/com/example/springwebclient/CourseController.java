package com.example.springwebclient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getCourses(){
        return new ResponseEntity<>(courseService.findall(),HttpStatus.OK);
    }

    @GetMapping("/laptops")
    public ResponseEntity<?> findLaptops(){
        return new ResponseEntity<>(courseService.findLaptops(),HttpStatus.OK);
    }
}
