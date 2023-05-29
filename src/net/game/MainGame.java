package net.game;

import java.util.Random;
import java.util.Scanner;

import net.game.classes.mob.hostilemob.enderman.Enderman;
import net.game.classes.mob.hostilemob.zombie.Zombie;
import net.game.classes.mob.pacificmob.sheep.Sheep;
import net.game.classes.player.Player;

public class MainGame {
    static final Scanner KEYBOARD = new Scanner(System.in);
    static Random random = new Random();

    public static void printWelcomeMessage() {
        String msg = "Welcome to the enemy simulator!!!\n";
        msg += "Before starting, we will choose your weapon and your armor!!";
        System.out.println(msg);
    }

    public static void printMenuWeapon() {
        String msg = "Choose your weapon!:\n";
        msg += "a -> None.\nb-> Wooden sword.\n";
        msg += "c -> Iron sword.\nd-> Diamond sword.";
        System.out.println(msg);

    }

    public static void printMenuArmor() {
        String msg = "Choose your armor!:\n";
        msg += "a -> None.\nb-> Leather armor.\n";
        msg += "c -> Iron armor.\nd-> Diamond armor.";
        System.out.println(msg);
    }

    public static int chooseWeapon(String weapon) {
        String msg = "";
        int force = 0;
        switch (weapon) {
            case "a":
                force = 1;
                msg = "You will not have any weapon.";
                break;
            case "b":
                force = 2;
                msg = "You will have a wooden sword.";
                break;
            case "c":
                force = 3;
                msg = "You will not have a iron sword.";
                break;
            case "d":
                force = 5;
                msg = "You will not have a diamond sword.";
                break;
            default:
                msg = "You have not chosen any options, so ";
                msg += "you will not have any default weapon.";
                force = 1;
                break;
        }
        System.out.println(msg);
        return force;

    }

    public static int chooseArmor(String armor) {
        String msg = "";
        int defense = 0;
        switch (armor) {
            case "a":
                defense = 0;
                msg = "You will not have any armor.";
                break;
            case "b":
                defense = 1;
                msg = "You will have a leather armor.";
                break;
            case "c":
                defense = 2;
                msg = "You will not have a iron armor.";
                break;
            case "d":
                defense = 3;
                msg = "You will not have a diamond armor.";
                break;
            default:
                msg = "You have not chosen any options, so ";
                msg += "you will not have any default armor.";
                defense = 0;
                break;
        }
        System.out.println(msg);
        return defense;
    }

    public static void attackMob(Player playerOne, Zombie zombieOne) {
        System.out.println("\n\t- Player attacked Zombie:");
        zombieOne.receiveAttack(playerOne.attack());
    }

    public static void attackPlayer(Player playerOne, Zombie zombieOne) {
        System.out.println("\n\t- Zombie attacked Player:");
        playerOne.receiveAttack(zombieOne.attack());
    }

    public static void attackMob(Player playerOne, Enderman endermanOne) {
        System.out.println("\n\t- Player attacked enderman:");
        endermanOne.receiveAttack(playerOne.attack());
    }

    public static void attackPlayer(Player playerOne, Enderman endermanOne) {
        System.out.println("\n\t- Enderman attacked Player:");
        playerOne.receiveAttack(endermanOne.attack());
    }

    public static void attackMob(Player playerOne, Sheep sheepOne) {
        System.out.println("\n\t- Player attacked sheep:");
        sheepOne.receiveAttack(playerOne.attack());
    }

    public static void fightZombie(Player playerOne) {
        System.out.println("\n\n-----PLAYER FIGHTS AGAINST A ZOMBIE-----");
        Zombie zombieOne = new Zombie();

        while (playerOne.getHealth() > 0 && zombieOne.getHealth() > 0) {
            int randomActionZombie = random.nextInt(2) + 1;
            System.out.println("\n---PLAYER'S TURN---");
            attackMob(playerOne, zombieOne);

            if (zombieOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Player has won!!!!");
                return;
            }

            System.out.println("\n---ZOMBIE'S TURN---");

            if (randomActionZombie == 1) {
                attackPlayer(playerOne, zombieOne);

            } else {
                zombieOne.move();
            }

            if (playerOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Zombie has won!!!!");
            }

        }
    }

    public static void fightEnderman(Player playerOne) {
        System.out.println("\n\n-----PLAYER FIGHTS AGAINST A ENDERMAN-----");
        Enderman endermanOne = new Enderman();

        while (playerOne.getHealth() > 0 && endermanOne.getHealth() > 0) {
            int randomActionEnderman = random.nextInt(2) + 1;
            attackMob(playerOne, endermanOne);

            if (endermanOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Player has won!!!!");
                return;
            }

            System.out.println("\n---ENDERMAN'S TURN---");

            if (randomActionEnderman == 1) {
                attackPlayer(playerOne, endermanOne);

            } else {
                endermanOne.move();
            }

            if (playerOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Enderman has won!!!!");
            }

        }
    }

    public static void fightSheep(Player playerOne) {
        System.out.println("\n\n-----PLAYER FIGHTS AGAINST A SHEEP-----");
        Sheep sheepOne = new Sheep();

        while (sheepOne.getHealth() > 0) {
            attackMob(playerOne, sheepOne);

            if (sheepOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Player has won!!!!");
                return;
            }

            System.out.println("\n---SHEEP'S TURN---");
            sheepOne.move();

        }
    }

    public static void chooseCombat(Player playerOne) {
        int randomCombat = random.nextInt(3) + 1;
        switch (randomCombat) {
            case 1:
                fightZombie(playerOne);
                break;
            case 2:
                fightEnderman(playerOne);
                break;
            case 3:
                fightSheep(playerOne);
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        printWelcomeMessage();
        printMenuWeapon();
        int force = chooseWeapon(KEYBOARD.nextLine());
        printMenuArmor();
        int defense = chooseArmor(KEYBOARD.nextLine());
        Player playerOne = new Player(defense, force);
        chooseCombat(playerOne);

    }
}
