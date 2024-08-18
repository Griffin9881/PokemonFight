package com.griffin.pokemon;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.griffin.pokemon.moves.BaseMove;
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
    private BaseMove move1;
    private BaseMove move2;
    private BaseMove move3;
    private BaseMove move4;
    
    public Pokemon(String name, String type1, Optional<String> type2, int level, ArrayList<String> weaknesses, ArrayList<String> resistances, ArrayList<String> immunities,
                                    int hpStat, int atkStat, int defStat, int spAtkStat, int spDefStat, int speStat) {
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

    public void effectOnStat(StatStagesLevels level, Stats Stat) {
        switch (Stat) {
            case Stats.HP:
                currentHPMod += level.label;
                hpStat = (int)(baseHpStat * StatusConstants.StatusStages[currentHPMod]);
                break;
            case Stats.ATK:
                currentAtkMod += level.label;
                atkStat = (int)(baseAtkStat * StatusConstants.StatusStages[currentAtkMod]);
                break;
            case Stats.DEF:
                currentDefMod += level.label;
                defStat = (int)(baseDefStat * StatusConstants.StatusStages[currentDefMod]);
                break;
            case Stats.SP_ATK:
                currentSpAtkMod += level.label;
                spAtkStat = (int)(baseSpAtkStat * StatusConstants.StatusStages[currentSpAtkMod]);
                break;
            case Stats.SP_DEF:
                currentSpDefMod += level.label;
                spDefStat = (int)(baseSpDefStat * StatusConstants.StatusStages[currentSpDefMod]);
                break;
            case Stats.SPE:
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

    public void addTrigger(int rounds, Triggers trigger) {
        triggerRounds.add(rounds);
        triggerType.add(trigger);
    }

    public void removeTrigger(Triggers trigger) {
        switch (trigger) {
            case Triggers.REMOVE_PARALYSIS:
                loseCondition(Conditions.PARALYSIS);
                effectOnStat(StatStagesLevels.plus1, Stats.SPE);
                break;
            case REMOVE_BURN:
                loseCondition(Conditions.BURN);
            default:
                break;
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