/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.states;

import mini_rogue.logic.GameData;
import mini_rogue.logic.Spells.FireSpell;
import mini_rogue.logic.Spells.HealSpell;
import mini_rogue.logic.Spells.IceSpell;
import mini_rogue.logic.Spells.PoisonSpell;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitTrading extends StateAdapter {

    public AwaitTrading(GameData g) {
        super(g);
    }


    @Override
    public IStates sell(int option) {
        switch (option) {
            case 1://armor
                getGame().getCharacter().AddOrRemoveArmor(-1);
                getGame().getCharacter().AddOrRemoveGold(3);
                break;
            case 2://fire
                getGame().getCharacter().AddOrRemoveGold(4);
                getGame().getCharacter().RemoveSpell(1);
                break;
            case 3://ice
                getGame().getCharacter().AddOrRemoveGold(4);
                getGame().getCharacter().RemoveSpell(2);
                break;
            case 4://poison
                getGame().getCharacter().AddOrRemoveGold(4);
                getGame().getCharacter().RemoveSpell(3);
                break;
            case 5://heal
                getGame().getCharacter().AddOrRemoveGold(4);
                getGame().getCharacter().RemoveSpell(4);
                break;

        }
        return this;
    }

    @Override
    public IStates buy(int option) {

        switch (option) {
            case 1://food ration
                getGame().getCharacter().AddOrRemoveFood(1);
                getGame().getCharacter().AddOrRemoveGold(-1);
                break;
            case 2://potion
                getGame().getCharacter().AddOrRemoveHp(1);
                getGame().getCharacter().AddOrRemoveGold(-1);
                break;
            case 3://big potion
                getGame().getCharacter().AddOrRemoveHp(4);
                getGame().getCharacter().AddOrRemoveGold(-3);
                break;
            case 4://armor
                getGame().getCharacter().AddOrRemoveArmor(1);
                getGame().getCharacter().AddOrRemoveGold(-6);
                break;
            case 5://fire
                getGame().getCharacter().AddSpell(new FireSpell());
                getGame().getCharacter().AddOrRemoveGold(-8);
                break;
            case 6://ice
                getGame().getCharacter().AddSpell(new IceSpell());
                getGame().getCharacter().AddOrRemoveGold(-8);
                break;
            case 7://poison
                getGame().getCharacter().AddSpell(new PoisonSpell());
                getGame().getCharacter().AddOrRemoveGold(-8);
                break;
            case 8://heal
                getGame().getCharacter().AddSpell(new HealSpell());
                getGame().getCharacter().AddOrRemoveGold(-8);
                break;

        }
        return this;
    }

    @Override
    public IStates backToCardSelection() {//ver se e' a ultima coluna, se for avancar de area

        return moveON();//esta no stateAdapter
    }
}
