package com.studentmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Grade {

    ObjectMapper mapper = new ObjectMapper();
    public void findGrades() throws IOException {

        Student std = new Student();
        File[] stdList = std.viewStudent();
        Map<String,Integer> map;
        ArrayList<String> average = new ArrayList<>();

        for(File file:stdList){
            map = mapper.readValue(file,Map.class);
            double total = 0;
            double avg = 0;
            for (int j:map.values()) {
                total = total + j;
            }
                avg = total / map.size();
                if (avg < 10) {
                    average.add("0" + Double.toString(avg) + "#" + file.getName().split("#")[0]);
                } else {
                    average.add(Double.toString(avg) + "#" + file.getName().split("#")[0]);
                }

        }

        System.out.println(average);

        Collections.sort(average);

        System.out.println("Grades :");

        int place = 1;

        for(int j=average.size()-1; j>=0; j--){
            int i=average.size()-j;
            if (j!=average.size()-1){
                if (average.get(j).split("#")[0].equals(average.get(j+1).split("#")[0]))  {
                    System.out.println(Integer.toString(place) + " : " + average.get(j).split("#")[1]);
                }
                else{
                    System.out.println(Integer.toString(i) + " : " + average.get(j).split("#")[1]);
                    place = i;
                }
            }
            else{
                System.out.println(Integer.toString(i) + " : " + average.get(j).split("#")[1]);
                place = i;
            }
        }
        }



        /*ArrayList<String> average = new ArrayList<>();

        for(Student i: stdList){
            double total = 0;
            double avg = 0;
            for (int j:i.results.values()){
                total = total +j;
            }

            avg = total/i.results.size();
            if(avg<10) {
                average.add("0"+Double.toString(avg) + "#" + i.getStdName());
            }
            else{
                average.add(Double.toString(avg) + "#" + i.getStdName());
            }
        }

        System.out.println(average);

        Collections.sort(average);

        System.out.println("Grades :");

        int place = 1;

        for(int j=average.size()-1; j>=0; j--){
            int i=average.size()-j;
            if (j!=average.size()-1){
                if (average.get(j).split("#")[0].equals(average.get(j+1).split("#")[0]))  {
                    System.out.println(Integer.toString(place) + " : " + average.get(j).split("#")[1]);
                }
                else{
                    System.out.println(Integer.toString(i) + " : " + average.get(j).split("#")[1]);
                    place = i;
                }
            }
            else{
                System.out.println(Integer.toString(i) + " : " + average.get(j).split("#")[1]);
                place = i;
            }
        }*/


}
