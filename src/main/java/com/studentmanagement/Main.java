package com.studentmanagement;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        Student studentsAll = new Student();
        Subject subjectAll = new Subject();
        Grade grades = new Grade();


        while(true) {

            try {

            System.out.println("Select Option : ");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Subjects");
            System.out.println("3. Find Grades");
            System.out.println("4. Exit");

            int frontInput;

                System.out.println("Enter Selection : ");
                frontInput = Integer.parseInt(scn.nextLine());

                if (frontInput == 1) {
                    while (true) {
                        System.out.println("1 >>");
                        System.out.println("1. Add Students");
                        System.out.println("2. View Students");
                        System.out.println("3. Find Student");
                        System.out.println("4. Delete Student");
                        System.out.println("5. Add Subject Marks");
                        System.out.println("6. Back");

                        int frontStdInput;

                        try {
                            System.out.print("Enter Selection : ");
                            frontStdInput = Integer.parseInt(scn.nextLine());

                            if (frontStdInput == 1) {
                                try {
                                    String nameStdInput;
                                    int ageStdInput;
                                    System.out.print("Enter name : ");
                                    nameStdInput = scn.next();
                                    System.out.print("Enter age : ");
                                    ageStdInput = scn.nextInt();

                                    Student newStudent = new Student();
                                    newStudent.addStudent(nameStdInput, ageStdInput);
                                } catch (Exception e) {
                                    System.out.println("Adding student inputs are wrong");
                                }

                            } else if (frontStdInput == 2) {
                                studentsAll.viewStudent();

                            } else if (frontStdInput == 3) {
                                try {
                                    String nameStdInput;
                                    int ageStdInput;
                                    System.out.print("Enter name : ");
                                    nameStdInput = scn.next();
                                    System.out.print("Enter age : ");
                                    ageStdInput = scn.nextInt();
                                    studentsAll.searchStudent(nameStdInput, ageStdInput);
                                } catch (Exception e) {
                                    System.out.println("Searching inputs are wrong");
                                }

                            } else if (frontStdInput == 4) {
                                try {
                                    String nameStdInput;
                                    int ageStdInput;
                                    System.out.print("Enter name : ");
                                    nameStdInput = scn.next();
                                    System.out.print("Enter age : ");
                                    ageStdInput = scn.nextInt();
                                    studentsAll.deleteStudent(nameStdInput, ageStdInput);
                                } catch (Exception e) {
                                    System.out.println("Deleting inputs are wrong");
                                }
                            } else if (frontStdInput == 5) {
                                try {
                                    String student;
                                    int age;
                                    int marks;
                                    String subject;
                                    System.out.print("Enter Student name : ");
                                    student = scn.next();
                                    System.out.print("Enter Age : ");
                                    age = scn.nextInt();
                                    System.out.print("Enter Subject : ");
                                    subject = scn.next();
                                    System.out.print("Enter Marks : ");
                                    marks = scn.nextInt();
                                    studentsAll.addSubjectMarks(student, age, subject, marks);
                                } catch (Exception e) {
                                    System.out.println("Inputs are wrong");
                                }
                            } else if (frontStdInput == 6) {
                                break;
                            } else {
                                System.out.println("wrong input");
                            }

                        } catch (Exception e) {
                            System.out.println("Please enter a valid selection");
                        }

                    }
                } else if (frontInput == 2) {
                    while (true) {
                        System.out.println("2 >>");
                        System.out.println("1. Add Subjects");
                        System.out.println("2. View Subjects");
                        System.out.println("3. Delete Subject");
                        System.out.println("4. Back");

                        try {

                            int frontSubInput;
                            System.out.println("Enter selection");
                            frontSubInput = Integer.parseInt(scn.nextLine()) ;

                            if (frontSubInput == 1) {
                                try {
                                    String student;
                                    int age;
                                    String subject;
                                    System.out.print("Enter Student Name : ");
                                    student = scn.next();
                                    System.out.print("Enter Student Age : ");
                                    age = scn.nextInt();
                                    System.out.print("Enter Subject name : ");
                                    subject = scn.next();
                                    subjectAll.addSubject(student, age, subject);
                                } catch (Exception e) {
                                    System.out.println("Input Subject details are wrong");
                                }
                            } else if (frontSubInput == 2) {
                                try {
                                    String student;
                                    int age;
                                    System.out.print("Enter Student Name : ");
                                    student = scn.next();
                                    System.out.print("Enter Student Age : ");
                                    age = scn.nextInt();
                                    subjectAll.viewSubject(student, age);
                                } catch (Exception e) {
                                    System.out.println("Student details are wrong");
                                }
                            } else if (frontSubInput == 3) {
                                try {
                                    String student;
                                    int age;
                                    String subject;
                                    System.out.print("Enter Student Name : ");
                                    student = scn.next();
                                    System.out.print("Enter Student Age : ");
                                    age = scn.nextInt();
                                    System.out.print("Enter Subject name : ");
                                    subject = scn.next();
                                    subjectAll.deleteSubject(student, age, subject);
                                } catch (Exception e) {
                                    System.out.println("Wrong details");
                                }
                            } else if (frontSubInput == 4) {
                                break;
                            } else {
                                System.out.println("wrong input");
                            }
                        } catch (Exception e){
                            System.out.println("PLease add valid input");
                        }

                    }

                } else if (frontInput == 3) {
                    boolean frontGrade = true;
                    while (frontGrade = true) {
                        System.out.println("3 >>");
                        System.out.println("1. Find all grades");
                        System.out.println("2. Back");

                        try {
                            System.out.print("Enter Selection : ");
                            frontInput = Integer.parseInt(scn.nextLine());

                            if (frontInput == 1) {
                                try {
                                    grades.findGrades();
                                } catch (Exception e) {
                                    System.out.println("Marks did not enter correctly");
                                }
                            } else if (frontInput == 2) {
                                break;
                            } else {
                                System.out.println("wrong input");
                            }
                        } catch (Exception e){
                            System.out.println("Invalid Input");
                        }
                    }

                } else if (frontInput == 4) {
                    break;
                } else {
                    System.out.println("Please Enter a valid input");
                }

            } catch (Exception e){
                System.out.println("Please enter a valid selection");

            }
        }
    }
}