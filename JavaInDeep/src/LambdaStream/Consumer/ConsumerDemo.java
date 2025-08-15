package LambdaStream.Consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {


   static Consumer<Integer> s = new Consumer<Integer>() {
       @Override
       public void accept(Integer integer) {

           System.out.println("integer is : " + integer);
       }
   };

  static Consumer<Integer> s2 = (x)-> System.out.println(x + " ajit");

    public static void main(String[] args) {
        s.accept(1);
        s.accept(10);

        int[] arr = new int[] {1,2,3,4,5,6,7};
        List<Integer> listOfNumber = new ArrayList<>();

        for(int n: arr){

            listOfNumber.add(n);
        }


       listOfNumber.forEach(s);
        listOfNumber.forEach(s2);

        



    }

}
