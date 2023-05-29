package net.game.classes.mob.hostilemob;

import net.game.classes.mob.Mob;
import net.game.interfaces.combat.Combat;

public abstract class HostileMob extends Mob implements Combat {
    protected int force;

    public HostileMob(int health, int force) {
        super(health);
        this.force = force;

    }

    @Override
    public int attack() {
        return this.force;
    }

    @Override
    public void receiveAttack(int attack) {
        String msg = "\t- The damage recieved is ";
        health -= attack;
        if (health < 0) {
            health = 0;
        }
        msg += attack + " ⚔︎, and the current health is ";
        msg += this.health + "♡.";
        System.out.println(msg);
    }
}
