package com.government;

public abstract class Politician {
    protected String name;

    public abstract void debate(String topic);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
