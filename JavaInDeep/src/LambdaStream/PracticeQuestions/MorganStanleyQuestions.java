package LambdaStream.PracticeQuestions;

import LambdaStream.PracticeQuestions.utilities.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MorganStanleyQuestions {
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
                new Employee("Victor", 21, 73000, "Sales"),
                new Employee("Wendy", 22, 71000, "Sales"),
                new Employee("Xander", 23, 70000, "Sales"),
                new Employee("Yara", 24, 75000, "Sales"));

        Map<String,String> departmentWiseOddEven =
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,//treemap  sorted ke liye pagli,linkedHashmap for insertion order
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getAge,
                                        Collectors.toList()),
                                age->{
                                    long even = age.stream().filter(x->x%2==0).count();
                                    long odd = age.size()-even;
                                    return even>odd?"even":"odd";
                                }
                        )
                ));

        Map<String,String> departmentWiseOddEvenTwo = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream().
                collect(Collectors.toMap(
                      Map.Entry::getKey,
                        e->{
                          List<Employee> employeess = e.getValue();
                          long even = employeess.stream().filter(x->x.getAge()%2==0).count();
                          long odd = employeess.size()-even;
                          return even>odd?"even":"odd";

                        }
                        ));

        departmentWiseOddEven.entrySet().stream().forEach(System.out::println);
        System.out.println();
//        departmentWiseOddEvenTwo.forEach((x,y)-> System.out.print(x+" : "+ y + " "));
//        System.out.println();
        departmentWiseOddEvenTwo.entrySet().stream().forEach(System.out::println);
        System.out.println();


        //*****************************************************************************************

        String nonRepeating = "ddusstpaning";
        String[] nonRepeatings = nonRepeating.split("");
        String firstNonRepeatingCharacter = Arrays.stream(nonRepeatings).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
                .stream().filter(e->e.getValue()==1).findFirst().get().getKey();
        System.out.println(firstNonRepeatingCharacter + " is first non repeating ");

        String firstNonRepeatingCharacterTwo = Arrays.stream(nonRepeatings)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        () -> new LinkedHashMap<>(),   // instead of LinkedHashMap::new
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println(firstNonRepeatingCharacterTwo + " is first non repeating ");

        char firstNonRepeatingAnotherWay  = nonRepeating.chars().mapToObj(c->String.valueOf((char)c)).filter(
                ch->nonRepeating.indexOf(ch)==nonRepeating.lastIndexOf(ch)
        ).findFirst().get().charAt(0);

        System.out.println(firstNonRepeatingAnotherWay + " : " + "other way");

        //understand about linkedHashMap in detail how to use it with in steram api and why we write LinkedHashMap::new(other way)


        System.out.println("*******************next phase************************");
        String[] fruits = {"Apple", "Banana","Apple", "Cherry", "Date", "Elderberryy", "Fig", "Hrapes", "Honeydew"};
        //get first character of each string in list of strings
        List<Character> firstChars = Arrays.stream(fruits).map(x->x.charAt(0)).collect(Collectors.toList());
        firstChars.forEach(x-> System.out.println(x));

        System.out.println();
        //get first string  in list of strings where string length is greater than 10
        String stringWithLengthGreaterThanTen = Arrays.stream(fruits).distinct().collect(Collectors.toMap(
                x->x,
                String::length
        )).entrySet().stream().filter(x->x.getValue()>10).map(x->x.getKey()).findFirst().get();

        System.out.println(stringWithLengthGreaterThanTen);


        //write a code using java streams to get the first character of each string from a list of strings and handle edge cases like empty strings
        String[] words = {"Apple", "Banana", "", "Cherry", null, "Date"};

        System.out.println("***************");
        List<Character> firsts= Arrays.stream(words).distinct().filter(x->x!=null && !x.isEmpty()).map(x->x.charAt(0)).collect(Collectors.toList());
        firsts.forEach(x-> System.out.println(x));



    }
}
