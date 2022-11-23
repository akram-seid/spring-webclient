package com.example.springwebclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    private int id;
    private String courseCode;
    private String courseName;


}
