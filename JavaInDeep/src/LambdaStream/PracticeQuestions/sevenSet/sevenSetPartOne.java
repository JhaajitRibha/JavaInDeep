package LambdaStream.PracticeQuestions.sevenSet;

import LambdaStream.PracticeQuestions.utilities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class sevenSetPartOne {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList( new Employee("Alice", 25, 60000, "IT"),
                new Employee("Bob", 1, 65000, "IT"),
                new Employee("Charlie", 2, 70000, "IT"),
                new Employee("David", 3, 55000, "IT"),
                new Employee("Eve", 4, 58000, "IT"),
                new Employee("Frank", 5, 50000, "HR"),
                new Employee("Grace", 6, 52000, "HR"),
                new Employee("Hank", 7, 53000, "HR"),
                new Employee("Ivy", 8, 49000, "HR"),
                new Employee("Jack", 9, 55000, "HR"),
                new Employee("Karen", 10, 90000, "Finance"),
                new Employee("Leo", 11, 92000, "Finance"),
                new Employee("Mona", 12, 88000, "Finance"),
                new Employee("Nick", 13, 85000, "Finance"),
                new Employee("Olivia", 14, 87000, "Finance"),
                new Employee("Peter", 15, 60000, "Marketing"),
                new Employee("Quinn", 16, 61000, "Marketing"),
                new Employee("Rita", 17, 62000, "Marketing"),
                new Employee("Sam", 18, 59000, "Marketing"),
                new Employee("Tina", 19, 63000, "Marketing"),
                new Employee("Uma", 20, 72000, "Sales"),
                new Employee("Victor", 91, 73000, "Sales"),
                new Employee("Wendy", 22, 71000, "Sales"),
                new Employee("Xander", 23, 70000, "Sales"),
                new Employee("Yara", 24, 75000, "Sales"));

        // 	Find list of employees whose name starts with alphabet A

        String name = employees.stream().filter(x->x.getName().startsWith("A")).findFirst().get().getName();
        List<String> namesWithA = employees.stream().filter(x->x.getName().startsWith("A")).collect(Collectors.mapping(Employee::getName,Collectors.toList()));
        List<String> namesWithB = employees.stream().filter(x->x.getName().startsWith("A")).map(x->x.getName()).collect(Collectors.toList());
        System.out.println("employeee starting with A : "  + name);
        namesWithA.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();
        namesWithB.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();

        System.out.println(employees.stream().count());
        System.out.println();
        int maxAge = employees.stream().reduce((x,y)->x.getAge()>y.getAge()?x:y).get().getAge();
        int maxAgeAnotherArray = employees.stream().max(Comparator.comparingInt(Employee::getAge)).get().getAge();
        System.out.println(maxAge);
        System.out.println(maxAgeAnotherArray);
        System.out.println();


        Map<String,Employee> oldestByDept = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Employee::getAge)),
                        Optional::get
                )
        ));
        System.out.println();
        oldestByDept.forEach((x,y)-> System.out.println(x + "  : " + y));
        System.out.println();

    }
}
