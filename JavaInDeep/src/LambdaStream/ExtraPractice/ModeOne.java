package LambdaStream.ExtraPractice;

import LambdaStream.PracticeQuestions.utilities.Transaction;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModeOne {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Groceries", 50.0),
                new Transaction("Shopping", 120.0),
                new Transaction("Groceries", 30.0),
                new Transaction("Entertainment", 80.0),
                new Transaction("Shopping", 100.0),
                new Transaction("Entertainment", 50.0)
        );

        List<Transaction> transactionsList = transactions.stream().collect(Collectors.toList());
        transactionsList.stream().forEach((e)-> System.out.println(e));

        Map<Double,String> transactionMap = transactions.stream().collect(Collectors.toMap(Transaction::getAmount,Transaction::getCategory));

        transactionMap.entrySet().stream().forEach((e)-> System.out.println(e.getKey() + " : " + e.getValue()));

//        List<Map.Entry<String,Double>> s = transactions.stream().collect(Collectors.collectingAndThen(Collectors.toMap(Transaction::getCategory,Transaction::getAmount,(o,p)->p)
//                ,(maps)->maps.entrySet().stream().collect(Collectors.toList())));
//
//        s.forEach(e-> System.out.println(e.getKey()+ " "  + e.getValue()));

        List<Map.Entry<String, Double>> k = transactions.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toMap(
                                Transaction::getCategory,
                                Transaction::getAmount,
                                (o, p) -> p // Keep the latest value
                        ),
                        map -> map.entrySet().stream().collect(Collectors.toList())
                )


        );

        k.forEach(entry -> System.out.println("Category: " + entry.getKey() + ", Amount: " + entry.getValue()));


    }
}
