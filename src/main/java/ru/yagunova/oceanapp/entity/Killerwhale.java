package ru.yagunova.oceanapp.entity;

public class Killerwhale {
    private int health = 100;
    private int energy = 100;
    private float mouth = 2.5F;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public float getMouth() {
        return mouth;
    }
}
