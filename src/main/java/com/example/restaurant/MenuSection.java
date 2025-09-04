package com.example.restaurant;


import java.util.ArrayList;
import java.util.List;

public class MenuSection {
    String sectionName;
    List<MenuItem> items;

    public MenuSection(String sectionName) {
        this.sectionName = sectionName;
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    public void showItems(int sectionIndex) {
        System.out.println(sectionName );
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println(sectionIndex + "." + (i + 1) + " " + item.getName() + " " + item.getPrice());
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }
}


