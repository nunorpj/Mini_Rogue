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

    public void analize(int option) {
        if (option == 0)
            return;
        else if (rollDiceAgain(option - 1))
            getGame().setFeatsUsed(true);

    }

    @Override
    public IStates backToRollDices() {
        return new RolledDices(getGame(), enemy);
    }
}
