package LambdaStream.PracticeQuestions.utilities;

import java.util.Map;

public class Report {
    private int totalTransactions;
    private Map<String, Double> categoryAmounts;


    private double averageAmount;


    public Report(int totalTransactions, Map<String, Double> categoryAmounts, double averageAmount) {
        this.totalTransactions = totalTransactions;
        this.categoryAmounts = categoryAmounts;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "totalTransactions=" + totalTransactions +
                ", categoryAmounts=" + categoryAmounts +
                ", averageAmount=" + averageAmount +
                '}';
    }
}
