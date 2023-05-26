package net.game.temp.classes.player;

public class Player {
    private int health;
    private int defense;
    private int force;
    final private int HEALTH_DEFAULT = 12;

    public Player(int defense, int force) {
        this.defense = defense;
        this.force = force;
        this.health = HEALTH_DEFAULT;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getForce() {
        return force;
    }

}