/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.modelo;

import java.util.Observable;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Modelo extends Observable{

    public void oi(){
        setChanged();
        notifyObservers();
    }
    

}
