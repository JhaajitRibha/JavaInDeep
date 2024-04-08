package LambdaStream.CollectingAndThen.PracticeSetOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingCountAndSquare {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,15,6);

        Long squareOfCounting = numbers.stream().collect(Collectors.collectingAndThen(
                Collectors.counting(),
                count->count*count
        ));

        System.out.println(squareOfCounting);

        numbers.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy((e1,e2)->e1.compareTo(e2)),
                num-> num.map(e->e*e)
        )).stream().collect(Collectors.toList()).stream().forEach(e-> System.out.println(e));

    }
}
