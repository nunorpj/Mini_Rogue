/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic.states;

import java.io.Serializable;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IStates extends Serializable {
    IStates startGame();

    IStates setDifficultylvl(int lvl);

    IStates setStartingArea(int area);

    IStates selectCard(int option);

    IStates sell(int option);//recebe info do jogador e dentro desta funçao é que escolhe o que vender

    IStates buy(int option);//recebe info do jogador e da carta e dentro desta funçao é que escolhe o que comprar

    IStates backToCardSelection();

    IStates resolveResting(int option);

    IStates useFeats();

    IStates backToRollDices();

    IStates useSpell(int option);

    IStates rollDices();//

    int getCharacterAttack();

    IStates attack();

    IStates lestFight();

    String enemyName();

    IStates moveON();

    IStates quit();
}
