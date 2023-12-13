package test;

import school.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(0,"Dear",100);
        Student s2 = new Student(1,"Tae",50);
        System.out.println(s1);
        System.out.println(Student.ListAll());

    }
}