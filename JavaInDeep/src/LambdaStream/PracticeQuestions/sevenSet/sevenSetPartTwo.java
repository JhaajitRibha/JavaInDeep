package LambdaStream.PracticeQuestions.sevenSet;

import CodingPractice.Interview.Employeee;
import LambdaStream.PracticeQuestions.utilities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class sevenSetPartTwo {
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
                new Employee("Leo", 51, 92000, "Finance"),
                new Employee("Mona", 12, 88000, "Finance"),
                new Employee("Nick", 43, 85000, "Finance"),
                new Employee("Olivia", 14, 87000, "Finance"),
                new Employee("Peter", 55, 60000, "Marketing"),
                new Employee("Quinn", 16, 61000, "Marketing"),
                new Employee("Rita", 47, 62000, "Marketing"),
                new Employee("Sam", 18, 59000, "Marketing"),
                new Employee("Tina", 19, 63000, "Sales"),
                new Employee("Uma", 20, 72000, "Sales"),
                new Employee("Victor", 91, 73000, "Sales"),
                new Employee("Wendy", 22, 71000, "Sales"),
                new Employee("Xander", 23, 70000, "Sales"),
                new Employee("Yara", 24, 75000, "Sales"));

        //find all department names
        employees.stream().map(x->x.getDepartment()).distinct().forEach(x-> System.out.println(x));
        List<String> departments = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        departments.forEach(x-> System.out.print(x + "  "));
        System.out.println();

        //count of employees in each department

        Map<String,Long> employeeCountEachDepartment = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
        ));


        employeeCountEachDepartment.forEach((x,y)-> System.out.println(x+ " " + y));
        System.out.println();

        //Find the list of employees whose age is less than 30

        List<Employee> employeesUnderThirty = employees.stream().filter(x->x.getAge()<30).collect(Collectors.toList());

        System.out.println("employee under 30 :");
        employeesUnderThirty.forEach(x-> System.out.println(x));
        System.out.println();


        //Find the list of employees whose age is in between 26 and 31
        List<Employee> employeesBetweenTwentySixAndThirtyOne = employees.stream().filter(x->x.getAge()>20 && x.getAge()<31).collect(Collectors.toList());

        System.out.println("employee between age 20 and 31 :");
        employeesBetweenTwentySixAndThirtyOne.forEach(x-> System.out.println(x));
        System.out.println();

        //Find the average age of male and female employee
        //consider by department as we dont have employee pojo with gender and i dont want to create it now

        Map<String,Double> averageAgeByDefault =
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getAge)
                ));

        System.out.println(averageAgeByDefault);

        //Find the department who is having maximum number of employee

        System.out.println();

        String departmentWithMaximumEmployee = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
        )).entrySet().stream().max(Comparator.comparingLong(e->e.getValue())).get().getKey();

        System.out.println(departmentWithMaximumEmployee);

        String departmentWithMaximumEmployeeSecondWay = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
        )).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(departmentWithMaximumEmployeeSecondWay);

        //Find the Employee who stays in Delhi(consider department-sales) and sort them by their names
        //using department instead of city

        List<Employee> employeeSorted = employees.stream().filter(x->x.getDepartment().equals("Sales"))
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

        System.out.println("***********************");
        employeeSorted.stream().forEach(x-> System.out.println(x));

        List<Employee> employeeSortedReverse = employees.stream().filter(x->x.getDepartment().equals("Sales"))
                .sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());

        System.out.println("***********************");
        employeeSortedReverse.stream().forEach(x-> System.out.println(x));


        System.out.println("**********Average Salary Department Wise****************");
        //Find the average salary in all departments
        Map<String,Double> deparmentWiseAverageSalary = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        deparmentWiseAverageSalary.entrySet().stream().forEach(x-> System.out.println(x.getKey()+ " : " + x.getValue()));

        //Find the highest salary in each department

        System.out.println("***********Maximum salary department wise *******************");
        Map<String,Double> highestSalaryDepartmentWise = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        x->x.map(y->y.getSalary()).orElse(0.0)
                )
        ));

        System.out.println("**********second way*************");
        Map<String,Optional<Employee>> res = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
        ));
        highestSalaryDepartmentWise.forEach((x,y)-> System.out.println(x + " : " + y));

        //Find the list of employee and sort them by their salary

        System.out.println("*********sortedBySalary************");
        List<Employee> employeeSortedBySalary = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        employeeSortedBySalary.forEach(x-> System.out.println(x));


        //Find the employee who has second lowest salary
        System.out.println("*********sortedBySalary************");
        Employee secondLowestSalariedEmployee = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst().get();
        System.out.println(secondLowestSalariedEmployee);

        System.out.println("**********");




    }
}
