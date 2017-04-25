/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards.Monsters;

import mini_rogue.logic.Cards.card;
import mini_rogue.logic.GameData;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Monster extends card {
    
    private String monsterName;
    private int DMG;
    private int Reward;
    private int hp;
    private boolean poisoned = false;
    
    
   public Monster(String nome, GameData game) {
        super(nome, game);
  
    }
    
   public void setDmg(int dmg){
       this.DMG=dmg;
   }
   public void setReward(int reward){
       this.Reward=reward;
   }
   public void setHp(int hp){
       this.hp=hp;
   }
   public void setName(String name){
       this.monsterName=name;
   }
   
   
    public String getMonsterName() {
        return this.monsterName;
    }

    public int getMonsterAtack() {
        return this.DMG;
    }

    public int getMonsterHp() {
        return this.hp;
    }

    public void inflictDmgToMonster(int i) {
        this.hp = this.hp - i;
    }

    public boolean isItDeadYeah() {
        return this.hp <= 0;
    }

    public int getYourReward() {
        return this.Reward;
    }

    public void getPoisoned() {
        this.poisoned = true;
    }

    public void getDMGFromPoison() {
        if (poisoned == true)
            this.hp = this.hp - 5;
    }

}
