package LambdaStream.Function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> counts = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        int s = counts.apply("ajit");
        Function<String, Integer> countsTwo = (x) -> x.length();

        int s2 = countsTwo.apply("samar");


        System.out.println("s2: " + s2 + " \ns1 : " + s);


        Function<Integer, String> convertor = (x) -> {
            String intToString = x.toString();
            String intToS= String.valueOf(x);
            System.out.println(intToString.getClass().getTypeName());
            System.out.println(intToS.getClass().getTypeName());
            return intToString;

        };

        System.out.println(convertor.apply(1));
    }



}
