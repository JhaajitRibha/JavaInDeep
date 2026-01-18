package LambdaStream.PracticeQuestions.NineSet;

import LambdaStream.PracticeQuestions.NineSet.Utiltity.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NineSetPracticeOne {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "DEF", 10, LocalDate.parse("21-08-2025", formatter)));
        orders.add(new Order(2, "DEF", 10, LocalDate.parse("20-07-2025", formatter)));
        orders.add(new Order(3, "DEF", 10, LocalDate.parse("20-08-2025", formatter)));
        orders.add(new Order(4, "ABC", 10, LocalDate.parse("21-08-2025", formatter)));
        orders.add(new Order(5, "ABC", 10, LocalDate.parse("21-08-2025", formatter)));
        orders.add(new Order(6, "ABC", 10, LocalDate.parse("21-08-2025", formatter)));

        


    }
}
