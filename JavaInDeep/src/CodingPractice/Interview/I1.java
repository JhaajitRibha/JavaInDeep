package CodingPractice.Interview;

// 1,2,3,3,4,4,5

//get the frequence of character in given string using java8


import java.util.stream.Collectors;

public class I1 {

    public static void duplicateValues(int[] arr){

        int[] temp = new int[arr.length];

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                temp[i]=arr[i];
            }else{
                temp[i]=0;
            }
        }

        for(int i=0;i<temp.length;i++){
            if(temp[i]!=-0){
                System.out.println(temp[i]);
            }
        }
    }




    public static void main(String[] args) {

        int[] arr =  new int[]{1,2,3,3,4,4,5};
        duplicateValues(arr);

        String word = "javadevvveloppper";

        System.out.println("**************************");
        word.chars().forEach((e)-> System.out.println(e));

        word.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e,Collectors.counting())).forEach(
                (e,v)-> System.out.println(e + " " + v)
        );

    }
}
