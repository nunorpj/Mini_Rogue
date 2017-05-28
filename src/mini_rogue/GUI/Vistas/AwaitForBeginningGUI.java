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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.Border;
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import javax.swing.JPanel;
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
<<<<<<< HEAD
public class AwaitForBeginningGUI extends JPanel implements Constantes{
    private JPanel centro;
    private JPanel menu;
=======
<<<<<<< HEAD
public class AwaitForBeginningGUI extends JPanel implements Constantes{
    private JPanel centro;
    private JPanel menu;
=======
<<<<<<< HEAD
public class AwaitForBeginningGUI extends JPanel implements Constantes{
    private JPanel centro;
    private JPanel menu;
=======
public class AwaitForBeginningGUI extends JPanel implements Constantes,Observer{
    static private JPanel centro;
    private JPanel menu;
    static private JPanel startingAreaPanel;
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
    private Modelo modelo;
    private JButton start;
    private JButton startingArea;
    private JButton startingDificulty;
    private JButton load;
    private JButton quit;
    
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
    private JSlider   area;
    private JLabel    choseArea;
    private JPanel startingAreaPanel;
    private JButton saveArea;
    
    private JPanel startingDificultyPanel;
    private JLabel  choseDificulty;
    private JSlider  DificultyJSlider;
    private JButton saveDificulty;
    
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
        AwaitForBeginningGUI(Modelo m){
            this.modelo=m;
            setBackground(Color.BLACK);
            setLayout(new BorderLayout());
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
            modelo.addObserver(this);
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
            criaObjGraf();
            disporVista();
            registarListeners();
        }

    private void criaObjGraf() {
        centro=new JPanel();
        centro.setBackground(Color.blue);
        
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
        menu=new JPanel();
        menu.setBackground(Color.black);
        
        
        start=new JButton(Start);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setMaximumSize(bSize);
        start.setMinimumSize(bSize);
        start.setPreferredSize(bSize);
        start.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        start.setBackground(new Color(15,145,99));
        start.setForeground(Color.white);
        start.setFocusPainted(false);
        start.setFont(new Font("Serif", Font.BOLD, 25));
        
        
        startingArea= new JButton(StartingArea);
        startingArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        startingArea.setMaximumSize(bSize);
        startingArea.setMinimumSize(bSize);
        startingArea.setPreferredSize(bSize);
        startingArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        startingArea.setBackground(new Color(15,145,99));
        startingArea.setForeground(Color.white);
        startingArea.setFocusPainted(false);
        startingArea.setFont(new Font("Serif", Font.BOLD, 25));
        
        startingDificulty = new JButton(StartingDificulty);
        startingDificulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        startingDificulty.setMaximumSize(bSize);
        startingDificulty.setMinimumSize(bSize);
        startingDificulty.setPreferredSize(bSize);
        startingDificulty.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        startingDificulty.setBackground(new Color(15,145,99));
        startingDificulty.setForeground(Color.white);
        startingDificulty.setFocusPainted(false);
        startingDificulty.setFont(new Font("Serif", Font.BOLD, 25));
        
        load=new JButton(Load);
        load.setAlignmentX(Component.CENTER_ALIGNMENT);
        load.setMaximumSize(bSize);
        load.setMinimumSize(bSize);
        load.setPreferredSize(bSize);
        load.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        load.setBackground(new Color(15,145,99));
        load.setForeground(Color.white);
        load.setFocusPainted(false);
        load.setFont(new Font("Serif", Font.BOLD, 25));
        
        quit=new JButton(Quit);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        quit.setMaximumSize(bSize);
        quit.setMinimumSize(bSize);
        quit.setPreferredSize(bSize);
        quit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        quit.setBackground(new Color(15,145,99));
        quit.setForeground(Color.white);
        quit.setFocusPainted(false);
        quit.setFont(new Font("Serif", Font.BOLD, 25));

        startingAreaPanel=new JPanel();
        startingAreaPanel.setBackground(Color.BLACK);
        
        choseArea=new JLabel ("Chose Your Starting Area:");
        choseArea.setForeground(Color.WHITE);
        choseArea.setSize(new Dimension(150,25));
        choseArea.setFont(new Font("Serif", Font.PLAIN, 20));
        choseArea.setAlignmentX(TOP_ALIGNMENT);
        choseArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        area=new JSlider (1, 14, 1);
        area.setMajorTickSpacing(13);
        area.setMinorTickSpacing(1);
        area.setPaintTicks(true);
        area.setPaintLabels(true);
        area.setMaximumSize(new Dimension(350,50));
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);
        
        saveArea=new JButton("Save");
        saveArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        saveArea.setBackground(new Color(15,145,99));
        saveArea.setForeground(Color.white);
        saveArea.setFocusPainted(false);
        saveArea.setFont(new Font("Serif", Font.BOLD, 25));
        saveArea.setMaximumSize(bSize);
        saveArea.setMinimumSize(bSize);
        saveArea.setPreferredSize(bSize);
        
        startingDificultyPanel=new JPanel();
        startingDificultyPanel.setBackground(Color.BLACK);

        choseDificulty=new JLabel ("Chose Your Starting Dificulty:");
        choseDificulty.setForeground(Color.WHITE);
        choseDificulty.setSize(new Dimension(150,25));
        choseDificulty.setFont(new Font("Serif", Font.PLAIN, 20));
        choseDificulty.setAlignmentX(TOP_ALIGNMENT);
        choseDificulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        DificultyJSlider=new JSlider(JSlider.VERTICAL, 1, 4, 1);
        DificultyJSlider.setMajorTickSpacing(1);
        DificultyJSlider.setPaintTicks(true);
        DificultyJSlider.setPaintLabels(true);
        DificultyJSlider.setForeground(Color.WHITE);
        DificultyJSlider.setMaximumSize(new Dimension(150,200));
        DificultyJSlider.setBackground(Color.BLACK);
        DificultyJSlider.setForeground(Color.WHITE);
        Hashtable labelTable = new Hashtable();
        labelTable.put(1, new JLabel("Casual") );
        labelTable.put(2, new JLabel("Normal") );
        labelTable.put(3, new JLabel("Hard") );
        labelTable.put(4,new JLabel("Impossible"));
        DificultyJSlider.setLabelTable( labelTable );

        saveDificulty= new JButton("Save");
        saveDificulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveDificulty.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        saveDificulty.setBackground(new Color(15,145,99));
        saveDificulty.setForeground(Color.white);
        saveDificulty.setFocusPainted(false);
        saveDificulty.setFont(new Font("Serif", Font.BOLD, 25));
        saveDificulty.setMaximumSize(bSize);
        saveDificulty.setMinimumSize(bSize);
        saveDificulty.setPreferredSize(bSize);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        
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
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
    }

    private void disporVista() 
     {     
          //this.add(centro,BorderLayout.CENTER);

          this.add(menu,BorderLayout.SOUTH);
          menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
          menu.add(Box.createRigidArea(new Dimension(0,20)));
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
          menu.add(start);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(startingArea);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(startingDificulty);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(load);
          menu.add(Box.createRigidArea(new Dimension(0,10)));
          menu.add(quit);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
          menu.add(Box.createRigidArea(new Dimension(0,20)));
          
          
          
         startingAreaPanel.setLayout(new BoxLayout(startingAreaPanel, BoxLayout.Y_AXIS));
         startingAreaPanel.add(Box.createRigidArea(new Dimension(0,250)));
         startingAreaPanel.add(choseArea);
         startingAreaPanel.add(Box.createRigidArea(new Dimension(0,25)));
         startingAreaPanel.add(area);
         startingAreaPanel.add(Box.createRigidArea(new Dimension(0,25)));
         startingAreaPanel.add(saveArea);
         
         startingDificultyPanel.setLayout(new BoxLayout(startingDificultyPanel, BoxLayout.Y_AXIS));
         startingDificultyPanel.add(Box.createRigidArea(new Dimension(0,200)));
         startingDificultyPanel.add(choseDificulty);
         startingDificultyPanel.add(Box.createRigidArea(new Dimension(0,10)));
         startingDificultyPanel.add(DificultyJSlider);
         startingDificultyPanel.add(Box.createRigidArea(new Dimension(0,10)));
         startingDificultyPanel.add(saveDificulty);
         

    }
        
 public void startAreaMenu(){
            
            add(startingAreaPanel,BorderLayout.CENTER);
            menu.setVisible(false);
         }
 
 public void startDificultyListner(){
           
        add(startingDificultyPanel,BorderLayout.CENTER);
         menu.setVisible(false);
 }
     
    private void registarListeners() {
        start.addActionListener(new StartListener());
        startingArea.addActionListener(new StartIngAreaListner());
        startingDificulty.addActionListener(new StartingDificultyListener());
        saveDificulty.addActionListener(new saveDificultyListner());
        saveArea.addActionListener(new saveAreaListner());
    }
    
    
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
          menu.add(Box.createRigidArea(new Dimension(0,100)));
    }
        

    private void registarListeners() {
        start.addActionListener(new StartListener());
        startingArea.addActionListener(new StartIngAreaListner());
    }
        
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master

  private  class saveDificultyListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           modelo.setstartDif(DificultyJSlider.getValue());
           removeAll();
            setBackground(Color.BLACK);
            setLayout(new BorderLayout());
            criaObjGraf();
            disporVista();
            registarListeners();
            repaint();
            revalidate();
        }
    }

  private  class saveAreaListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           modelo.setstartarea(area.getValue());
           removeAll();
            setBackground(Color.BLACK);
            setLayout(new BorderLayout());
            criaObjGraf();
            disporVista();
            registarListeners();
            repaint();
            revalidate();
        }
    }



    private  class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.start();
        }
    }

      private  class StartingDificultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            startDificultyListner();
        }
    }
      
    private  class StartIngAreaListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
         startAreaMenu();
         
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
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
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
        }
    }
}
