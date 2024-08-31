package com.griffin.pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import com.griffin.SelectMoves;
import com.griffin.pokemon.moves.AllMoves;
import com.griffin.pokemon.statusEnums.Conditions;
import com.griffin.pokemon.statusEnums.StatStagesLevels;
import com.griffin.pokemon.statusEnums.Stats;
import com.griffin.pokemon.statusEnums.StatusConstants;

public abstract class Pokemon {
    private ArrayList<Integer> triggerRounds = new ArrayList<Integer>();
    private ArrayList<Triggers> triggerType = new ArrayList<Triggers>();
    private String name;
    private String type1;
    private String type2;
    private int level;
    private int baseHpStat;
    private int hpStat;
    private int currentHPMod = 1;
    private int baseAtkStat;
    private int atkStat;
    private int currentAtkMod = 1;
    private int baseSpAtkStat;
    private int spAtkStat;
    private int currentSpAtkMod = 1;
    private int baseDefStat;
    private int defStat;
    private int currentDefMod = 1;
    private int baseSpDefStat;
    private int spDefStat;
    private int currentSpDefMod = 1;
    private int baseSpeStat;
    private int speStat;
    private int currentSpeMod = 1;
    private ArrayList<Conditions> conditions = new ArrayList<Conditions>();
    private ArrayList<String> weaknesses = new ArrayList<String>();
    private ArrayList<String> resistances = new ArrayList<String>();;
    private ArrayList<String> immunities = new ArrayList<String>();;
    private AllMoves move1;
    private AllMoves move2;
    private AllMoves move3;
    private AllMoves move4;
    private AllMoves[] possibleMoves;
    
    public Pokemon(String name, String type1, Optional<String> type2, int level, ArrayList<String> weaknesses, ArrayList<String> resistances, ArrayList<String> immunities,
                                    int hpStat, int atkStat, int defStat, int spAtkStat, int spDefStat, int speStat, AllMoves[] possibleMoves) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2.isPresent() ? type2.get() : "Blank";
        this.level = level;
        this.baseHpStat = hpStat;
        this.hpStat = this.baseHpStat;
        this.baseAtkStat = atkStat;
        this.atkStat = this.baseAtkStat;
        this.baseDefStat = defStat;
        this.defStat = this.baseDefStat;
        this.baseSpAtkStat = spAtkStat;
        this.spAtkStat = this.baseSpAtkStat;
        this.baseSpDefStat = spDefStat;
        this.spDefStat = this.baseSpDefStat;
        this.baseSpeStat = speStat;
        this.speStat = this.baseSpeStat;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.immunities = immunities;
        this.possibleMoves = possibleMoves;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentHP() {
        return hpStat;
    }

    public void maxHP() {
        hpStat = baseHpStat;
    }

    public void subtractHP(int dmg) {
        hpStat -= dmg;
    }

    public void HealHp(int heal) {
        hpStat += heal;
    }

    public int getAtkStat() {
        return atkStat;
    }

    public int getDefStat() {
        return defStat;
    }

    public int getSpAtkStat() {
        return spAtkStat;
    }

    public int getSpDefStat() {
        return spDefStat;
    }

    public int getSpeStat() {
        return speStat;
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

    public ArrayList<Conditions> getConditions() {
        return conditions;
    }

    public AllMoves[] getMoves() {
        return possibleMoves;
    }

    public String[] getMovesString() {
        ArrayList<String> allMovesString = new ArrayList<String>();
        for (int i = 0; i < possibleMoves.length; i++) {
            allMovesString.add(possibleMoves[i].label);
        }
        String[] moves = {};
        moves = allMovesString.toArray(moves);
        return moves;
    }

    public String getMove1() {
        if(!(move1==null)){
            return move1.label;
        }
        else {
            return "";
        }
    }

    public String getMove2() {
        if(!(move3==null)){
            return move2.label;
        }
        else {
            return "";
        }    
    }

    public String getMove3() {
        if(!(move3==null)){
            return move3.label;
        }
        else {
            return "";
        }
    }

    public String getMove4() {
        if(!(move4==null)){
            return move4.label;
        }
        else {
            return "";
        }
    }

    public void effectOnStat(StatStagesLevels level, Stats Stat) {
        switch (Stat) {
            case HP:
                currentHPMod += level.label;
                hpStat = (int)(baseHpStat * StatusConstants.StatusStages[currentHPMod]);
                break;
            case ATK:
                currentAtkMod += level.label;
                atkStat = (int)(baseAtkStat * StatusConstants.StatusStages[currentAtkMod]);
                break;
            case DEF:
                currentDefMod += level.label;
                defStat = (int)(baseDefStat * StatusConstants.StatusStages[currentDefMod]);
                break;
            case SP_ATK:
                currentSpAtkMod += level.label;
                spAtkStat = (int)(baseSpAtkStat * StatusConstants.StatusStages[currentSpAtkMod]);
                break;
            case SP_DEF:
                currentSpDefMod += level.label;
                spDefStat = (int)(baseSpDefStat * StatusConstants.StatusStages[currentSpDefMod]);
                break;
            case SPE:
                currentSpeMod += level.label;
                speStat = (int)(baseSpeStat * StatusConstants.StatusStages[currentSpeMod]);
                break;
        }
    }

    public void gainCondition(Conditions condition) {
        conditions.add(condition);
    }

    public void loseCondition(Conditions condition) {
        conditions.remove(condition);
    }

    public void gainImmunity(String immunity) {
        immunities.add(immunity);
    }

    public void loseImmunity(String immunity) {
        for (int index = 0; index < immunities.size(); index++) {
            if (immunities.get(index) == immunity) {
                immunities.remove(index);
            }
        }
    }

    public void addTrigger(int rounds, Triggers trigger) {
        triggerRounds.add(rounds);
        triggerType.add(trigger);
    }

    public void removeTrigger(Triggers trigger) {
        switch (trigger) {
            case REMOVE_PARALYSIS:
                loseCondition(Conditions.PARALYSIS);
                effectOnStat(StatStagesLevels.plus1, Stats.SPE);
                break;
            case REMOVE_BURN:
                loseCondition(Conditions.BURN);
                break;
            case LOSE_IMMUNITY_GROUND:
                loseImmunity("Ground");
        }

        int index = triggerType.indexOf(trigger);
        triggerType.remove(index);
        triggerRounds.remove(index);
    }

    @SuppressWarnings("unused")
    public boolean checkCondition(Conditions condition) {
            for (int i = 0; i < conditions.size(); i++) {
                if (conditions.get(i) == condition) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    

    public void learnMove(AllMoves move, Scanner scanner) {
        //making variables for names of moves and the name of deleted move
        String newMove = SelectMoves.oneTimeMove(move).getName();
            String name1 = "";
            String name2 = "";
            String name3 = "";
            String name4 ="";
            String deletedMove = "null";
        if (Arrays.asList(possibleMoves).contains(move)) {
            //checking for empty move
            if (move1 == null) {
                move1 = move;
            } else {
                name1 = SelectMoves.oneTimeMove(move1).getName();
                if(move2 == null) {
                    move2 = move;
                } else {
                    name2 = SelectMoves.oneTimeMove(move2).getName();
                    if(move3 == null) {
                        move3 = move;
                    } else {
                        name3 = SelectMoves.oneTimeMove(move3).getName();
                        if(move4 == null) {
                            move4 = move;
                        } else {
                            name4 = SelectMoves.oneTimeMove(move4).getName();
            
                        //if moves are full ask if they want to replace
                        System.out.println("You're moves are full already which move would you like to replace one of your current moves for "
                                                                                                                    + newMove + "?");
                        String scan = scanner.nextLine();

                        //checking that scan is yes or no
                        while (!scan.toLowerCase().equals("yes") && !scan.toLowerCase().equals("no")) {
                            System.out.println("Invalid response, please give a yes or no answer");
                            scan = scanner.nextLine();
                        }

                        //asks which move should be replaced
                        if (scan.toLowerCase().equals("yes")) {
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

                        }  else if (scan.toLowerCase().equals("no")) {
                            System.out.println("Okay, you will not learn " + newMove);
                        }
                    }}}}

            //2nd success message
            if (deletedMove.equals("null")) {
            System.out.println(name + " has successfully learned " + newMove + "!");
            } else {
            System.out.println("Failed, " + this.getName() + " is not able to learn " + SelectMoves.oneTimeMove(move).getName());
            }
        }
    }
}
