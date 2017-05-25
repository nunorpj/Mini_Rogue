/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.modelo;

import java.util.Observable;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
import mini_rogue.GUI.Vistas.Constantes;
import mini_rogue.GUI.Vistas.VistaFrame;
import mini_rogue.logic.GameData;
import mini_rogue.logic.MiniRogue;
import mini_rogue.logic.states.AwaitBeginning;
import mini_rogue.logic.states.*;
<<<<<<< HEAD
=======
=======
>>>>>>> origin/master
>>>>>>> origin/master

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
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
<<<<<<< HEAD
=======
=======
public class Modelo extends Observable{

    public void oi(){
>>>>>>> origin/master
>>>>>>> origin/master
        setChanged();
        notifyObservers();
    }
    
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
public void setstartarea(int x){
    miniRogue.SetStartingArea(x);
}
public void setstartDif(int x){
    miniRogue.SetDificultylvl(x);

}
<<<<<<< HEAD
public void RestingSelectoin(int i){
    miniRogue.ResolveResting(i);
   setChanged();
    notifyObservers();
}

}
=======
}
=======

}
>>>>>>> origin/master
>>>>>>> origin/master
