package LambdaStream.PracticeQuestions.groupingBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FirstSet {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple","banana","cherry","date","fig","grape");

        strings.stream().max(Comparator.comparingInt(x->x.length())).ifPresent(System.out::println);

        Map<Integer,List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(e->e.length()));

        groupedStrings.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println("****************************************************");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        Map<Integer,List<Integer>> grouped = numbers.stream()
                .collect(Collectors.groupingBy(n->(n % 2==0)?1:0));

        grouped.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println("************************************");


        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 10),
                new Person("Charlie", 17),
                new Person("David", 25),
                new Person("Edward", 70),
                new Person("Frank", 15),
                new Person("Grace", 8)
        );

        people.stream().collect(Collectors.groupingBy(e->{
            if (e.age <= 12) return "Child";
            else if (e.age <= 19) return "Teen";
            else if (e.age <= 64) return "Adult";
            else return "Senior";
        })).forEach((e,v)->System.out.println(e + " " + v));

        System.out.println("*******************");

    }
}
