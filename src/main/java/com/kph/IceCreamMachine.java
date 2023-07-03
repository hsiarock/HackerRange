package com.kph;

import java.util.*;

public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;

    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public List<IceCream> scoops() {
        List<IceCream> ret = new ArrayList<IceCream>();
        for (String top: toppings) {
            for (String ing: ingredients) {
                ret.add(new IceCream(ing, top));
            }
        }
        return ret;
    }

}