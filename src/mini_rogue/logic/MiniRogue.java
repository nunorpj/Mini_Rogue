/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic;

import java.io.Serializable;
import mini_rogue.logic.states.AwaitBeginning;
import mini_rogue.logic.states.IStates;

/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MiniRogue implements Serializable {
    //chama metedos dos estados para implementar/alterar objetos do GameData
    private GameData GameData;
    private IStates state;
    //construtor
    public MiniRogue() {
        GameData = new GameData();
        state = new AwaitBeginning(GameData);
    }

    //retorna o GameData
    public GameData getGameLogic() {
        return GameData;
    }

    //retorna estado atua;
    public IStates getState() {
        return this.state;

    }

    //define/muda estado
    private void setState(IStates state) {
        this.state = state;

    }

//                ####################################
//                ##Metedos Communs a varios estados##
//                ####################################

    public int getArea() {
        return GameData.getArea();
    }

    public String getDificulty() { //string porque isto so interage com a TEXTUI
        switch (GameData.getDificulty()) {
            case 1:
                return "Casual";
            case 2:
                return "Normal";
            case 3:
                return "Hard";
            case 4:
                return "Impossible";
            default:
                return " ";
        }
    }

    public String CaracterText() {
        return GameData.CharacterText();
    }

//                ###############################################
//                ##Metedos referentes ao estado AwaitBeginning##
//                ###############################################

    public void SetStartingArea(int lvl) {
        GameData.setLastState(getState());
        setState(getState().setStartingArea(lvl));
    }                                              

    public void SetDificultylvl(int lvl) {
        GameData.setLastState(getState());
        setState(getState().setDifficultylvl(lvl));
    }

    public void StartGame() {
        GameData.setLastState(getState());
        setState(getState().startGame());
    }
//                ###################################################
//                ##Metedos referentes ao estado AwaitCardSelection##
//                ###################################################

    public String CardOnTableToString() {
        return GameData.CardOnTableToString();
    }

    public int Collunlvl() {
        return GameData.getCollun();
    }

    public String CardNameAtIndex(int index) {
        return GameData.CardNameAtIndex(index);
    }

    public void ResolvSelectedCard(int option) {
        GameData.setLastState(getState());
        setState(getState().selectCard(option));
    }

    //                #############################################
//                ##Metedos referentes ao estado AwaitTrading##
//                #############################################
    public boolean Buying(int option) {
        
        GameData.setLastState(getState());
        switch (option) {                
            case 1://1 e 2 custao o mesmo
            case 2:
                if (GameData.GetGold() >= 1)
                    setState(getState().buy(option));
                else return false;
                break;
            case 3:
                if (GameData.GetGold() >= 3)
                    setState(getState().buy(option));
                else return false;
                break;
            case 4:
                if (GameData.GetGold() >= 6)
                    setState(getState().buy(option));
                else return false;
                break;
            case 5:// 5,6,7,8 custao o mesmo
            case 6:
            case 7:
            case 8:
                if (GameData.GetGold() >= 8)
                    setState(getState().buy(option));
                else return false;
                break;

        }
        return true;
    }

    public void BackToCardSelecton() {
        GameData.setLastState(getState());
        setState(getState().backToCardSelection());
    }

    public int getStockForSell(int i) {
        switch (i) {
            case 1:
                return GameData.getArmor();
            case 2:
                return GameData.GetHowManySpells(1);//fire
            case 3:
                return GameData.GetHowManySpells(2);//ice
            case 4:
                return GameData.GetHowManySpells(3);//poison
            case 5:
                return GameData.GetHowManySpells(4);//heal

        }
        return 0;
    }

    public boolean Selling(int option) {
        switch (option) {
            case 1://armor
                if (GameData.getArmor() <= 0)
                    return false;
                else
                    break;
            case 2://fire
                if (GameData.GetHowManySpells(1) <= 0)
                    return false;
                else
                    break;
            case 3://ice
                if (GameData.GetHowManySpells(2) <= 0)
                    return false;
                else
                    break;
            case 4://poison
                if (GameData.GetHowManySpells(3) <= 0)
                    return false;
                else
                    break;
            case 5://heal
                if (GameData.GetHowManySpells(4) <= 0)
                    return false;
                else
                    break;

        }
        GameData.setLastState(getState());
        setState(getState().sell(option));
        return true;
    }

    public void ResolveResting(int option) {
        GameData.setLastState(getState());
        setState(getState().resolveResting(option));
    }

    public String getEnemyName() {
        return getState().enemyName();
    }

    public int getCharacterAtack() {
        return getState().getCharacterAttack();
    }

    public int getDungeonLvl() {
        return GameData.getDungeonLvl();
    }

    public void atack() {
        GameData.setLastState(getState());
        setState(getState().attack());
    }

    public void useFeats() {
        GameData.setLastState(getState());
        setState(getState().useFeats());
    }

    public void backToRollDices() {
        GameData.setLastState(getState());
        setState(getState().backToRollDices());
    }

    public boolean useSpells(int option) {
        if (GameData.GetHowManySpells(option) == 0)
            return false;
        GameData.setLastState(getState());
        setState(getState().useSpell(option));
        return true;
    }

    public boolean featsUsed() {
        return GameData.isFeatsUsed();
    }

    public void letsFight() {
        GameData.setLastState(getState());
        setState(getState().lestFight());
    }

    public boolean win() {
        return GameData.isaWinner();
    }

}
