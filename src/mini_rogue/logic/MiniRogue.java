/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import mini_rogue.logic.states.AwaitBeginning;
import mini_rogue.logic.states.AwaitTrading;
import mini_rogue.logic.states.IStates;
import mini_rogue.logic.states.RolledDices;
import mini_rogue.logic.states.WaitForFeats;

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
    public String getMensagemAviso() {
        return GameData.getMensage();
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
    public void Buying(int option) {
        
        GameData.setLastState(getState());
        switch (option) {                
            case 1://1 e 2 custao o mesmo
            case 2:
                if (GameData.GetGold() >= 1){
                    if(option==1){
                        if(GameData.getCharacter().getFood()<6)
                        setState(getState().buy(option));
                            else
                                GameData.setMensage("You already have max food!");
                    break;
                    }
                    if(option==2) {
                        if( GameData.getCharacter().getHp()<20){
                            setState(getState().buy(option));
                        }else
                            GameData.setMensage("You already have max HP!");
                    break;
                    } 
                }else{
                    GameData.setMensage("No money");
                }
                    
                break;
            case 3:
                if (GameData.GetGold() >= 3)
                    if(GameData.getCharacter().getHp()+4<=20)
                        setState(getState().buy(option));
                    else 
                        GameData.setMensage("You can't have more tham 20 HP!!");
                else {
                    GameData.setMensage("No money");
                }
                break;
            case 4:
                if (GameData.GetGold() >= 6)
                    if(GameData.getCharacter().getArmor()<6)
                        setState(getState().buy(option));
                    else
                        GameData.setMensage("You Can't have more tham 6 pieces of armor!");
                else {
                    GameData.setMensage("No money");
                }
                break;
            case 5:// 5,6,7,8 custao o mesmo
            case 6:
            case 7:
            case 8:
                if (GameData.GetGold() >= 8)
                    if(GameData.getCharacter().GetHowManySpells(5)<2)
                        setState(getState().buy(option));
                    else
                        GameData.setMensage("You can't have more tham 2 spells!");
                else {
                    GameData.setMensage("No money");
                }
                break;

        }
        
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

//                ######################################################
//                ##Metedos referentes ao estado aWaitoptionsellection##
//                ######################################################
    public void ResolveResting(int option) {
        GameData.setLastState(getState());
        setState(getState().resolveResting(option));
    }
     public int getCharacterHP() {
        return GameData.getCharacter().getHp();
    }


//                ##########################################################################
//                ##Metedos referentes ao estado Rolleddices /waitforfeats /awaitforspells##
//                ##########################################################################
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

   public int getNunbDices(){
       return GameData.getCharacter().getNDices();
   }

    public boolean CheckIfYouCan(int option2) {
        switch(option2){
            case 1:
                    if(GameData.getCharacter().getHp()>2)
                        return true;
                break;
            case 2:
                  if(GameData.getCharacter().getXp()>1)
                        return true;
                break;
        }
        return false;
    }

    public void featsUsed(int option2, int option) {

                 GameData.setLastState(getState());
                 setState( getState().analize(option, option2));
    }

    public void backToRollDices() {
                    GameData.setLastState(getState());
                 setState( getState().BackToRolledDices());
    }
    
    public int getCharArmor(){
        return GameData.getArmor();
    }
    
    public int getCharXp(){
        return GameData.getCharacter().getXp();
    }
    public int getcharFood(){
        return GameData.getCharacter().getFood();
    }
   public int getcharGold(){
        return GameData.getCharacter().getGold();
    }
    
   public IStates getLastState(){
       return GameData.getLastState();
   }

   public ArrayList<String> getLogs(){
       return GameData.getLogs();
   }


private void saveGame(String fileName) throws IOException {
        ObjectOutputStream oout = null;
        try {

            //Create an object output stream connected to a file named fileName.
            oout = new ObjectOutputStream(new FileOutputStream(fileName));

            //Write/serialize the game object to the open object output stream.
            oout.writeObject(this);
        } catch(IOException e){
            return;
        }
        finally{
            
            //If the object output stream was successfuly created, close it.
            if(oout != null)
                try {
                    oout.close();
                }catch(IOException e){}
            
        }
    }

    public void handleSaveGameToFileOption(String name) {
        String fileName = name;
        
      
        if(fileName.length() < 1)
            return;

        try {
            saveGame(fileName);
        } catch (IOException ex) {
        }
    }
    
    
public MiniRogue loadGame(String fileName) throws IOException, ClassNotFoundException  {
 
        MiniRogue loadedGame;
        ObjectInputStream oin = null;
        
        try {

            //Create an object input stream connected to a file named fileName.
            oin = new ObjectInputStream(new FileInputStream(fileName));
            
            //Retrieve a serialized instance of ThreeInRowGame from the object input stream and return a reference to it.
            loadedGame = (MiniRogue)oin.readObject();

            try{
                if(oin != null)
                    oin.close();
            } catch(IOException e){e.printStackTrace();}


        }finally{
            //If the object input stream was successfuly created, close it.
            if(oin != null)
                oin.close();
        }
        return loadedGame;
    
    }
}
