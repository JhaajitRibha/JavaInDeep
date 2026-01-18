package LambdaStream.PracticeQuestions;


//1.Find the occurence of each character in String.
//2.java program to find all the duplicate elements from a String
//3.java program to find unique elements from string


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstSet {

    public static void main(String[] args) {

        //1 answer

        System.out.println("---------------------------");
        System.out.println("---------------------------");


        String name = "ilovejavatechie";




        String[] nameArr = name.split("");

        String firstNonRepeating = Arrays.stream(nameArr).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(e->e.getValue()==1).collect(Collectors.toList()).stream().findFirst().get().getKey();
        System.out.println(firstNonRepeating);

        Arrays.stream(nameArr).forEach((e)-> System.out.println(e + " " + e.getClass().getName()));

        Map<String,Long> characterCounts = Arrays.stream(nameArr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("********************************");
        characterCounts.forEach((e,v)-> System.out.println(e+ " " + v));

        System.out.println("********************************");

        Map<String, List<String>> characterCounts2 = Arrays.stream(nameArr)
                .collect(Collectors.groupingBy(e->e));
        System.out.println(characterCounts2);

        System.out.println("********************************");

        Map<String,Long> characterCounts3 = Arrays.stream(nameArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(characterCounts3);

        System.out.println("**********************************");

        System.out.println("---------------------------");
        System.out.println("---------------------------");

       //ans 2

        System.out.println("---------------------------");
        System.out.println("---------------------------");

        System.out.println("****************************");

        String duplicateName= "malyalam";

        String[] duplicateNameArr = duplicateName.split("");

        Map<String,Long> duplicateNameCount = Arrays.stream(duplicateNameArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(duplicateNameCount);



        System.out.println("**************************");

        Map<String,Long> finalRes = duplicateNameCount.entrySet().stream().filter((e)->e.getValue()>1)
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));

        finalRes.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" " + e.getValue()));

        System.out.println("***************************");
        List<String> rex = finalRes.entrySet().stream()
                        .filter((e)->e.getValue()>1)
                                .map(e->e.getKey())
                                        .collect(Collectors.toList());

        rex.forEach(e-> System.out.println(e));

        System.out.println("************************");

        //3

        List<String> unique = Arrays.stream(duplicateNameArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .collect(Collectors.toList())
                .stream().map(e->e.getKey())
                .collect(Collectors.toList());

        for (String s : unique) {
            System.out.println(s);
        }


        System.out.println("**********************");


    }


}
