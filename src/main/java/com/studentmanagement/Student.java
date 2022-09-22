package com.studentmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Student {

    private String path = "C:\\Users\\User\\Desktop\\Vimukhi ayya\\StudentManagement\\";
    ObjectMapper mapper = new ObjectMapper();
    Map <String,Integer> results = new HashMap<>();
    public void addStudent(String name, int age) throws IOException {

        Path newPath = Paths.get(path+name+"#"+Integer.toString(age)+".txt");
        if(Files.exists(newPath)){
            System.out.println(name+" "+ Integer.toString(age)+ " is Already Exists");
        } else {
            mapper.writeValue(newPath.toFile(),Map.class);
        }

    }

    public File[] viewStudent() throws IOException {
        Path newPath = Paths.get(path);
        File file = new File(String.valueOf(newPath));
        File[] fileList = file.listFiles();

        for(File f:fileList){
            System.out.println(f.getName().split("#")[0]+" "+f.getName().split("#")[1].split(".txt")[0]);
        }
        return fileList;

    }

    public void searchStudent(String name, int age){
        Path newPath = Paths.get(path+name+"#"+Integer.toString(age)+".txt");
        if(Files.exists(newPath)){
            System.out.println(name+" is Exists");
        }
        else{
            System.out.println(name+" does not Exists");
        }
    }

    public void deleteStudent(String name, int age) throws IOException {
        Path newPath = Paths.get(path+name+"#"+Integer.toString(age)+".txt");
        Files.delete(newPath);
    }

    public void addSubjectMarks(String student, int age, String subject, int mark) throws IOException {

        Path newPath = Paths.get(path+student+"#"+Integer.toString(age)+".txt");
        try {
            results = mapper.readValue(newPath.toFile(), Map.class);

            if (results.keySet().contains(subject)) {

                results.put(subject, mark);

                mapper.writeValue(newPath.toFile(), results);
                System.out.println("added");
            } else {
                System.out.println("there is no subject as " + subject + " to " + student);
            }
        } catch (Exception e){
            System.out.println("There is no data in the file");
        }
    }

}
