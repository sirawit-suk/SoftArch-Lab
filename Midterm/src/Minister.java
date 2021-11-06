package com.government;

import java.util.Random;

public class Minister extends Politician implements OrderIssuable {
    private String ministry;

    public Minister(String ministry) {
        this.ministry = ministry;
    }

    @Override
    public void debate(String topic) {
        System.out.println("It's up to that PrimeMinister!");
    }

    public String order() {
        Random random = new Random();
        return "Minister of " + ministry + " order " + random.nextInt();
    }
}
