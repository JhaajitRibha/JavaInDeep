package CodingPractice.PracticeQuestions.Accolite;

import java.util.*;

public class ArrayOccurence {

    public static boolean occurenceChecker(int[] arr) {

        HashMap<Integer,Integer> countMap = new HashMap<>();


        for(int num:arr){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }

        HashSet<Integer> occurrences= new HashSet<>();
        for(int count:countMap.values()){
            if(!occurrences.add(count)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] input = {1,2};
        System.out.println(occurenceChecker(input));

    }
}
