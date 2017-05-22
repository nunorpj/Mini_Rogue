/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import mini_rogue.GUI.modelo.Modelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitForBeginningGUI extends JPanel implements Constantes,Observer{
    static private JPanel centro;
    private JPanel menu;
    static private JPanel startingAreaPanel;
    private Modelo modelo;
    private JButton start;
    private JButton startingArea;
    private JButton startingDificulty;
    private JButton load;
    private JButton quit;
    
        AwaitForBeginningGUI(Modelo m){
            this.modelo=m;
            setBackground(Color.BLACK);
            setLayout(new BorderLayout());
            modelo.addObserver(this);
            criaObjGraf();
            disporVista();
            registarListeners();
        }

    private void criaObjGraf() {
        centro=new JPanel();
        centro.setBackground(Color.blue);
        
        
        menu=new JPanel();
        menu.setBackground(Color.black);
        
        startingAreaPanel=new JPanel();
        startingAreaPanel.setBackground(Color.yellow);
        
        
        start=new JButton(Start);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setMaximumSize(new Dimension(150,25));
        start.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        start.setBackground(new Color(15,145,99));
        start.setForeground(Color.white);
        
        startingArea= new JButton(StartingArea);
        startingArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        startingArea.setMaximumSize(new Dimension(150,25));
        startingArea.setMaximumSize(new Dimension(150,25));
        startingArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        startingArea.setBackground(new Color(15,145,99));
        startingArea.setForeground(Color.white);
        
        startingDificulty = new JButton(StartingDificulty);
        startingDificulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        startingDificulty.setMaximumSize(new Dimension(150,25));
        startingDificulty.setMaximumSize(new Dimension(150,25));
        startingDificulty.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        startingDificulty.setBackground(new Color(15,145,99));
        startingDificulty.setForeground(Color.white);
                
        load=new JButton(Load);
        load.setAlignmentX(Component.CENTER_ALIGNMENT);
        load.setMaximumSize(new Dimension(150,25));
        load.setMaximumSize(new Dimension(150,25));
        load.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        load.setBackground(new Color(15,145,99));
        load.setForeground(Color.white);
               
        quit=new JButton(Quit);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        quit.setMaximumSize(new Dimension(150,25));
        quit.setMaximumSize(new Dimension(150,25));
        quit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        quit.setBackground(new Color(15,145,99));
        quit.setForeground(Color.white);
    }

    private void disporVista() 
     {     
          //this.add(centro,BorderLayout.CENTER);

          this.add(menu,BorderLayout.SOUTH);
          menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
          menu.add(Box.createRigidArea(new Dimension(0,20)));
          menu.add(start);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(startingArea);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(startingDificulty);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(load);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(quit);
          menu.add(Box.createRigidArea(new Dimension(0,100)));
    }
        

    private void registarListeners() {
        start.addActionListener(new StartListener());
        startingArea.addActionListener(new StartIngAreaListner());
    }
        
    @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image logo =Imagem.getImagem(LOGO);
        Image tocha=Imagem.getImagem(TOCHA);
        if(logo!=null||tocha!=null){
            g.drawImage(logo, LARGURA/2-155, ALTURA/2-200, this);
            g.drawImage(tocha, 200, ALTURA/2-200, this);
            g.drawImage(tocha, LARGURA-200-109, ALTURA/2-200, this);

        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }

    @Override
    public void update(Observable o, Object o1) {
         repaint();
    }

    private static class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //modelo.start()
        }
    }

    private static class StartIngAreaListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
             //add(startingAreaPanel);
        }
    }
}
