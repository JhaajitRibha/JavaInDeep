package LambdaStream.Predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isLength = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()==2;
            }
        };

        Predicate<Integer> isNumber = (x)->x%2==0;

        System.out.println(isNumber.test(3));
        System.out.println(isNumber.test(2));
        System.out.println(isLength.test("aj"));
        System.out.println(isLength.test("aia"));
    }
}
