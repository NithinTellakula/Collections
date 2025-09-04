package com.example.restaurant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Restaurant restaurant = new Restaurant("Tandoori Palace");

        MenuSection starters = new MenuSection("Starters");
        starters.addItem("Paneer Tikka", 180);
        starters.addItem("Chicken 65", 200);

        MenuSection mainCourse = new MenuSection("Main Course");
        mainCourse.addItem("Veg Biryani", 220);
        mainCourse.addItem("Chicken Biryani", 280);
        mainCourse.addItem("Butter Naan", 40);
        mainCourse.addItem("Paneer Butter Masala", 220);

        MenuSection desserts = new MenuSection("Desserts");
        desserts.addItem("Gulab Jamun", 80);
        desserts.addItem("Ice Cream", 100);

        // Add sections to restaurant
        restaurant.addSection(starters);
        restaurant.addSection(mainCourse);
        restaurant.addSection(desserts);

        // Show Menu once
        restaurant.showMenu();

        // Take Order
        Order order = new Order();
        while (true) {
            System.out.print("\nEnter your choice (like 2.1 or 3.2 or 0 to finish): ");
            String choice = sc.next();

            if (choice.equals("0")) break;

            String[] parts = choice.split("\\.");
            if (parts.length == 2) {
                int sectionIndex = Integer.parseInt(parts[0]) - 1;
                int itemIndex = Integer.parseInt(parts[1]) - 1;

                if (sectionIndex >= 0 && sectionIndex < restaurant.getSections().size()) {
                    MenuSection chosenSection = restaurant.getSections().get(sectionIndex);
                    if (itemIndex >= 0 && itemIndex < chosenSection.getItems().size()) {
                        MenuItem item = chosenSection.getItems().get(itemIndex);
                        order.addItem(item);
                        System.out.println(item.getName() + " added to your order.");
                    }
                }
            }
        }

        order.showOrder();

        sc.close();
    }
}
