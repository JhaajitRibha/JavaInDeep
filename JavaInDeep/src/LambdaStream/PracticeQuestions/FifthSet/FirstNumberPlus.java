package LambdaStream.PracticeQuestions.FifthSet;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNumberPlus {
    public static void main(String[] args) {
        int[] arr = new int[]{98,10,15,8,49,25,98,32,10};

        System.out.println("*****************************");

       int firstNumber =  Arrays.stream(arr).findFirst().getAsInt();
        System.out.println("fist value: " + firstNumber);

        System.out.println("********************");

        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1);

        Map<Integer,Long> numbersGrouping= myList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));

        numbersGrouping.forEach((e,v)-> System.out.println(e + " : " + v));

        List<Integer> duplicateNumbers = numbersGrouping.entrySet().stream().filter(e->e.getValue()>1)
                .map(e->e.getKey()).collect(Collectors.toList());

        duplicateNumbers.forEach(e-> System.out.print(e + " "));
        System.out.println();

        System.out.println("**********************************************");

        List<Integer> numbersWithOne = Arrays.asList(13, 24, 34, 41, 12, 13, 55,106, 15);

        numbersWithOne.stream().map(e->e+"").filter(e->e.startsWith("1")).collect(Collectors.toList()).forEach(e-> System.out.println(e));

        System.out.println();

        System.out.println("**********************************************");

        int maxNumber = numbersWithOne.stream().collect(Collectors.maxBy(Comparator.comparingInt(Integer::intValue))).get();

        System.out.println(maxNumber);
        System.out.println("********************************************");

        int minNumber = numbersWithOne.stream().collect(Collectors.minBy(Comparator.comparingInt(Integer::intValue))).get();
        System.out.println(minNumber);

        System.out.println("***********************************************");


        String strings = "swiwwa";
        strings.chars().forEach(e-> System.out.println(e + " " + (char)e));

        Map<Character,Long> charactersCount = strings.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e, LinkedHashMap::new,Collectors.counting()));

        charactersCount.forEach((e,v)-> System.out.println(e + " : " + v));

       List<Character> nonRepeatedChar =  charactersCount.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).collect(Collectors.toList());

        System.out.println(nonRepeatedChar.stream().findFirst().get());
        System.out.println("****************************************************");

    }
}
