/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic;

import java.io.Serializable;
import mini_rogue.logic.Spells.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Character implements Serializable{
    private int lvl;
    private int xp;
    private int hp;
    private int gold;
    private int food;
    private int armor;
    private ArrayList<Spell> Spells;
    private ArrayList<Dice> dices;
    private int atack;

    Character() {
        this.lvl = 1;
        this.armor = 1;
        this.hp = 5;
        this.gold = 50;
        this.food = 6;
        this.xp = 0;
        Spells = new ArrayList<>();
        dices = new ArrayList<>();
        dices.add(new Dice());
    }

    public void setCharacterlvl(int lvl) {//Vai ser usado?
        this.lvl = lvl;
    }

    public void setCharacterStatos(int armor, int hp, int gold, int food) {
        this.armor = armor;
        this.food = food;
        this.gold = gold;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Character{" + "lvl=" + lvl + ", xp=" + xp + ", hp=" + hp + ", gold=" + gold + ", food=" + food + ", armor=" + armor + '}';
    }

    int getGold() {
        return this.gold;
    }

    public void AddOrRemoveFood(int x) {
        if(this.food + x>6)
            this.food=6;
        else
            this.food = this.food + x;
    }

    public void AddOrRemoveHp(int i) {
        if(this.hp + i>20)
            this.hp=20;
        else
            this.hp = this.hp + i;
    }

    public void AddOrRemoveGold(int i) {
        if(this.gold + i>20)
            this.gold=20;
        else
            this.gold = this.gold + i;
    }

    public void AddOrRemoveArmor(int i) {
        if(this.armor + i>6)
            this.armor=6;
        else
            this.armor = this.armor + i;
    }

    public void AddSpell(Spell s) {
        if(Spells.size()==2){
            Spells.remove(ThreadLocalRandom.current().nextInt(0, 2));
        }
        Spells.add(s);
    }

    public int getArmor() {
        return this.armor;
    }

    int GetHowManySpells(int x) {
        int count = 0;
        switch (x) {
            case 1://fire
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof FireSpell)
                        count++;
                return count;
            case 2://ice
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof IceSpell)
                        count++;
                return count;
            case 3:
                ;//poison
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof PoisonSpell)
                        count++;
                return count;
            case 4://heal
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof HealSpell)
                        count++;
                return count;
            case 5://all
                return Spells.size();

        }
        return 0;
    }

    public void RemoveSpell(int x) {
        switch (x) {
            case 1://fire
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof FireSpell) {
                        Spells.remove(i);
                        break;
                    }
                break;
            case 2://ice
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof IceSpell) {
                        Spells.remove(i);
                        break;
                    }
                break;
            case 3:
                ;//poison
                for (int i = 0; i < Spells.size(); i++) {
                    Spells.remove(i);
                    break;
                }
                break;
            case 4://heal
                for (int i = 0; i < Spells.size(); i++)
                    if (Spells.get(i) instanceof HealSpell) {
                        Spells.remove(i);
                        break;
                    }


        }
    }

    public void AddOrRemoveXp(int i) {
        this.xp = this.xp + i;
    }

    public void setAtack() {
        this.atack = 1;
        
        for (int i = 0; i < dices.size(); i++) {
            dices.get(i).roll();
            atack += dices.get(i).getDiceNumber();
        }
    }

    public void recalcAtack(int diceToChanged) {

        if (diceToChanged < 0 || diceToChanged >= dices.size())
            return;

        this.atack = 1;
        dices.get(diceToChanged).roll();

        for (int i = 0; i < dices.size(); i++) {
            atack += dices.get(i).getDiceNumber();
        }
    }

    public int getAtck() {
        return this.atack;
    }

    public int getFood() {
        return this.food;
    }

    public ArrayList<Dice> getDices() {
        return dices;
    }

    public int getHp() {
        return this.hp;
    }

    public void lvlUp() {
        switch (this.lvl) {
            case 1:
                if (this.xp >= 6) {
                    this.lvl = 2;
                    dices.add(new Dice());
                }
                break;
            case 2:
                if (this.xp >= 12) {
                    this.lvl = 3;
                    dices.add(new Dice());
                }
                break;
            case 3:
                if (this.xp >= 18) {
                    this.lvl = 4;
                    dices.add(new Dice());
                }
                break;
        }
    }
}
    
