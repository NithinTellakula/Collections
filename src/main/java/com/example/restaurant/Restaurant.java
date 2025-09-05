package com.example.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    List<MenuSection> sections;

    public Restaurant(String name) {
        this.name = name;
        this.sections = new ArrayList<>();
    }

    public void addSection(MenuSection section) {
        sections.add(section);
    }

    public void showMenu() {
        System.out.println( name );
        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).showItems(i + 1);
        }
        System.out.println("Example: Type 2.1 for Butter Naan, 3.2 for Ice Cream, 0 to finish");
    }

    public List<MenuSection> getSections() {
        return sections;
    }

    public String getName() {
        return name;
    }
}
