package mini_rogue.logic.states;

import mini_rogue.logic.Cards.card;
import mini_rogue.logic.Dice;
import mini_rogue.logic.GameData;

import java.util.ArrayList;
import mini_rogue.logic.Cards.Monsters.Monster;

/**
 * Created by Chamuscado on 10/04/2017.
 */
public class WaitForFeats extends StateAdapter {

    Monster enemy;
    ArrayList<Dice> dices;

    public WaitForFeats(GameData g, Monster monster) {
        super(g);
        this.enemy = monster;
        dices = getGame().getDiceList();
    }

    public int getNumberOfDices() {
        return dices.size();
    }

    public int getDiceNumber(int index) {
        if (index < 0 || index >= dices.size())
            return -1;
        else
            return dices.get(index).getDiceNumber();
    }

    public boolean rollDiceAgain(int index) {
        if (index < 0 || index >= dices.size())
            return false;
        else {
            getGame().getCharacter().recalcAtack(index);
        }
        return true;
    }
       
    public int[] getDiceFaces(int index) {
        if (index < 0 || index >= dices.size())
            return null;
        else
            return dices.get(index).getNumbers();
    }
    
    @Override
    public IStates analize(int option, int option2) {
                         switch(option2){
                      case 1:
                          getGame().getCharacter().AddOrRemoveHp(-2);
                          break;
                      case 2:
                          getGame().getCharacter().AddOrRemoveXp(-1);
                          break;
                  }
        
        if (option == 0)
            return this;
        else if (rollDiceAgain(option - 1)){
            getGame().setFeatsUsed(true);
           return new RolledDices(getGame(), enemy); 
        }
        return this;
    }
    @Override
    public IStates BackToRolledDices() {
        return new RolledDices(getGame(), enemy);
    }

}
