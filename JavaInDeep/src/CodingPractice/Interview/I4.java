package CodingPractice.Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class I4 {
    public static void main(String[] args) {

       List<Employeee> employees = Arrays.asList(
                new Employeee(1,"akash",25000,27,"m"),
                new Employeee(1,"vikash",85000,47,"m"),
                new Employeee(1,"suresh",45000,47,"m"),
                new Employeee(1,"mahesh",55000,47,"m"),
                new Employeee(1,"anand",26000,17,"m")
                );

       String maxSalaryPerson =
               employees.stream().max(Comparator.comparingDouble(Employeee::getSalary)).get().getName();
        System.out.println(maxSalaryPerson);

       String maxSalryPerson = employees.stream().collect(Collectors.toMap(e->e.getName(), e->e.getSalary()))
               .entrySet().stream().max(Comparator.comparingDouble(e->e.getValue())).get().getKey();

       employees.stream().collect(Collectors.groupingBy(e->e.getAge(),Collectors.counting())).entrySet()
               .forEach((e)-> System.out.println(e.getKey() + " : " + e.getValue()));

       System.out.println(maxSalryPerson);

    }
}
