package com.frankmoley.lil.adminweb;

public class DicePairRoll {
    private final Die die1 = new Die();
    private final Die die2 = new Die();
    private int total;

    public void rollDice() {
        die1.roll();
        die2.roll();
        total = die1.getValue() + die2.getValue();
    }

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public int getTotal() {
        return total;
    }
}