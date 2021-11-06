package com.government;

import java.util.LinkedList;
import java.util.List;

public class Cabinet {
    private PrimeMinister pm;
    private List<Minister> ministers;

    public Cabinet(PrimeMinister pm) {
        this.pm = pm;
        ministers = new LinkedList<Minister>();
    }

    private int countMinisters() {
        return ministers.size();
    }

    public void addMinister(Minister minister) throws IndexOutOfBoundsException {
        if (countMinisters() < 35) {
            ministers.add(minister);
        } else {
            throw new IndexOutOfBoundsException("The maximum value of 35 is reached.");
        }
    }

    public void removeMinister(Minister minister) {
        ministers.remove(minister);
    }
}
