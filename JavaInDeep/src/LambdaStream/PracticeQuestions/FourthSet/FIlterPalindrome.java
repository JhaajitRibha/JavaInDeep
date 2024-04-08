package LambdaStream.PracticeQuestions.FourthSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FIlterPalindrome {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("level","hello","radar","world","civic");

        strings.stream().filter(e->new StringBuilder(e).reverse().toString().equalsIgnoreCase(e))
                .collect(Collectors.toList()).stream().forEach(e-> System.out.println(e));
    }
}
