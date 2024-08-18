package com.griffin.pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import com.griffin.pokemon.moves.BaseMove;

public abstract class Pokemon {
    private String name;
    private int level;
    private int hpStat;
    private int atkStat;
    private int spAtkStat;
    private int defStat;
    private int spDefStat;
    private int speStat;
    private ArrayList<String> weaknesses;
    private ArrayList<String> resistances;
    private ArrayList<String> immunities;
    private BaseMove move1;
    private BaseMove move2;
    private BaseMove move3;
    private BaseMove move4;
    
    public Pokemon(String name, int level, ArrayList<String> weaknesses, ArrayList<String> resistances, ArrayList<String> immunities,
                                    int hpStat, int atkStat, int defStat, int spAtkStat, int spDefStat, int speStat) {
        this.name = name;
        this.level = level;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.immunities = immunities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public ArrayList<String> getResistances() {
        return resistances;
    }

    public ArrayList<String> getImmunities() {
        return immunities;
    }

    public void gainImmunity(String immunity) {
        immunities.add(immunity);
    }

    public void learnMove(BaseMove move) {
        //making variables for names of moves and the name of deleted move
        String newMove = move.getName();
        String name1 = move1.getName();
        String name2 = move2.getName();
        String name3 = move3.getName();
        String name4 = move4.getName();
        String deletedMove = "null";

        //checking for empty move
        if (move1 == null) {
            move1 = move;
        } else if(move2 == null) {
            move2 = move;
        } else if(move3 == null) {
            move3 = move;
        } else if(move4 == null) {
            move4 = move;
        } else {
            
            //makes scanner
            Scanner scanner = new Scanner(System.in);
            //if moves are full ask if they want to replace
            System.out.println("You're moves are full already which move would you like to replace one of your current moves for "
                                                                                                         + newMove + "?");
            String scan = scanner.nextLine();
            
            //checking that scan is yes or no
            while (scan.toLowerCase() != "yes" || scan.toLowerCase() != "no") {
                System.out.println("Invalid response, please give a yes or no answer");
                scan = scanner.nextLine();
            }

            //asks which move should be replaced
            if (scan.toLowerCase() == "yes") {
                System.out.println("Your current moves are " + name1 + ", " + name2 + ", " + name3 + ", " + name4);
                System.out.println("Would you like to replace the move?");
                scan = scanner.nextLine();
            
            //checking that scan is one of the moves
            while (scan.toLowerCase() != name1 || scan.toLowerCase() != name2 || scan.toLowerCase() != name3 || scan.toLowerCase() != name4) {
                System.out.println("Invalid response, please write out one of your move names to replace");
                System.out.println("Your current moves are " + name1 + ", " + name2 + ", " + name3 + ", " + name4);
                scan = scanner.nextLine();
            }

            //replace old move with new move
            if (scan == name1) {
                deletedMove = name1;
                move1 = move;
            } else if (scan == name2) {
                deletedMove = name2;
                move2 = move;
            } else if (scan == name3) {
                deletedMove = name3;
                move3 = move;
            } else if (scan == name4) {
                deletedMove = name4;
                move4 = move;
            }

            //first success message
            System.out.println("1... 2... 3... Ta da! " + name + " has forgotten " + deletedMove + " and now knows " + newMove +"!");
            scanner.close();

            }  else if (scan.toLowerCase() == "no") {
                System.out.println("Okay, you will not learn " + newMove);
            }
        }
        //2nd success message
        if (deletedMove == "null") {
        System.out.println(name + "has successfully learned " + newMove + "!");
        }
    }
}