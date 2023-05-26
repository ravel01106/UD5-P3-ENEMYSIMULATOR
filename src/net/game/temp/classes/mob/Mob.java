package net.game.temp.classes.mob;

public abstract class Mob {
    private int health;

    public Mob(int health) {
        this.health = health;
    }

    public abstract void move();
}