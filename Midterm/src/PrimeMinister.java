package com.government;

import java.util.Random;

public class PrimeMinister extends Politician implements OrderIssuable {
    private Parliament parliament;
    private Cabinet cabinet = null;

    public PrimeMinister(Parliament parliament) {
        this.parliament = parliament;
    }

    public Cabinet getCabinet() {
        if (cabinet == null) {
            cabinet = new Cabinet(this);
        }
        return cabinet;
    }

    public void addMinister(String ministry) {
        cabinet.addMinister(new Minister(ministry));
    }

    public void removeMinister(Minister minister) {
        cabinet.removeMinister(minister);
    }

    @Override
    public void debate(String topic) {
        System.out.println("blah blah...");
    }

    public String order() {
        Random random = new Random();
        return "PrimeMinister order " + random.nextInt();
    }
}
