package com.frankmoley.lil.adminweb;

import java.util.Random;

public class Die {
    private int value;

    public void roll() {
        Random random = new Random();
        value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}