package LambdaStream.PracticeQuestions;


//1.java program to find first non repeat element from a given string.
//2.java program to find second highest number from array
//3.java program to find longest string from given array




import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondSet {


    public static void main(String[] args) {

        //1


        System.out.println("******************");

        String name = "ilovejavatechie";

        //linkedhashmap is used as to process in order and print l instead of c

        String firstNonRepeat = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(),()-> new LinkedHashMap<>(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .findFirst()
                .map(e->e.getKey())
                .get();

        System.out.println(firstNonRepeat);

        System.out.println("****************************");

        int[] numbers = {34,5,46,7,8,7,8,43798,453,43,53,646,77,7};

        int number =  Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .stream().skip(1)
                .findFirst().get();
        System.out.println(number);

        System.out.println("***********************");

        //3 ans


        String[] stringArray = {"java","techie","springboot","microservices","haka"};

        String largestWord = Arrays.stream(stringArray)
                .reduce((word1,word2)->word1.length()>word2.length()?word1:word2)
                .get();

        System.out.println(largestWord);

        String[] container = {""};
         Arrays.stream(stringArray).forEach(e->{
            if(e.length()>container[0].length()){
                container[0]=e;
            }
        });

        System.out.println(container[0]);

        System.out.println("-------------------------");

        String largestArray = Arrays.stream(stringArray).max((a,b)->Integer.compare(a.length(),b.length())).get();
        System.out.println(largestArray);






    }
}
