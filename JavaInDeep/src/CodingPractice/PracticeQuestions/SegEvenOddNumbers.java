package CodingPractice.PracticeQuestions;


import java.util.Arrays;

public class SegEvenOddNumbers {
    public static void main(String[] args) {
        int[] numbers = {12,34,45,9,8,90,3};
        //12,34,8,90,45,9,3
        int j=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%2==0){
                i++;
            }else{
                for(j=i;j<numbers.length;j++){
                    if(numbers[i]%2!=0){
                        int temp=numbers[i];
                        numbers[i]=numbers[j];
                        numbers[j] =temp;
                        break;
                    }else{
                        j++;
                    }
                }
            }
        }


        Arrays.stream(numbers).forEach(e-> System.out.print(e+ " "));
    }
}
