/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.modelo;

import java.util.Observable;
import mini_rogue.GUI.Vistas.Constantes;
import mini_rogue.GUI.Vistas.VistaFrame;
import mini_rogue.logic.GameData;
import mini_rogue.logic.MiniRogue;
import mini_rogue.logic.states.AwaitBeginning;
import mini_rogue.logic.states.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Modelo extends Observable implements Constantes{
    private MiniRogue miniRogue;
    
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
    
   public String EnemyCardName(){
       String e =miniRogue.getEnemyName();
       switch(e){
           case "Undead Soldier":
           case "Skeleton":
           case "Undead Knight":
           case "Serpent Knight":
           case "Og's Sanctum Guard":
                     return MONSTER_CARD_BIG;
           case "Skeleton Lord":
           case "Undead Lord":
           case "Serpent Demon":
           case "Undead Giant":
           case "Og's Remains":
               return BOSS_BIG;
           
       }
       
       return EVENT_CARD_BIG;
   }
   public String EnemyName(){
       return miniRogue.getEnemyName();
   }
   
   public int EnemyAttack(){
       return ((RolledDices)miniRogue.getState()).getMonsterAttack();
   }
      public int EnemyHp(){
       return ((RolledDices)miniRogue.getState()).getMonsterLife();
   }
   
      public int CollunLvl(){
          return miniRogue.Collunlvl();
      }
      
      public int getEnemyMaxHp(){
         return ((RolledDices)miniRogue.getState()).getMonsterMaxhp();
      }
      
      
      public int getHeroAttack(){
          return((RolledDices)miniRogue.getState()).getCharacterAttack();
      }
      
      public void attack(){
          miniRogue.atack();
          setChanged();
          notifyObservers();
      }
      
}
