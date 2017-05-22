/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import java.awt.Color;
import javax.swing.JPanel;
import mini_rogue.GUI.modelo.Modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitCardSelectioGUI extends JPanel {
        private Modelo modelo;

    AwaitCardSelectioGUI(Modelo m){
        this.modelo=m;
        setBackground(Color.BLACK);
    }
}
