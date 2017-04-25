/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.states;

import mini_rogue.logic.GameData;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitOptionSelection extends StateAdapter {

    public AwaitOptionSelection(GameData g) {
        super(g);
    }

    @Override
    public IStates resolveResting(int option) {

        switch (option) {
            case 1:
                getGame().getCharacter().AddOrRemoveXp(1);
                break;
            case 2:
                getGame().getCharacter().AddOrRemoveFood(1);
                break;
            case 3:
                getGame().getCharacter().AddOrRemoveHp(2);
                break;
        }

        return moveON();
    }


}
