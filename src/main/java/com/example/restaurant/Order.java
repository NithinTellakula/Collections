package com.example.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<MenuItem> orderItems;

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        orderItems.add(item);
    }

    public void showOrder() {
        System.out.println("Your Order:");
        if (orderItems.isEmpty()) {
            System.out.println("No items ordered.");
            return;
        }
        double total = 0;
        for (MenuItem item : orderItems) {
            System.out.println("- " + item.getName() + " ₹" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total Bill: ₹" + total);
    }
}


