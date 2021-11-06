package com.government;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parliament parliament = Parliament.getInstance();
        for (int i = 0; i != 478; i++) {
            parliament.addMember();
        }
        PrimeMinister pm = parliament.electPrimeMinister();
        Cabinet cabinet = pm.getCabinet();
        for (int i = 0; i != 33; i++) {
            pm.addMinister(Integer.toString(i));
        }
    }
}
