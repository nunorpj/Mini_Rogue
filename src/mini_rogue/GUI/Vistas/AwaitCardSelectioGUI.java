/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> origin/master
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import static mini_rogue.GUI.Vistas.Constantes.*;
import mini_rogue.GUI.modelo.Modelo;


<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import java.awt.Color;
import javax.swing.JPanel;
import mini_rogue.GUI.modelo.Modelo;

>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
public class AwaitCardSelectioGUI extends JPanel implements Constantes {
        private Modelo modelo;
        private JPanel rightPanel;
        private JPanel InfoPanel;
        private JButton quit;
        private JLabel hp_icon;
        private JLabel armor_icon;
        private JLabel coin_icon;
        private JLabel xp_icon;
        private JLabel food_icon;
        private JLabel fire_icon;
         private JLabel ice_icon;
        private JLabel heal_icon;
        private JLabel poison_icon;
        
        private JLabel fire;
        private JLabel ice;
        private JLabel poison;
        private JLabel heal;
        
        private JButton card0;
        private JButton card1;
        private JButton card2;
        private JButton card3;
        private JButton card4;
        private JButton card5;
        private JButton card6;
        private JPanel table;
        
        private JPanel southPanel;
        private JPanel logGAme;
        private JProgressBar Hp;
        private JProgressBar food;
        private JProgressBar xp;
        private JProgressBar gold;
        private JProgressBar armor;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
public class AwaitCardSelectioGUI extends JPanel {
        private Modelo modelo;
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master

    AwaitCardSelectioGUI(Modelo m){
        this.modelo=m;
        setBackground(Color.BLACK);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
        
        setLayout(new BorderLayout());
        
        criaObjGraf();
        disporVista();
<<<<<<< HEAD
        registarListeners();
=======
       //registarListeners();
>>>>>>> origin/master
       
    }
       
    private void CriaCards(){
        card0=new JButton();
<<<<<<< HEAD
        String teste1=modelo.getCardName(0);
=======
<<<<<<< HEAD
        String teste1=modelo.getCardName(0);
=======
>>>>>>> origin/master
>>>>>>> origin/master
        card0.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(0))));
        card0.setMargin(new Insets(0, 0, 0, 0));
        card0.setBorder(null);      
        
        card1=new JButton();
        card1.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(1))));
        card1.setMargin(new Insets(0, 0, 0, 0));
        card1.setBorder(null);
        
        card2=new JButton();
        card2.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(2))));
        card2.setMargin(new Insets(0, 0, 0, 0));
        card2.setBorder(null);
        
        card3=new JButton();
        card3.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(3))));
        card3.setMargin(new Insets(0, 0, 0, 0));
        card3.setBorder(null);
       
        card4=new JButton();
        card4.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(4))));
        card4.setMargin(new Insets(0, 0, 0, 0));
        card4.setBorder(null);      
        
        card5=new JButton();
        card5.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(5))));
        card5.setMargin(new Insets(0, 0, 0, 0));
        card5.setBorder(null);
        
        card6=new JButton();
      
        card6.setIcon(new ImageIcon(Imagem.getImagem(BOSS)));
        card6.setMargin(new Insets(0, 0, 0, 0));
        card6.setBorder(null);
        
       
        
    }
    
    
    private void criaObjGraf() {
        InfoPanel = new JPanel();
        InfoPanel.setBackground(new Color(0, 0, 0, 140));
        
        table = new JPanel();
        table.setOpaque(false);
        
        CriaCards();

        southPanel=new JPanel();
        southPanel.setOpaque(false);//sem backgroud
        
       rightPanel= new JPanel();
       rightPanel.setOpaque(false);
        
        InfoPanel.setPreferredSize(new Dimension(240, 180));
        InfoPanel.setMaximumSize(new Dimension(240, 180));
        InfoPanel.setMinimumSize(new Dimension(240, 180));
        InfoPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));

        logGAme=new JPanel();
        logGAme.setBackground(new Color(0, 0, 0, 140));
        
        logGAme.setPreferredSize(new Dimension(240, 180));
        logGAme.setMaximumSize(new Dimension(240, 180));
        logGAme.setMinimumSize(new Dimension(240, 180));
        logGAme.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
        
        Hp = new JProgressBar(0, 20);
        Hp.setValue(modelo.gethp());
        Hp.setString(modelo.gethp()+"/20");
        Hp.setStringPainted(true);
        Hp.setPreferredSize(new Dimension(150, 20));
        Hp.setMaximumSize(new Dimension(150, 20));
        Hp.setMinimumSize(new Dimension(150, 20));
        Hp.setForeground(Color.RED);
        Hp.setBorder(new LineBorder(margem));
        Hp.setBackground(new Color(250, 250,250, 250));
       
        food = new JProgressBar(0, 6);
        food.setValue(modelo.getFood());
        food.setString(modelo.getFood()+"/6");
        food.setStringPainted(true);
        food.setPreferredSize(new Dimension(150, 20));
        food.setMaximumSize(new Dimension(150, 20));
        food.setMinimumSize(new Dimension(150, 20));
        food.setForeground(Color.MAGENTA);
        food.setBorder(new LineBorder(margem));
        food.setBackground(new Color(250, 250,250, 250));
        
        armor = new JProgressBar(0, 6);
        armor.setValue(modelo.getArmor());
        armor.setString(modelo.getArmor()+"/5");
        armor.setStringPainted(true);
        armor.setPreferredSize(new Dimension(150, 20));
        armor.setMaximumSize(new Dimension(150, 20));
        armor.setMinimumSize(new Dimension(150, 20));
        armor.setForeground(Color.GRAY);
        armor.setBorder(new LineBorder(margem));
        armor.setBackground(new Color(250, 250,250, 250));
        
        xp = new JProgressBar(0, 18);
        xp.setValue(modelo.getXp());
        xp.setString(modelo.getXp()+"/18");
        xp.setStringPainted(true);
        xp.setPreferredSize(new Dimension(150, 20));
        xp.setMaximumSize(new Dimension(150, 20));
        xp.setMinimumSize(new Dimension(150, 20));
        xp.setForeground(Color.GREEN);
        xp.setBorder(new LineBorder(margem));
        xp.setBackground(new Color(250, 250,250, 250));
        
        gold = new JProgressBar(0, 20);
        gold.setValue(modelo.getGold());
        gold.setString(modelo.getGold()+"/20");
        gold.setStringPainted(true);
        gold.setPreferredSize(new Dimension(150, 20));
        gold.setMaximumSize(new Dimension(150, 20));
        gold.setMinimumSize(new Dimension(150, 20));
        gold.setForeground(Color.yellow);
        gold.setBorder(new LineBorder(margem));
        gold.setBackground(new Color(250, 250,250, 250));
        
        hp_icon = new JLabel(new ImageIcon(Imagem.getImagem(VIDA)));
        
        armor_icon= new JLabel(new ImageIcon(Imagem.getImagem(SHIELD)));      
        coin_icon=new JLabel(new ImageIcon(Imagem.getImagem(COIN)));
        food_icon= new JLabel(new ImageIcon(Imagem.getImagem(FOOD)));
        xp_icon=new JLabel(new ImageIcon(Imagem.getImagem(XP)));
        fire_icon= new JLabel(new ImageIcon(Imagem.getImagem(FIRE)));
        heal_icon =new JLabel(new ImageIcon(Imagem.getImagem(HEAL)));
        poison_icon= new JLabel(new ImageIcon(Imagem.getImagem(POISON)));
        ice_icon=new JLabel(new ImageIcon(Imagem.getImagem(ICE)));
        
<<<<<<< HEAD
        fire=new JLabel(modelo.getstock(2)+"");
        fire.setFont(new Font("Arial", Font.BOLD, 20));
        fire.setForeground(Color.WHITE);
        ice=new JLabel(modelo.getstock(3)+"");
        ice.setFont(new Font("Arial", Font.BOLD, 20));
        ice.setForeground(Color.WHITE);
        poison=new JLabel(modelo.getstock(4)+"");
        poison.setFont(new Font("Arial", Font.BOLD, 20));
        poison.setForeground(Color.WHITE);
        heal=new JLabel(modelo.getstock(5)+"");
        heal.setFont(new Font("Arial", Font.BOLD, 20));
        heal.setForeground(Color.WHITE);
                  
=======
        fire=new JLabel("9");
        fire.setFont(new Font("Arial", Font.BOLD, 20));
        fire.setForeground(Color.WHITE);
        ice=new JLabel("9");
        ice.setFont(new Font("Arial", Font.BOLD, 20));
        ice.setForeground(Color.WHITE);
        poison=new JLabel("9");
        poison.setFont(new Font("Arial", Font.BOLD, 20));
        poison.setForeground(Color.WHITE);
        heal=new JLabel("9");
        heal.setFont(new Font("Arial", Font.BOLD, 20));
        heal.setForeground(Color.WHITE);
>>>>>>> origin/master
        
    }
    
    
    
  private void  disporCard(){
        SpringLayout tableLayout = new SpringLayout();
        table.setLayout(tableLayout);

        //imagem da vida
        tableLayout.putConstraint(SpringLayout.WEST, card0, 15, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card0, 200, SpringLayout.WEST, table);
        table.add(card0);
        
         tableLayout.putConstraint(SpringLayout.WEST, card1, 240, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card1, 30, SpringLayout.WEST, table);
        table.add(card1);
        
         tableLayout.putConstraint(SpringLayout.WEST, card2, 240, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card2, 350, SpringLayout.WEST, table);
        table.add(card2);
        
        tableLayout.putConstraint(SpringLayout.WEST, card3, 460, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card3, 200, SpringLayout.WEST, table);
        table.add(card3);
        
         tableLayout.putConstraint(SpringLayout.WEST, card4, 680, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card4, 30, SpringLayout.WEST, table);
        table.add(card4);
        
        tableLayout.putConstraint(SpringLayout.WEST, card5, 680, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card5, 350, SpringLayout.WEST, table);
        table.add(card5);
        
        
        
        tableLayout.putConstraint(SpringLayout.WEST, card6, 900, SpringLayout.WEST, table);
        tableLayout.putConstraint(SpringLayout.NORTH, card6, 200, SpringLayout.WEST, table);
        table.add(card6);
        
    }
    
    
    private void disporVista() {
        
        add(table,BorderLayout.CENTER);
        
        disporCard();
        
        
        InfoPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());
        southPanel.setLayout(new BorderLayout());
        southPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        southPanel.add(Box.createRigidArea(new Dimension(50,0)),BorderLayout.WEST);
        southPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.SOUTH);

        rightPanel.add(Box.createRigidArea(new Dimension(30,0)),BorderLayout.EAST);
        rightPanel.add(Box.createRigidArea(new Dimension(0,50)),BorderLayout.SOUTH);
        rightPanel.add(Box.createRigidArea(new Dimension(0,350)),BorderLayout.NORTH);

        southPanel.add(logGAme,BorderLayout.CENTER);
        rightPanel.add(InfoPanel,BorderLayout.CENTER);
        
        
        SpringLayout info = new SpringLayout();
        InfoPanel.setLayout(info);
        
        //imagem da vida
        info.putConstraint(SpringLayout.WEST, hp_icon, 15, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, hp_icon, 5, SpringLayout.WEST, InfoPanel);
       //vida
        info.putConstraint(SpringLayout.WEST, Hp, 55, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, Hp,5, SpringLayout.WEST, InfoPanel);
        
        //food icon
        info.putConstraint(SpringLayout.WEST, food_icon, 15, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, food_icon, 40, SpringLayout.WEST, InfoPanel);
        
        //food
        info.putConstraint(SpringLayout.WEST, food, 55, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, food, 40, SpringLayout.WEST, InfoPanel);
        
        
        //icon da armadura
        info.putConstraint(SpringLayout.WEST, armor_icon, 15, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, armor_icon, 80, SpringLayout.WEST, InfoPanel);
        //armadura
          info.putConstraint(SpringLayout.WEST, armor, 55, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, armor, 80, SpringLayout.WEST, InfoPanel);


//icon do money
        info.putConstraint(SpringLayout.WEST, coin_icon, 15, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, coin_icon, 120, SpringLayout.WEST, InfoPanel);
        //gold
        info.putConstraint(SpringLayout.WEST, gold, 55, SpringLayout.WEST, InfoPanel);
        info.putConstraint(SpringLayout.NORTH, gold, 120, SpringLayout.WEST, InfoPanel);
        

        //icon do xp
       info.putConstraint(SpringLayout.WEST, xp_icon, 15, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, xp_icon, 160, SpringLayout.WEST, InfoPanel);
       
        //xp
       info.putConstraint(SpringLayout.WEST, xp, 55, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, xp, 160, SpringLayout.WEST, InfoPanel);
       
         //icon do fire spell
       info.putConstraint(SpringLayout.WEST, fire_icon, 50, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, fire_icon, 195, SpringLayout.WEST, InfoPanel);       
      
       info.putConstraint(SpringLayout.WEST, fire, 80, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, fire, 195, SpringLayout.WEST, InfoPanel);
       
         //icon do heal spell
       info.putConstraint(SpringLayout.WEST, heal_icon, 130, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, heal_icon, 195, SpringLayout.WEST, InfoPanel);
         
       info.putConstraint(SpringLayout.WEST, heal, 160, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, heal, 195, SpringLayout.WEST, InfoPanel);
       
       //icon do poison spell
       info.putConstraint(SpringLayout.WEST, poison_icon, 50, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, poison_icon, 230, SpringLayout.WEST, InfoPanel);

       info.putConstraint(SpringLayout.WEST, poison, 80, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, poison, 230, SpringLayout.WEST, InfoPanel);       

//icon do Ice spell
       info.putConstraint(SpringLayout.WEST, ice_icon, 130, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, ice_icon, 230, SpringLayout.WEST, InfoPanel);
       
        info.putConstraint(SpringLayout.WEST, ice, 160, SpringLayout.WEST, InfoPanel);
       info.putConstraint(SpringLayout.NORTH, ice, 230, SpringLayout.WEST, InfoPanel);
       
       InfoPanel.add(fire);
       InfoPanel.add(heal);
       InfoPanel.add(poison);
       InfoPanel.add(ice);

       InfoPanel.add(food_icon);
       InfoPanel.add(food);
       InfoPanel.add(ice_icon);
         InfoPanel.add(poison_icon);      
        InfoPanel.add(heal_icon);
        InfoPanel.add(fire_icon);
        InfoPanel.add(xp_icon);
        InfoPanel.add(xp);
        InfoPanel.add(coin_icon);
        InfoPanel.add(gold);
        InfoPanel.add(armor_icon);
        InfoPanel.add(armor);
        InfoPanel.add(Hp);
        InfoPanel.add(hp_icon);
        
        add(southPanel,BorderLayout.SOUTH);
        add(rightPanel,BorderLayout.EAST);
        repaint();
        revalidate();
       
        
        
    }
    
    
    @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image fundo=Imagem.getImagem(FUNDO);

        if(fundo!=null){
            
             g.drawImage(fundo, 0, 0, LARGURA, ALTURA,this);

        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }

<<<<<<< HEAD
    private void registarListeners() {
        card0.addActionListener(new card0listner());
        card1.addActionListener(new card1listner());
        card2.addActionListener(new card2listner());
        card3.addActionListener(new card3listner());
        card4.addActionListener(new card4listner());
        card5.addActionListener(new card5listner());
        card6.addActionListener(new card6listner());
        

    }
private  class card0listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(modelo.CollunLvl()==1)
                  modelo.resolvecard(0);

        }    
 
}

private  class card1listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
         if(modelo.CollunLvl()==2)
            modelo.resolvecard(1);

        }    
 
}

private  class card2listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        if(modelo.CollunLvl()==2)
            modelo.resolvecard(3);

        }    
 
}

private  class card3listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(modelo.CollunLvl()==3)
            modelo.resolvecard(3);
 
        }    
 
}

private  class card4listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
         if(modelo.CollunLvl()==4)   
            modelo.resolvecard(1);

        }    
 
}

private  class card5listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(modelo.CollunLvl()==4)
            modelo.resolvecard(2);

        }    
 
}

private  class card6listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(modelo.CollunLvl()==5)
            modelo.resolvecard(6);

        }    
 
}
=======
    
 


<<<<<<< HEAD
=======
=======
    }
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
}
