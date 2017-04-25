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
public class StateAdapter implements IStates {

    private GameData game;

    public StateAdapter(GameData g) {
        this.game = g;
    }

    public GameData getGame() {
        return game;
    }


    @Override
    public IStates startGame() {
        return this;
    }

    @Override
    public IStates setDifficultylvl(int lvl) {
        return this;
    }

    @Override
    public IStates setStartingArea(int area) {
        return this;
    }

    @Override
    public IStates selectCard(int option) {
        return this;
    }

    @Override
    public IStates sell(int option) {
        return this;
    }

    @Override
    public IStates buy(int option) {
        return this;
    }

    @Override
    public IStates rollDices() {
        return this;
    }

    @Override
    public IStates quit() {
        return this;
    }

    @Override
    public IStates backToCardSelection() {
        return this;
    }

    @Override
    public IStates resolveResting(int option) {
        return this;
    }

    @Override
    public IStates useFeats() {
        return this;
    }

    @Override
    public IStates backToRollDices() {
        return this;
    }

    @Override
    public IStates moveON() {
        if (getGame().getCharacter().getFood() > 0) {
            getGame().getCharacter().AddOrRemoveFood(-1);
        } else
            getGame().getCharacter().AddOrRemoveHp(-2);

        if (getGame().getCharacter().getHp() <= 0)
            return new AwaitBeginning(getGame());

        if (getGame().getCollun() == 4 && (getGame().getArea() == 2 || getGame().getArea() == 4 || getGame().getArea() == 10 || getGame().getArea() == 14)) {
            getGame().nexColumm();
            return new AwaitCardSelection(getGame());
        } else if (getGame().getCollun() == 4 && (getGame().getArea() != 2 || getGame().getArea() != 4 || getGame().getArea() != 10 || getGame().getArea() != 14)) {
            getGame().SetStartingArea(getGame().getArea() + 1);

            return new AwaitCardSelection(getGame());
        } else if (getGame().getCollun() == 5) {
            getGame().SetStartingArea(getGame().getArea() + 1);
            return new AwaitCardSelection(getGame());
        }
        if (getGame().getCollun() > 0 && getGame().getCollun() < 4)
            getGame().nexColumm();


        return new AwaitCardSelection(getGame());
    }

    @Override
    public int getCharacterAttack() {
        return 0;
    }

    @Override
    public String enemyName() {
        return "";
    }

    @Override
    public IStates attack() {
        return this;
    }

    @Override
    public IStates useSpell(int option) {
        return this;
    }

    @Override
    public IStates lestFight() {
        return this;
    }


}
