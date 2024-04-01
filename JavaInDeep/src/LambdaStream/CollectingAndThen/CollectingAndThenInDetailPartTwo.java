package LambdaStream.CollectingAndThen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingAndThenInDetailPartTwo {
    public static void main(String[] args) {

        System.out.println("*********************");
        List<Integer> numbers = List.of(1, 2, 21, 4, 5);

        Integer maxNumbers = numbers.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy((a,b)->a.compareTo(b)),
                e->e.get()
        ));

        System.out.println(maxNumbers);

        System.out.println("**********************");

        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "watermelon");

        Integer size = words.stream().filter((e)->e.length()>5).collect(Collectors.collectingAndThen(
                Collectors.counting(),
                e->e.intValue()
        ));

        System.out.println(size);
        System.out.println("*******************");


    }
}
