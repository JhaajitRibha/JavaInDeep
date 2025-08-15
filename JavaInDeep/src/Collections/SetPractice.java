package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        System.out.println(s.add("ajit"));
        System.out.println(s.add("ajit"));

        s.stream().forEach(System.out::println);
    }
}
