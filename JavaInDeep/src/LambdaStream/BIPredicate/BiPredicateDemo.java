package LambdaStream.BIPredicate;

import LambdaStream.BiFunction.BiFunctionDemo;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    static BiPredicate<Integer,String> s = new BiPredicate<Integer, String>() {
        @Override
        public boolean test(Integer integer, String s) {
            return integer==Integer.parseInt(s);
        }
    };

    public static void main(String[] args) {
        System.out.println(s.test(1,"1"));
    }
}
