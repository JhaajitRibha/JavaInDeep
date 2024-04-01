package LambdaStream.BiFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BiFunctionDemo {


    static BiFunction<Integer,Integer,Integer> ThreeInteger = new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
           return integer*integer2;
        }
    };

    static BiFunction<Integer,Integer,List<String>> TwoIntegerList = new BiFunction<Integer, Integer, List<String>>() {
        @Override
        public List<String> apply(Integer integer, Integer integer2) {
            String a = integer+"ajit";
            String b = "samar"+integer2;

            List<String> res = new ArrayList<>();
            res.add(a);
            res.add(b);

            return res;

        }
    };


    static BiFunction<List<Integer>,List<Integer>,List<Integer>> functionWithSimple = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
        @Override
        public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {

            List<Integer> combinedList = new ArrayList<>(integers);
            combinedList.addAll(integers2);
            List<Integer> res = combinedList.stream().distinct().collect(Collectors.toList());
            return res;
        }
    };

    public static void main(String[] args) {
//        TwoIntegerList.apply(1,2).forEach(x-> System.out.println(x));
//        System.out.println(ThreeInteger.apply(1,2));

        List<Integer> firstList = Arrays.asList(1,2,3,4,5,10);
        List<Integer> secondList = Arrays.asList(6,7,8,9,10);

        functionWithSimple.apply(firstList,secondList).forEach(x-> System.out.println(x));

    }

}
