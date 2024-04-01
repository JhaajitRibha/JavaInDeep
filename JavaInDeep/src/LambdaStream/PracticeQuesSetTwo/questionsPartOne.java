package LambdaStream.PracticeQuesSetTwo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class questionsPartOne {

    interface DoubleNumber{
        double doubleNumber(double x);
    }

    interface SquaredNumber{
        double square(double x);
    }

    interface CheckEvenNumber{
        boolean checkEven(int num);
    }

    public static void main(String[] args) {
        //Write a lambda expression to double a given number.

        List<Double> numbers = Arrays.asList(2.0,4.0,5.0,6.0,9.2);

        DoubleNumber doubledNumber =(x)->x*2;

        double res  = doubledNumber.doubleNumber(2.0);

        System.out.println(res);

        numbers.stream().map((x)->x*2).collect(Collectors.toList()).forEach(e-> System.out.print(e+ " "));


        System.out.println();
        System.out.println("********************************");

        //Write a lambda expression to square a given number.

        SquaredNumber squaredNumber = x->x*x;

        double squaredResult = squaredNumber.square(15.0);
        System.out.println(squaredResult);
        System.out.println("********************************");

        numbers.stream().map(x->x*x).collect(Collectors.toList()).forEach(
                e-> System.out.print(e+ " ")
        );

        System.out.println();

        //Write a lambda expression to check if a number is even.

        CheckEvenNumber checkEvenNumber = x->x%2==0;

        System.out.println("***************************");
        System.out.println(checkEvenNumber.checkEven(40)  + " "
        +checkEvenNumber.checkEven(41));


    }
}
