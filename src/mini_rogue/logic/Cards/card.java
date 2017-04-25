/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.Cards;

import mini_rogue.logic.GameData;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class card {
    private final String name;
    private GameData game;

    public card(String name, GameData game) {
        this.name = name;
        this.game = game;
    }

    

    public String getName() {
        return this.name;
    }

    protected GameData getGame() {
        return game;
    }

    //@Override
    public boolean resolveCard(int op) {
        return true;
    }
}
