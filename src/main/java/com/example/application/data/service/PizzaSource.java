package com.example.application.data.service;

import com.example.application.data.entity.Pizza;
import java.util.ArrayList;

public class PizzaSource { 
    public static ArrayList<Pizza> pizzas;

    public PizzaSource() {
        pizzas = new ArrayList<Pizza>();

        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();
        Pizza pizza3 = new Pizza();
        Pizza pizza4 = new Pizza();

        pizza1.setName("Pizza Margharitta");
        pizza1.setPrice(19.95);
        pizza1.setImg("images/magherita.png");
        pizza2.setName("Pizza Salami");
        pizza2.setPrice(21.95);
        pizza2.setImg("images/salami.png");
        pizza3.setName("Pizza Diavolo");
        pizza3.setPrice(22.95);
        pizza3.setImg("images/diavolo.png");
        pizza4.setName("Pizza Hawaii");
        pizza4.setPrice(22.95);
        pizza4.setImg("images/Hawaii.png");

        pizzas.add(pizza1);
        pizzas.add(pizza2);
        pizzas.add(pizza3);
        pizzas.add(pizza4);
    }
}