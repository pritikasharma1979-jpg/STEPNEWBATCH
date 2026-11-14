
package week6.practice;

public class Student {

    // Instance variables
    String name;
    int attendance;

    // Static variables shared by all objects
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    public Student(String name, int attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Creating two Student objects
        Student student1 = new Student("Ravi", 85);

        Student student2 = new Student("Anitha", 90);

        // Calling static method using class name
        Student.printCollegeInfo();
    }
}
