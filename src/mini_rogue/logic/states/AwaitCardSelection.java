/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package mini_rogue.logic.states;

import mini_rogue.logic.Cards.Monsters.*;
import mini_rogue.logic.GameData;


/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitCardSelection extends StateAdapter {

    public AwaitCardSelection(GameData g) {
        super(g);
        getGame().getCharacter().lvlUp();

    }

    @Override
    public IStates selectCard(int option) {
        String s = "";
        switch (getGame().getCollun()) {
            case 1:
                s = getGame().CardNameAtIndex(0);
                break;
            case 2:
                if (option == 1)
                    s = getGame().CardNameAtIndex(1);
                else
                    s = getGame().CardNameAtIndex(2);
                break;
            case 3:
                s = getGame().CardNameAtIndex(3);
                break;
            case 4:
                if (option == 1)
                    s = getGame().CardNameAtIndex(4);
                else
                    s = getGame().CardNameAtIndex(5);
                break;
            case 5:
                s = getGame().CardNameAtIndex(6);
                break;
        }

        int index = getCardIndex(option);
        if (index == -1)
            return this;


        if (s.equalsIgnoreCase("Resting Card"))            //atualizar o statos do character
            return new AwaitOptionSelection(getGame());
        else if (s.equalsIgnoreCase("Trap Card"))          //funcao da trap (randon ?)
        {
            getGame().getCard(index).resolveCard(option);
            return moveON();                                                // escolher uma trap rand e volta ao awainting for selection
        } else if (s.equals("Monster Card")) {
            getGame().getCharacter().setAtack();
            return new RolledDices(getGame(), new MonsterCard(getGame().getDungeonLvl(), getGame().getArea(), getGame())); // return figth;
        } else if (s.equals("Event Card"))                                //chama uma funcao,atualiza stats ATENCAO! pode sair um mostro!
        {
            if (getGame().getCard(index).resolveCard(option)) {
                getGame().getCharacter().setAtack();
                return new RolledDices(getGame(), new MonsterEventCard(getGame().getDungeonLvl(), getGame().getArea(), getGame()));// return figth;
            } else
                return moveON();                                                //e volta a AwaitCardselection
        } else if (s.equals("Merchant Card"))
            return new AwaitTrading(getGame());
        else if (s.equals("Treasure Card"))                             //chama uma funcao,atualiza stats
        {
            getGame().getCard(index).resolveCard(option);
            return moveON();                                                //e volta a AwaitCardselection
        } else if (s.equals("Boss Monster")) {
            getGame().getCharacter().setAtack();
            return new RolledDices(getGame(), new BossMonsterCard(getGame().getDungeonLvl(), getGame().getArea(), getGame())); // return figth;
        }
        return this;
    }

    private int getCardIndex(int op) {
        int col = getGame().getCollun();
        int index = -1;
        switch (col) {
            case 1:
                index = 0;
                break;
            case 2:
                index = op == 1 ? 1 : 2;
                break;
            case 3:
                index = 3;
                break;
            case 4:
                index = op == 1 ? 4 : 5;
                break;
            case 5:
                index=6;
                break;
        }
        return index;
    }

}