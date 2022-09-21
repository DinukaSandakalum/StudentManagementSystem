package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Subject {
    ObjectMapper mapper = new ObjectMapper();
    private String subName;
    ArrayList<String> subjects;

    String path = "C:\\Users\\User\\Desktop\\Vimukhi ayya\\StudentManagement\\";

    public Subject(String subName) {
        this.subName = subName;
    }

    public Subject() {
    }

    public void addSubject(Student std) throws IOException {
        Path newPath = Paths.get(path+std.getStdName()+"#"+Integer.toString(std.getStdAge())+".txt");
        std.results.put(subName,0);

        mapper.writeValue(newPath.toFile(), std.results.keySet().toString());
    }

    public void viewSubject(Student std) throws IOException {
        Path newPath = Paths.get(path+std.getStdName()+"#"+Integer.toString(std.getStdAge())+".txt");

        String s = mapper.readValue(newPath.toFile(),String.class);
        String s1 = s.replace("[","");
        String s2 = s1.replace("]","");

        subjects = new ArrayList<>(List.of(s2.split(", ")));

        System.out.println("These are the subjects of "+std.getStdName());

        for(String a: subjects) {
            System.out.println(a);
        }
    }

    public void deleteSubject(Student std) throws IOException {

        viewSubject(std);
        if (std.results.keySet().contains(subName)){
            std.results.remove(subName);
            Path newPath = Paths.get(path+std.getStdName()+"#"+Integer.toString(std.getStdAge())+".txt");
            mapper.writeValue(newPath.toFile(), std.results.keySet().toString());
            System.out.println("removed");
        }
        else{
            System.out.println("There is no Subject as "+subName+" in the "+std.getStdName()+"'s Subjects.");
        }
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
