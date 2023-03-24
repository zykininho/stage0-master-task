package com.epam.OOP;

public class Bird extends Animal {

    public Bird() {
        super("blue", 2, false);
    }

    @Override
    public String getDescription() {
        return super.getDescription().concat(" Moreover, it has 2 wings and can fly.");
    }

    public static void main(String[] args) {
        System.out.println(new Bird().getDescription());
    }
}
