package LambdaStream.CollectingAndThen.PracticeSetOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingCountAndSquare {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        Long squareOfCounting = numbers.stream().collect(Collectors.collectingAndThen(
                Collectors.counting(),
                count->count*count
        ));

        System.out.println(squareOfCounting);

    }
}
