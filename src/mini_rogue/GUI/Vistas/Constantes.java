/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Constantes {
    int  ALTURA=720;
    int LARGURA=1280;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int x=dim.width/2-640;
    int y=dim.height/2-360;
    
    Color margem = new Color(201,180,137);
          
        JPanel n =new JPanel();
        JPanel s =new JPanel();
        JPanel e =new JPanel();
        JPanel w =new JPanel();
    
    
    
    
    
    
    String Start="Start";
    String StartingArea= "Set Starting Area!";
    String StartingDificulty= "Set Starting Dificulty";
    String Quit="Quit!";
    String Load= "Load Game!";
    
    
    String LOGO= "logo";
    String PATH_IMG_LOGO = "imagens/logo.jpg";
    
    String TOCHA= "tocha";
    String PATH_IMG_TOCHA= "imagens/tocha.png";
    
    
}
