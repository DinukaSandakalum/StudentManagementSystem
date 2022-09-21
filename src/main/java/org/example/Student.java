package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Student {

    private String stdName;
    private int stdAge;
    private String path = "C:\\Users\\User\\Desktop\\Vimukhi ayya\\StudentManagement\\";

    ObjectMapper mapper = new ObjectMapper();

    Map <String,Integer> results = new HashMap<>();

    public void addStudent() throws IOException {

        Path newPath = Paths.get(path+stdName+"#"+Integer.toString(stdAge)+".txt");
        if(Files.exists(newPath)){
            System.out.println(stdName+" "+ Integer.toString(stdAge)+ " is Already Exists");
        } else {
            Files.createFile(newPath);
        }

    }

    public void viewStudent() throws IOException {
        Path newPath = Paths.get(path);
        File file = new File(String.valueOf(newPath));
        File[] fileList = file.listFiles();

        for(File f:fileList){
            System.out.println(f.getName().split("#")[0]+" "+f.getName().split("#")[1].split(".txt")[0]);
        }

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

    public void deleteStudent() throws IOException {
        Path newPath = Paths.get(path+stdName+"#"+Integer.toString(stdAge)+".txt");
        Files.delete(newPath);
    }

    public void addSubjectMarks(Subject markSubject, int mark) throws IOException {
        if(results.keySet().contains(markSubject.getSubName())){
            results.put(markSubject.getSubName(),mark);
            Path newPath = Paths.get(path+stdName+"#"+Integer.toString(stdAge)+"results.txt");
            results.put(markSubject.getSubName(),mark);

            mapper.writeValue(newPath.toFile(), results.entrySet());
            System.out.println("added");
        }
        else {
            System.out.println("there is no subject as "+markSubject.getSubName()+" to "+stdName);
        }
    }

    public Student(String stdName, int stdAge) {
        this.stdName = stdName;
        this.stdAge = stdAge;
    }

    public Student() {
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }

    @Override
    public String toString() {
        return results.keySet().toString();
    }
}
