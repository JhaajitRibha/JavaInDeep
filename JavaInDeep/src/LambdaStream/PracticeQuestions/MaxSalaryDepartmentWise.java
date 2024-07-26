package LambdaStream.PracticeQuestions;


import LambdaStream.PracticeQuestions.utilities.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        Map<String,Double> resr = employees.stream().collect(Collectors.groupingBy(
                e->e.getDepartment(),
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())),
                        mapx->mapx.map(e->e.getSalary()).orElse(0.0)

                )

        ));

        System.out.println("IIII");
        resr.entrySet().stream().forEach((e)-> System.out.println(e.getKey()+ " "  +e.getValue()));


    }
}
