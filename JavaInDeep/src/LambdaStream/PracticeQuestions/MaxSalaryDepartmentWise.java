package LambdaStream.PracticeQuestions;


import LambdaStream.PracticeQuestions.utilities.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSalaryDepartmentWise {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000, "HR"),
                new Employee("Alice", 35, 60000, "HR"),
                new Employee("Bob", 25, 55000, "Finance"),
                new Employee("Emily", 28, 65000, "Finance"),
                new Employee("Mike", 40, 70000, "IT"),
                new Employee("Sarah", 32, 75000, "IT")
        );




        employees.stream().collect(Collectors.groupingBy(
                e->e.getDepartment(),Collectors.counting()
        )).forEach((e,v)-> System.out.println(e+ " " + v));

        System.out.println("****************");

        employees.stream().collect(Collectors.groupingBy(
                e->e.getDepartment(),Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary()))
        )).forEach((e,v)-> System.out.println(e + " " + v.get().getSalary()));




    }
}
