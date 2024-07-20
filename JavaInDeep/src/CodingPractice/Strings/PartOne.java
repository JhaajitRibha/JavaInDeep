package CodingPractice.Strings;


import java.util.Arrays;

public class PartOne {

    public static void shiftZeroAtEnd(int[] arr){

        //4,5,0,1,9,0,5,0

        int temp=0;
        int left=0;
        int right=arr.length-1;

        while(left<right){

            if(arr[left]!=0){
                left++;
            }
            if(arr[right]==0){
                right--;
            }

            if(arr[left]==0){
                temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }

        }

        Arrays.stream(arr).forEach(e-> System.out.print(e+ " "));


    }
    public static String reverseString(String name){

        if(name.length()==1){
            return name;
        }

        return reverseString(name.substring(1))+name.substring(0,1);

    }

    public static String reverseStringUsingArray(String name){

        char[] nameArray = name.toCharArray();
        for(int i=0;i<nameArray.length/2;i++){
            char temp = nameArray[i];
            nameArray[i]=nameArray[nameArray.length-1-i];
            nameArray[nameArray.length-1-i]=temp;

        }

        return new String(nameArray);
    }

    public static void main(String[] args) {

        System.out.println(reverseString("shubham"));
        System.out.println(reverseStringUsingArray("shubham").toString());


        int[] arr = {4,5,0,1,9,0,5,0};

        shiftZeroAtEnd(arr);

    }

}
