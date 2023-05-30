package net.game.classes.player;

import net.game.interfaces.combat.Combat;

public class Player implements Combat {
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

    @Override
    public int attack() {
        return this.force;
    }

    @Override
    public void receiveAttack(int attack) {
        String msg = "\t- The damage recieved is ";
        int damageReceived = attack - this.defense;
        if (damageReceived < 0) {
            damageReceived = 0;
        }
        this.health -= damageReceived;
        if (this.health < 0) {
            this.health = 0;
        }
        msg += damageReceived + " ⚔︎, and the current health is ";
        msg += this.health + " ♡.";
        System.out.println(msg);
    }

}