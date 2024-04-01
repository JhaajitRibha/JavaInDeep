package LambdaStream.CollectingAndThen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectinAndThenInDetail {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int res = numbers.stream().collect(Collectors.collectingAndThen(
                Collectors.summingInt((e)->e.intValue()),(sum)->sum*sum
        ));

        System.out.println(res);

        System.out.println("**************************");

        List<String> words = Arrays.asList("apple","apple","mango","mango","litchi","group");
        int size = words.stream().collect(Collectors.collectingAndThen(
                Collectors.toSet(),(s)->s.size()
        ));

        System.out.println(size);

        System.out.println("****************");

        List<String> names = Arrays.asList("John", "Alice", "Bob");

        List<String> upperCaseStrings =names.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),list->list.stream().map(e->e.toUpperCase()).collect(Collectors.toList())
        ));

        upperCaseStrings.stream().forEach(e-> System.out.print(e +" "));
        System.out.println();
        System.out.println("************");


        List<Integer> values = Arrays.asList(10, 5, 8, 15, 3);

          int maxValue = values.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),list->list.stream().max(Comparator.comparingInt(e->e.intValue()))
        )).get();

        System.out.println(maxValue);

    }
}
