package org.example;

public class  Customer {
    public Cook order(String name, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(name);
        Cook cook = cooking.makeCook(menuItem);
        return cook;
    }

}
