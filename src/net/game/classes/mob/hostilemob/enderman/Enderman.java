package net.game.classes.mob.hostilemob.enderman;

import net.game.classes.mob.hostilemob.HostileMob;

public class Enderman extends HostileMob {

    public Enderman() {
        super(14, 6);
    }

    @Override
    public void move() {
        System.out.println("The Enderman teleports behind.");
    }

}
