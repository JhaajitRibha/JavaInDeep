package CodingPractice.PracticeQuestions.Accolite;


import java.util.Arrays;

public class ArrayCalculation {

    public static int[] sumOfArraysExceptSelf(int[] input){

        //1,2,3,4
//24,12,8,6
        int output[] = new int[input.length];
        int total = 1;
        for(int i=0;i<input.length;i++){
            total = total*input[i];
        }

        for(int i=0;i<input.length;i++){
            output[i] = total/input[i];
        }

        return output;
    }

    public static void main(String[] args) {

        int[] input = {1,2,3,4};
        Arrays.stream(sumOfArraysExceptSelf(input)).forEach(e-> System.out.println(e));
    }
}
