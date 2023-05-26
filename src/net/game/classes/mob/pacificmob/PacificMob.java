package net.game.classes.mob.pacificmob;

import net.game.classes.mob.Mob;
import net.game.interfaces.damage.Damage;

public abstract class PacificMob extends Mob implements Damage {

    public PacificMob(int health) {
        super(health);
    }

    @Override
    public void receiveAttack(int attack) {
        String msg = "The damage recieved is ";
        health -= attack;
        msg += attack + " ⚔️, and the current health is ";
        msg += this.health + " 💘.";
        System.out.println(msg);
    }

}
