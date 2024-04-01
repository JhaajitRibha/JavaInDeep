package LambdaStream.PracticeQuestions;

import LambdaStream.PracticeQuestions.utilities.Report;
import LambdaStream.PracticeQuestions.utilities.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionDetail {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Groceries", 50.0),
                new Transaction("Shopping", 120.0),
                new Transaction("Groceries", 30.0),
                new Transaction("Entertainment", 80.0),
                new Transaction("Shopping", 100.0),
                new Transaction("Entertainment", 50.0)
        );



        //total number of transactions

        System.out.println("**********************");
        Double sumOfAmount= transactions.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),list->list.stream().mapToDouble(e->e.getAmount()).sum()
        ));
        System.out.println(sumOfAmount);

        System.out.println("********************");

        //total amount spent by each category

         Map<String,Double> amountByCategory = transactions.stream().collect(Collectors.groupingBy(
                   e->e.getCategory(),Collectors.summingDouble(e->e.getAmount())
           ));

         amountByCategory.forEach((e,v)-> System.out.println(e + " " +v));

         //average total amount

        System.out.println("********************");

       Double average =  transactions.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),list->list.stream().mapToDouble(e->e.getAmount()).average()
        )).getAsDouble();



        System.out.println(average);

        System.out.println("**********");

//        Report finalReport = transactions.stream().collect(Collectors.collectingAndThen(
//                Collectors.groupingBy(e->e.getCategory(),Collectors.counting()),
//                res->{
//                    int totalTransactiops = transactions.size();
//                    double totalAmount = transactions.stream().mapToDouble(e->e.getAmount()).sum();
//                    double averageAmount = totalAmount/totalTransactiops;
//                    return new Report(totalTransactiops,res,averageAmount);
//                }
//        ));
//
//        System.out.println(finalReport);


        Report finalReport = transactions.stream().collect(Collectors.collectingAndThen(
                Collectors.groupingBy(e->e.getCategory(),Collectors.summingDouble(e->e.getAmount())),
                result->{
                    int totalTransactiops = transactions.size();
                    double totalAmount = transactions.stream().mapToDouble(e->e.getAmount()).sum();
                    double averageAmount = totalAmount/totalTransactiops;
                    result.forEach((e,v)-> System.out.print(e+ " "+ v));
                    return new Report(totalTransactiops,result,averageAmount);

                }
        ));

        System.out.println(finalReport);


    }
}
