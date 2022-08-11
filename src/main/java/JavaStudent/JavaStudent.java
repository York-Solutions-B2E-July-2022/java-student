package JavaStudent;

import java.util.Optional;
import java.util.UUID;

public class JavaStudent {
   public static void main(String[] args) {
      //System.out.println("Hello World");
      Student s = new Student("Bill", "Bob", 'Q');
      s.setGender('Z');
      Optional<Character> gender = s.getGender();
      if(gender.isPresent()){
         System.out.println(gender.get());
      }
      JavaStudent.test();
   }
   public static void test(){
      StudentList s = new StudentList();
      Student student1 = new Student("Bill", "Bob", 'M');
      student1.setGrade(8);
      Student student2 = new Student("Bill", "Bob", 'F');
      student2.setGrade(5);
      Student student3 = new Student("Bill", "Bob", 'F');
      student3.setGrade(4);
      Student student4 = new Student("Bill", "Bob", 'F');
      student4.setGrade(3);
      Student student5 = new Student("Bill", "Bob", 'F');
      student5.setGrade(3);
      Student student6 = new Student("Bill", "Bob", 'F');
      student6.setGrade(10);
      s.addStudent(student1);
      s.addStudent(student2);
      s.addStudent(student3);
      s.addStudent(student4);
      s.addStudent(student5);
      Student id = s.addStudent(student6);
      s.removeStudent(id);
      for (Student student: s) {

         System.out.println(student);
      }
      System.out.println(s.genderCount('M'));
      System.out.println(s.avgGrade());
   }
}
