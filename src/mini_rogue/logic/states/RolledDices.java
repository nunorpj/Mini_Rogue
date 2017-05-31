/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.states;

import java.util.ArrayList;
import mini_rogue.logic.Cards.Monsters.*;
import mini_rogue.logic.Dice;
import mini_rogue.logic.GameData;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RolledDices extends StateAdapter {

    private Monster enemy;

    public RolledDices(GameData g, Monster monster) {
        super(g);
        this.enemy = monster;
        if(getGame().getLastState() instanceof WaitForFeats){
            
        }else
            getGame().getCharacter().setAtack();


    }

    public int getMonsterLife() {
        return enemy.getMonsterHp();
    }
    
     public int getMonsterMaxhp() {
        return enemy.getMonsterMaxHp();
    }
        public int getMonsterAttack() {
      
        return enemy.getMonsterAtack();
    }

    @Override
    public IStates attack() {
        enemy.inflictDmgToMonster(getGame().getCharacter().getAtck());
            if(enemy.isItDeadYeah()==true){
                getGame().getCharacter().AddOrRemoveXp(enemy.getYourReward());
                if(enemy instanceof BossMonsterCard){
                ((BossMonsterCard)enemy).rewardBoss();
                }
                getGame().setFeatsUsed(false);
                return moveON();
            }
         getGame().setFeatsUsed(false);
        return new AwaitForSpell(getGame(), enemy);
    }

    @Override
    public String enemyName() {
        if (enemy instanceof MonsterCard)
            return ((MonsterCard) enemy).getMonsterName();
        else if (enemy instanceof BossMonsterCard)
            return ((BossMonsterCard) enemy).getMonsterName();
        else if (enemy instanceof MonsterEventCard)
            return ((MonsterEventCard) enemy).getMonsterName();
        return "";
    }

    @Override
    public int getCharacterAttack() {
        return getGame().getCharacter().getAtck();

    }

    
    @Override
    public IStates useFeats() {
        return new WaitForFeats(getGame(), this.enemy);
    }

    public int getDiceNumber(int index) {
        ArrayList<Dice> dices = getGame().getDiceList();
        if (index < 0 || index >= dices.size())
            return -1;
        else
            return dices.get(index).getDiceNumber();
    }
}
