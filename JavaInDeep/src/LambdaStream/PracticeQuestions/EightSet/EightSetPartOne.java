package LambdaStream.PracticeQuestions.EightSet;

import LambdaStream.PracticeQuestions.EightSet.utitlity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class EightSetPartOne {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Bob");
        Student student2 = new Student(1, "Bob");
        Student student3 = new Student(2, "Charlie");
        Student student4 = new Student(2, "Charlie");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        students.forEach(x-> System.out.println(x));

        System.out.println();
        List<Student> nonRepeatingStudentsDefaultBehaviour = students.stream().distinct().collect(Collectors.toList());
        nonRepeatingStudentsDefaultBehaviour.forEach(x-> System.out.println(x));

        System.out.println();
        Set<Student> setStudents = new HashSet<>(students);
        setStudents.forEach(x-> System.out.println(x));

        System.out.println();
        Set<Student> setStudentsLinked = new LinkedHashSet<>(students);
        setStudentsLinked.forEach(x-> System.out.println(x));

        //now overriding equals and hashcode for student.you can test it by removing equals and hashcode
    }
}
