package com.example.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant r1 = new Restaurant("Tandoori Palace");
        MenuSection starters1 = new MenuSection("Starters");
        starters1.addItem("Paneer Tikka", 180);
        starters1.addItem("Chicken 65", 200);

        MenuSection mainCourse1 = new MenuSection("Main Course");
        mainCourse1.addItem("Veg Biryani", 220);
        mainCourse1.addItem("Chicken Biryani", 280);
        mainCourse1.addItem("Butter Naan", 40);

        MenuSection desserts1 = new MenuSection("Desserts");
        desserts1.addItem("Gulab Jamun", 80);
        desserts1.addItem("Ice Cream", 100);

        r1.addSection(starters1);
        r1.addSection(mainCourse1);
        r1.addSection(desserts1);
        restaurants.add(r1);

        // Second Restaurant
        Restaurant r2 = new Restaurant("Spicy Treats");
        MenuSection starters2 = new MenuSection("Starters");
        starters2.addItem("Veg Manchuria", 150);
        starters2.addItem("Chilli Chicken", 220);

        MenuSection mainCourse2 = new MenuSection("Main Course");
        mainCourse2.addItem("Egg Fried Rice", 180);
        mainCourse2.addItem("Prawns Curry", 300);

        MenuSection desserts2 = new MenuSection("Desserts");
        desserts2.addItem("Brownie", 120);
        desserts2.addItem("Fruit Salad", 90);

        r2.addSection(starters2);
        r2.addSection(mainCourse2);
        r2.addSection(desserts2);
        restaurants.add(r2);

        // Show all restaurants
        System.out.println("Choose a Restaurant:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
        System.out.print("Enter your choice: ");
        int restChoice = sc.nextInt() - 1;

        if (restChoice < 0 || restChoice >= restaurants.size()) {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        Restaurant chosenRestaurant = restaurants.get(restChoice);
        chosenRestaurant.showMenu();
        Order order = new Order();
        while (true) {
            System.out.print("\nEnter your choice (like 2.1 or 3.2 or 0 to finish): ");
            String choice = sc.next();

            if (choice.equals("0")) break;

            String[] parts = choice.split("\\.");
            if (parts.length == 2) {
                int sectionIndex = Integer.parseInt(parts[0]) - 1;
                int itemIndex = Integer.parseInt(parts[1]) - 1;

                if (sectionIndex >= 0 && sectionIndex < chosenRestaurant.getSections().size()) {
                    MenuSection chosenSection = chosenRestaurant.getSections().get(sectionIndex);
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
