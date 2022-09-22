package com.studentmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;


public class Subject {
    ObjectMapper mapper = new ObjectMapper();
    Student std = new Student();
    String path = "C:\\Users\\User\\Desktop\\Vimukhi ayya\\StudentManagement\\";

    public void addSubject(String student, int age, String subject) throws IOException {


        Path newPath = Paths.get(path+student+"#"+Integer.toString(age)+".txt");

        try {
            std.results = mapper.readValue(newPath.toFile(), Map.class);
        }
        catch (Exception e){
            System.out.println("There is no data in the file");
        }

        std.results.put(subject, 0);
        mapper.writeValue(newPath.toFile(), std.results);

    }

    public void viewSubject(String student, int age) throws IOException {
        Path newPath = Paths.get(path+student+"#"+Integer.toString(age)+".txt");

        Map<String, Integer> s = mapper.readValue(newPath.toFile(), Map.class);

        System.out.println("These are the subjects of "+student);

        for(String ss: s.keySet() ) {
            System.out.println(ss);
        }
    }

    public void deleteSubject(String student, int age, String subject) throws IOException {

        viewSubject(student, age);
        if (std.results.keySet().contains(subject)){
            std.results.remove(subject);
            Path newPath = Paths.get(path+student+"#"+Integer.toString(age)+".txt");
            mapper.writeValue(newPath.toFile(), std.results.keySet().toString());
            System.out.println("removed");
        }
        else{
            System.out.println("There is no Subject as "+subject+" in the "+student+"'s Subjects.");
        }
    }

}
