package school;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class Student implements Comparable<Student> {
    /*
    1) create a public class "Student" in package "school" having 3 private non-static fields:
   "id" (int,final), "name" (String), "allowance" (double).
     */

    /*
    1.5) add 2 private static fields: "all" (of Student array type) to store
     all Students created and "count" (of int type) to count
     the number of Students stored in the array.
     */
    private final int id;
    private String name;
    private double allowance;
    private static Student[] all;
    private static int count;
    /*
    1.6) create a constructor that receives 3 parameters: "id", "name", "allowance"
     to initialize the 3 fields if a Student object can be created.
     A Student object can be created if "name" is not null,
     "allowance" is more than zero, "id" is not negative,
     and the "id" is not already in the Student array ("all").
     If a Student can be created, put it in the array "all" and increment the "count".
    Note that if "all" is null, create an array of size 2 first.
    If "all" is full, double its size.
    If a Student cannot be created, throws an IllegalArgumentException.
     */

    public Student(int id, String name, double allowance) {

        if (name == null || id < 0 || allowance <= 0)
            throw new IllegalArgumentException("Invalid parameters for creating Student");
        for (int i = 0; i < count; i++) {
            if (id == all[i].id) throw new IllegalArgumentException("Invalid parameters for creating Student");
        }
        this.id = id;
        this.name = name;
        this.allowance = allowance;
        if (all == null) all = new Student[2];
        if (count == all.length) {
            Student[] newAll = new Student[all.length * 2];
            all = Arrays.copyOf(all, newAll.length);
        }
        for (int i = 0; i < all.length; i++) {
            if (all[i] == null) {

                all[i] = this;
                count++;
                break;
            }

        }


    }
    /*
    1.1) create setters for all non-static fields except "id",
     and getters for all non-static fields.
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    /*
    1.2) @Override the "equals" and "hashCode" methods using only the "id" of Student.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /*
    1.3) @Override the "toString" method to return a String in this format:
     "Student(id,'name',allowance)".
     */

    @Override
    public String toString() {
        return String.format("Student(%d,'%s',%f)", id, name, allowance);
    }


    /*
    1.4) implement Comparable<Student> for Student by comparing only the "id" of Student.
     */
    @Override
    public int compareTo(Student o) {
        return id - o.id;
    }

    /*
    1.7) create a public static method named "averagaAllowance" that receives no argument and
    returns the average allowance of "all" Student.  This method returns a negative value
    if "all" is null or there is no Student in "all".
     */
    public static double averageAllowance() {
        double ave = 0;
        double divider = 0;
        for (int i = 0; i < count; i++) {
            if (all[i] != null) {
                ave += all[i].allowance;
                divider++;
            }
        }
        return ave / divider;
    }

    /*
    1.8) create a public static method named "remove" that receives an int (named "id").
    This method removes the Student with id equals to "id" from "all" and return that Student.
    This method returns null if "all" is null or there is no Student with that id in the array.
    When removing a Student from the array, move that last element in the array to replace
    the Student that is removed and decrement the "count".
     */
    public static Student remove(int id) {
        Student n = null;
        for (int i = 0; i < count; i++) {
            if (all == null) {
                return null;
            }
            if (id == all[i].id) {
                n = all[i];
                all[i] = all[--count];
            }
        }
        return n;
    }
    /*
    1.9) create a public static void method named "sort" to sort the array.
     */
    public static void sort(){
        Arrays.sort(all);
    }
    /*
    1.10) create a public static method named "listAll" to return a String containing
      all Students in "all" separated by ", ".
     */
    public static StringJoiner ListAll(){
         StringJoiner list = new StringJoiner(", ");
        for(int i = 0;i< count ;i++){
            list.add(all[i].toString());
        }
        return list;
    }
}
