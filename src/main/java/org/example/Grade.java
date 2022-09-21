package org.example;

import java.util.*;

public class Grade {
    public void findGrades(ArrayList<Student> stdList){

        ArrayList<String> average = new ArrayList<>();

        for(Student i: stdList){
            double total = 0;
            double avg = 0;
            for (int j:i.results.values()){
                total = total +j;
            }

            avg = total/i.results.size();
            average.add(Double.toString(avg)+"#"+i.getStdName());

        }

        System.out.println(average);

        Collections.sort(average);

        System.out.println("Grades :");

        for(int j=average.size()-1; j>=0; j--){
            int i=average.size()-j;
            System.out.println(Integer.toString(i)+" : "+average.get(j).split("#")[1]);
        }
    }
}
