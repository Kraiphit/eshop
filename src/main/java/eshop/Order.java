package eshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public int id;
    public LocalDateTime date;
    public List<OrderItem> orderItems;

    Order(int id, LocalDateTime date) {
        if (id < 0) {
            throw new IllegalArgumentException("Order ID must not be negative value");
        }
        this.id = id;
        this.date = date;
        orderItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void addItem(Product product, int quantity) {
        OrderItem orderItem = new OrderItem(product, quantity);
        this.orderItems.add(orderItem);
    }

    public double getTotal() {
        double sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getSubtotal();
        }
        return sum;
    }
}
