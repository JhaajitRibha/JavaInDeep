package LambdaStream.BiConsumer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {

    static BiConsumer<Integer,Integer> s = new BiConsumer<Integer, Integer>() {
        @Override
        public void accept(Integer num1, Integer num2) {
            System.out.println(num1+num2);
        }
    };

    static BiConsumer<String,Integer> s2 = new BiConsumer<String, Integer>() {
        @Override
        public void accept(String s, Integer num) {
            System.out.println(s + " : " + num );
        }
    };



    static BiConsumer<String,Integer> s3= (word,num)-> System.out.println(word + " = "+ num);

    public static void main(String[] args) {
        List<Integer> listNumber = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> listNumber2 = Arrays.asList(9,10,11,12,13,14,15);

        s.accept(1,2);
        s.accept(9,10);

        Map<Integer,Integer> mapOfInteger  =new HashMap<>();

        mapOfInteger.put(1,100);
        mapOfInteger.put(2,200);
        mapOfInteger.put(3,300);
        mapOfInteger.put(4,400);

        mapOfInteger.forEach(s);

        Map<String,Integer> mapOfStrings = new HashMap<>();

        mapOfStrings.put("ajit",1);
        mapOfStrings.put("samar",2);
        mapOfStrings.put("aksah",3);

        mapOfStrings.forEach(s2);
        mapOfStrings.forEach(s3);




    }
}
