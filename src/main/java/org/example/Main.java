package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student st1 = new Student("Dinuka", 26);
        Student st2 = new Student("Kalana", 25);
        Student st3 = new Student("Subhash", 30);
        Student st4 = new Student("Danushka", 32);
        Student students = new Student();
        Subject subjects = new Subject();
        Grade grade = new Grade();
        ArrayList<Student> arrlistStd = new ArrayList<>();
        arrlistStd.add(st1);
        arrlistStd.add(st2);
        arrlistStd.add(st3);

        try {
            st1.addStudent();
            st2.addStudent();
            st3.addStudent();
            st4.addStudent();

            System.out.println();
            students.viewStudent();

            System.out.println();
            students.searchStudent("Dinuka",26);
            students.searchStudent("aaa",20);

            Subject s1 = new Subject("Physics");
            Subject s2 = new Subject("Chemistry");
            Subject s3 = new Subject("Combined_Mathematics");
            Subject s4 = new Subject("Commerce");
            Subject s5 = new Subject("Biology");

            System.out.println();
            s1.addSubject(st1);
            s2.addSubject(st1);
            s3.addSubject(st1);

            System.out.println();
            subjects.viewSubject(st1);

            System.out.println();
            s1.addSubject(st2);
            s2.addSubject(st2);
            s3.addSubject(st2);
            s4.addSubject(st2);
            s5.addSubject(st2);

            System.out.println();

            s4.deleteSubject(st2);

            System.out.println();
            subjects.viewSubject(st2);

            s1.addSubject(st3);
            s2.addSubject(st3);
            s3.addSubject(st3);
            s5.addSubject(st3);
            s4.deleteSubject(st3);

            System.out.println();

            st1.addSubjectMarks(s1,80);
            st1.addSubjectMarks(s2,65);
            st1.addSubjectMarks(s3,72);

            st2.addSubjectMarks(s1,90);
            st2.addSubjectMarks(s2,80);
            st2.addSubjectMarks(s3,70);
            st2.addSubjectMarks(s4,80);
            st2.addSubjectMarks(s5,90);

            st3.addSubjectMarks(s1,90);
            st3.addSubjectMarks(s2,80);
            st3.addSubjectMarks(s3,70);
            st3.addSubjectMarks(s4,80);
            st3.addSubjectMarks(s5,90);

            System.out.println();

            grade.findGrades(arrlistStd);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}