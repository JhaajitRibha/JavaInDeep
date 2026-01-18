package LambdaStream.PracticeQuestions.NineSet.Utiltity;

import java.time.LocalDate;

public class Order {
    private int custId;
    private String custName;
    private double orderValue;
    private LocalDate orderDate;

    // Constructor
    public Order(int custId, String custName, double orderValue, LocalDate orderDate) {
        this.custId = custId;
        this.custName = custName;
        this.orderValue = orderValue;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", orderValue=" + orderValue +
                ", orderDate=" + orderDate +
                '}';
    }
}
