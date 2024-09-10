package LambdaStream.PracticeQuestions.SIxSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFeature {
    public static void main(String[] args) {
        List<Optional<String>> optionalStrings = Arrays.asList(

                Optional.of("ajit"),
                Optional.of("samar"),
                Optional.ofNullable(null),
                Optional.of(""),
                Optional.of("World"),
                Optional.ofNullable(null)


        );

        optionalStrings.stream().filter(e->e.isPresent())
                .map(e->e)
                .filter(s->!s.isEmpty())
                .collect(Collectors.toList()).forEach(e-> System.out.println(e));
    }
}
