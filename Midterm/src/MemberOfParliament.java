package com.government;

import java.util.Random;

public class MemberOfParliament extends Politician {

    @Override
    public void debate(String topic) {
        System.out.println(topic + " for our citizens!!");
    }

    public Boolean vote() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
