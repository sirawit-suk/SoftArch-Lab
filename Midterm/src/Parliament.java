package com.government;

import java.util.LinkedList;
import java.util.List;

public class Parliament {
    private static Parliament parliament = null;
    private List<MemberOfParliament> members;
    private PrimeMinister pm;

    private Parliament() {
        members = new LinkedList<MemberOfParliament>();
        pm = null;
    }

    public static Parliament getInstance() {
        if (parliament == null) {
            parliament = new Parliament();
        }
        return parliament;
    }

    private int countMembers() {
        return members.size();
    }

    public void addMember() throws IndexOutOfBoundsException {
        if (countMembers() < 500) {
            members.add(new MemberOfParliament());
        } else {
            throw new IndexOutOfBoundsException("The maximum value of 500 is reached.");
        }
    }

    public PrimeMinister electPrimeMinister() {
        if (pm == null) {
            pm = new PrimeMinister(this);
        }
        return pm;
    }
}
