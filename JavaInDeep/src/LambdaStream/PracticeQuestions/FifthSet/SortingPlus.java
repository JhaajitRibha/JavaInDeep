package LambdaStream.PracticeQuestions.FifthSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingPlus {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 3, 2, 4};

        // Convert int array to IntStream and then boxed to Stream<Integer>
        List<Integer> sortedNumbers = Arrays.stream(numbers)
                .boxed()  // Convert IntStream to Stream<Integer>
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        sortedNumbers.forEach(e-> System.out.println(e));

        System.out.println("******************************");

        List<Integer> filteredElement = Arrays.stream(numbers).map(e->e*e*e).filter(e->e>50). boxed().collect(Collectors.toList());
        filteredElement.forEach(e-> System.out.println(e));

        List<String> names = Arrays.asList("ajit","saamar","maha");
        String maximumSizeName = names.stream().collect(Collectors.maxBy(Comparator.comparingInt(e->e.length()))).get();
        System.out.println(maximumSizeName);
    }
}
