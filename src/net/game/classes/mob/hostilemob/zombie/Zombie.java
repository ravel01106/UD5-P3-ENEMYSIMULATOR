package net.game.classes.mob.hostilemob.zombie;

import net.game.classes.mob.hostilemob.HostileMob;

public class Zombie extends HostileMob {

    public Zombie() {
        super(10, 4);
    }

    @Override
    public void move() {
        System.out.println("\t- The zombie moves to the character.");
    }

}
