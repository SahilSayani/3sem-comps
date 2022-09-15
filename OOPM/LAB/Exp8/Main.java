/**
 * Create a Package 'Engineering' which has two classes, 'Student' and 'Marks'. 
 * Accept student details like roll no., Subject name, Student name. Calculate total marks in the class Student. 
 * Write display () method to display details and sort () method to sort the students records as per increasing order of total marks. The function sort must be statically defined to invoke it without referring any object. Both the functions write in the Marks class.
 * 
 * Create a main class which will use package and calculate total marks and display all the records of the student in the increasing order of their total marks
 */

package Lab.Exp8;
import Lab.Exp8.Engineering.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student ();
        Student sorted = new Student (student.RollNo.length);

        student.getDetails();
        student.calculateTotal();
        sorted = Marks.sort(student);
        Marks.display(sorted);
    }
}
