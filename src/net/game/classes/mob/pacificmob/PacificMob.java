package net.game.temp.classes.mob.pacificmob;

import net.game.temp.classes.mob.Mob;
import net.game.temp.interfaces.combat.Combat;
import net.game.temp.interfaces.damage.Damage;

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
