package net.game.temp.classes.mob.pacificmob.sheep;

import net.game.temp.classes.mob.pacificmob.PacificMob;

public class Sheep extends PacificMob {

    public Sheep() {
        super(5);
    }

    @Override
    public void move() {
        System.out.println("The sheep moves in the field.");
    }

}
