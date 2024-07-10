package LambdaStream.groupingBy;

import LambdaStream.groupingBy.Utility.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingPartOne {
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee("ajit", "developer"),
                new Employee("samar","tester"),
                new Employee("rahul","HR"),
                new Employee("sumit","manager"),
                new Employee("hudge","developer"),
                new Employee("shekhar","manager"),
                new Employee("ashish","tester"),
                new Employee("asif","tester")
        );


        Map<Employee,List<Employee>> employeeListResult = employeeList.stream()
                .collect(Collectors.groupingBy(e->e));

        employeeListResult.entrySet().stream().forEach(
                e-> System.out.println(e.getKey() + " : " + e.getValue())
        );

        System.out.println("***********************");

        Map<String,List<Employee>> employeeListCollectByDep =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment
                        ));

        employeeListCollectByDep.entrySet().stream().forEach(
                e-> System.out.println(e.getKey() + " : " + e.getValue())
        );


        System.out.println("******************************");

        Map<String,Map<String,List<Employee>>> departmentDetails = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(Employee::getName)));

        departmentDetails.entrySet().stream()
                .forEach(e->{
                    System.out.println("**************" + e.getKey() + "***********" );
                    e.getValue().entrySet().stream().forEach(k->{
                        System.out.println(k.getKey() + " : " + k.getValue());
                    });
                });



    }

}
