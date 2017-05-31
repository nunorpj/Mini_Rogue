/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.states;

import mini_rogue.logic.Cards.Monsters.*;
import mini_rogue.logic.Cards.card;
import mini_rogue.logic.GameData;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitForSpell extends StateAdapter {

    private Monster enemy;

    public AwaitForSpell(GameData g, Monster monster) {
        super(g);
        this.enemy = monster;
        getGame().setFeatsUsed(false);
    }

    @Override
    public IStates useSpell(int option) {
        switch (option) {
            case 1://fire
                enemy.inflictDmgToMonster(8);
                break;
            case 2:// ice, monstro nao ataca
                getGame().getCharacter().RemoveSpell(option);
                return new RolledDices(getGame(), enemy);
            case 3://poison
                enemy.getPoisoned();
                break;
            case 4://heal
                getGame().getCharacter().AddOrRemoveHp(8);
                break;

        }
        
        getGame().getCharacter().RemoveSpell(option);
        return lestFight();
    }

    @Override
    public IStates lestFight() {
        
        ((Monster)enemy).getDMGFromPoison();
        if(((Monster)enemy).isItDeadYeah()==true){
            getGame().getCharacter().AddOrRemoveXp(((Monster)enemy).getYourReward());
            if(enemy instanceof BossMonsterCard){
                ((BossMonsterCard)enemy).rewardBoss();
                
            }
            return moveON();
        }
        int MDmg=enemy.getMonsterAtack()-getGame().getCharacter().getArmor();
        if(MDmg<0)
           MDmg=0;     
        getGame().getCharacter().AddOrRemoveHp(-MDmg);

        if (getGame().getCharacter().getHp() <= 0) {
            
            return new AwaitToEnd(getGame());
        }

        return new RolledDices(getGame(), enemy);
    }




}
