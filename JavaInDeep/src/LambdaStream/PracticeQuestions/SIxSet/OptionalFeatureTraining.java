package LambdaStream.PracticeQuestions.SIxSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFeatureTraining {

    public static String flattenOptionalString(List<Optional<String>> strings){

        String res = strings.stream()
                .filter(e->e.isPresent())
                .map(e->e.get())
                .filter(e->!e.isEmpty()).
                collect(Collectors.joining(","));


        return res;

    }

    public static void main(String[] args) {

        List<Optional<String>> strings = Arrays.asList(
                Optional.of("ajit"),
                Optional.of("samar"),
                Optional.of(""),
                Optional.empty(),
                Optional.ofNullable(null),
                Optional.of("shivam"),
                Optional.of("ayaan"),
                Optional.of("ashish")
        );

        System.out.println(flattenOptionalString(strings));

    }
}
