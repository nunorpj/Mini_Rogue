/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.modelo;

import java.io.IOException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Observable;
import mini_rogue.GUI.Vistas.Constantes;
import mini_rogue.logic.MiniRogue;
import mini_rogue.logic.states.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Modelo extends Observable implements Constantes{
    private MiniRogue miniRogue;
    private int aux;
   public Modelo(){
        miniRogue=new MiniRogue();
   }

public String getCardName(int index){
    switch(index){
        case 0:
            return miniRogue.CardNameAtIndex(0);
        case 1:
         {
            if(miniRogue.Collunlvl()>=2)
                    return miniRogue.CardNameAtIndex(index);
            else
                    return BACK;
        }
        case 2:
        {
            if(miniRogue.Collunlvl()>=2)
                    return miniRogue.CardNameAtIndex(index);
            else
                    return BACK;
        }
        case 3:
          {
            if(miniRogue.Collunlvl()>=3)
                    return miniRogue.CardNameAtIndex(index);
            else
                    return BACK;
        }
        case 4:
         {
            if(miniRogue.Collunlvl()>=4)
                    return miniRogue.CardNameAtIndex(index);
            else
                    return BACK;
        }
            
        case 5:
         {
            if(miniRogue.Collunlvl()>=4)
                    return miniRogue.CardNameAtIndex(index);
            else
                    return BACK;
        }
        case 6:
                return miniRogue.CardNameAtIndex(index);

    }
    return BACK;
}

public int gethp(){
    
    return miniRogue.getCharacterHP();
}

public int getXp(){
    return miniRogue.getCharXp();
}
public int getArmor(){
    return miniRogue.getCharArmor();
}
public int getFood(){
    return miniRogue.getcharFood();
}
public int getGold(){
    return miniRogue.getcharGold();
}

    public IStates getState() {

        return miniRogue.getState();
        }
    
    public IStates getLastState(){
        return miniRogue.getLastState();
    }

    public void start() {
        miniRogue.StartGame();
        setChanged();
        notifyObservers();
    }
    
public void setstartarea(int x){
    miniRogue.SetStartingArea(x);
}
public void setstartDif(int x){
    miniRogue.SetDificultylvl(x);

}
public void RestingSelectoin(int i){
    miniRogue.ResolveResting(i);
   setChanged();
    notifyObservers();
}
public int getstock(int i){
    return miniRogue.getStockForSell(i);
}

    public void buy(int i) {
        miniRogue.Buying(i);
        setChanged();
        notifyObservers();
    }
    
    public void sell(int i){
        miniRogue.Selling(i);
        setChanged();
        notifyObservers();
    }
    
    public void resolvecard(int i){
        miniRogue.ResolvSelectedCard(i);
        setChanged();
        notifyObservers();
    }
    
    public void BackToCardSelecton(){
        miniRogue.BackToCardSelecton();
        setChanged();
        notifyObservers();
    }
    

   public String EnemyName(){
       return miniRogue.getEnemyName();
   }
   
   public int EnemyAttack(){
       return ((RolledDices)miniRogue.getState()).getMonsterAttack();
   }
      public int EnemyHp(){
          aux= ((RolledDices)miniRogue.getState()).getMonsterLife();
       return aux;
   }
   
      public int CollunLvl(){
          return miniRogue.Collunlvl();
      }
     public int EnemyLife(){
       return aux;
   }
      public int getEnemyMaxHp(){
         return ((RolledDices)miniRogue.getState()).getMonsterMaxhp();
      }
      
      
      public int getHeroAttack(){
          return miniRogue.getCharacterAtack();
      }
      
      public void attack(){
          miniRogue.atack();
          setChanged();
          notifyObservers();
      }
      
      public int getArea(){
          return miniRogue.getArea();
      }
      public void feats(){
          miniRogue.useFeats();
          setChanged();
          notifyObservers();
      }
      
    public void Spells(int option){
        miniRogue.useSpells(option);
        setChanged();
        notifyObservers();
    }
    
    public void letsFight(){
            miniRogue.letsFight();
           setChanged();
          notifyObservers();
    }
    
    public int diceVauleNumber(int i){

          //return ((RolledDices) miniRogue.getState()).getDiceNumber(i);
         return miniRogue.getGameLogic().getCharacter().getDice(i).getDiceNumber();
}
    
    public int getNumberOfDices(){
        return miniRogue.getNunbDices();
    }
    
    public void backToRolledDices(){
       
        miniRogue.backToRollDices();
        setChanged();
        notifyObservers();
    }
    
    public void useFeats(int option1,int option2){
        miniRogue.featsUsed(option1, option2);
        setChanged();
        notifyObservers();
    }
    public boolean isFeatsAlreadyUsed(){
        return miniRogue.featsUsed();
    }
    
    public void newGame(){
        miniRogue=new MiniRogue();
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<String> getLogs(){
        return miniRogue.getLogs();
    }
    public boolean youWin(){
        return miniRogue.win();
    }
    
    public void load(String path){
        try{
           miniRogue= miniRogue.loadGame(path);
        }catch(IOException | ClassNotFoundException e){
            System.err.println(e);
            return;
        }
        
        setChanged();
        notifyObservers();
    }
    
    
    public void save(String path){
        miniRogue.handleSaveGameToFileOption(path);
    }
    
}

