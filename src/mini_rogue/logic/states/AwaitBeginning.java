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
public class AwaitBeginning extends StateAdapter {

    public AwaitBeginning(GameData g) {
        super(g);
    }

    @Override
    public IStates setStartingArea(int area) {
        getGame().SetStartingArea(area);
        return this;
    }

    @Override
    public IStates setDifficultylvl(int lvl) {
        getGame().SetDificulty(lvl);
        return this;
    }

    @Override
    public IStates startGame() {

        if (getGame().initialize())//devia dar sem o cast, porque nao da'?
            return new AwaitCardSelection(getGame());
        return this;
    }
}
