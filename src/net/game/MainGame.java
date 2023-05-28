package net.game;

import java.util.Random;
import java.util.Scanner;

import net.game.classes.mob.hostilemob.zombie.Zombie;
import net.game.classes.player.Player;

public class MainGame {
    static final Scanner KEYBOARD = new Scanner(System.in);

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

    public static void fightZombie(Player playerOne) {
        System.out.println("\n\n-----PLAYER FIGHTS AGAINST A ZOMBIE-----");
        Zombie zombieOne = new Zombie();
        Random random = new Random();

        while (playerOne.getHealth() > 0 && zombieOne.getHealth() > 0) {
            int randomActionZombie = random.nextInt(2) + 1;
            System.out.println("\n---PLAYER'S TURN---\n\t- Player attacked Zombie:");
            zombieOne.receiveAttack(playerOne.attack());

            if (zombieOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Player has won!!!!");
                return;
            }
            System.out.println("\n---ZOMBIE'S TURN---");
            if (randomActionZombie == 1) {
                System.out.println("\n- Zombie attacked Player:");
                playerOne.receiveAttack(zombieOne.attack());

            } else {
                zombieOne.move();
            }

            if (playerOne.getHealth() <= 0) {
                System.out.println("\n---FINISH COMBAT---\n\t- Zombie has won!!!!");
            }

        }
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

    public static void main(String[] args) throws Exception {
        printWelcomeMessage();
        printMenuWeapon();
        int force = chooseWeapon(KEYBOARD.nextLine());
        printMenuArmor();
        int defense = chooseArmor(KEYBOARD.nextLine());
        Player playerOne = new Player(defense, force);
        fightZombie(playerOne);

    }
}
