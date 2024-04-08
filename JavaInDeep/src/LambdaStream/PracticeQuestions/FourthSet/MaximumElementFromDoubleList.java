package LambdaStream.PracticeQuestions.FourthSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumElementFromDoubleList {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.2, 3.5, 12.7, 4.8, 6.1);
        Double largest = doubles.stream().max((e1,e2)->e1.compareTo(e2)).get();

        System.out.println(largest);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
       Double res =  numbers.stream().mapToDouble(e->e.doubleValue()).average().getAsDouble();
        System.out.println(res);
    }
}
