/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

<<<<<<< HEAD
import java.awt.BorderLayout;
=======
>>>>>>> origin/master
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> origin/master
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.COIN;
import static mini_rogue.GUI.Vistas.Constantes.FIRE;
import static mini_rogue.GUI.Vistas.Constantes.FOOD;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.HEAL;
import static mini_rogue.GUI.Vistas.Constantes.ICE;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;
import static mini_rogue.GUI.Vistas.Constantes.POISON;
import static mini_rogue.GUI.Vistas.Constantes.RESTING_CARD_BIG;
import static mini_rogue.GUI.Vistas.Constantes.SHIELD;
import static mini_rogue.GUI.Vistas.Constantes.VIDA;
import static mini_rogue.GUI.Vistas.Constantes.XP;
=======
import javax.swing.SpringLayout;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.COIN;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;
import static mini_rogue.GUI.Vistas.Constantes.RESTING_CARD_BIG;
>>>>>>> origin/master
import static mini_rogue.GUI.Vistas.Constantes.bSize;
import static mini_rogue.GUI.Vistas.Constantes.margem;
import mini_rogue.GUI.modelo.Modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitForTradingGUI extends JPanel implements Constantes{
    private Modelo modelo;
    private JPanel BuyJPanel;
    private JPanel SellJPanel;
    private JLabel BuyLabel;
    private JLabel BuyRationLabel;
    private JLabel BuyPotionLabel;
    private JLabel BuyBigPotionLabel;
    private JLabel BuyArmorLabel;
    private JLabel BuyFireLabel;
    private JLabel BuyIceLabel;
    private JLabel BuyPoisonLabel;
    private JLabel BuyHealLabel;
    private JLabel[] Coin_Icon;    
    private JButton[] buy;    

    private JLabel SellLabel;
    private JLabel SellAmorLabel;
    private JLabel SellFireLabel;
    private JLabel SellIceLabel;
    private JLabel SellPoisonLabel;
<<<<<<< HEAD
    private JLabel SellHealLabel;
    private JButton[] sell;    
    private JButton skip;
    private JPanel InfoPanel;
    
   private JLabel hp_icon;
   private JLabel armor_icon;
   private JLabel food_icon;
   private JLabel fire_icon;
   private JLabel ice_icon;
   private JLabel heal_icon;
   private JLabel poison_icon;
   private JLabel coin_icon;   
   private JLabel fire;
   private JLabel ice;
   private JLabel poison;
   private JLabel heal;
    
   private JProgressBar Hp;
   private JProgressBar food;
   private JProgressBar gold;
   private JProgressBar armor;
AwaitForTradingGUI(Modelo m) {
        modelo=m; 
=======
    private JButton[] sell;    

AwaitForTradingGUI(Modelo m) {
            modelo=m; 
>>>>>>> origin/master
            
        criaObj();
        DispObj();
        RegistaListeners();
            
    }

    private void criaObj() {
        
            Coin_Icon= new JLabel[13];
            for( int i=0;i<13;i++){
            Coin_Icon[i]=new JLabel(new ImageIcon(Imagem.getImagem(COIN)));
            }

            buy= new JButton[8];
            for( int i=0;i<8;i++){
                   buy[i]=new JButton("BUY");
                   buy[i].setMaximumSize(new Dimension(50, 20));
                   buy[i].setMinimumSize(new Dimension(50, 20));
                   buy[i].setPreferredSize(new Dimension(50, 20));
                   buy[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
                   buy[i].setBackground(new Color(15,145,99));
                   buy[i].setForeground(Color.white);
                   buy[i].setFocusPainted(false);
                   buy[i].setFont(new Font("Arial", Font.BOLD, 15));           
            }



        BuyJPanel=new JPanel();
            BuyJPanel.setBackground(new Color(0, 0, 0, 140));
            BuyJPanel.setPreferredSize(new Dimension(700, 300));
            BuyJPanel.setMaximumSize(new Dimension(700, 300));
            BuyJPanel.setMinimumSize(new Dimension(700, 300));
            BuyJPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
            BuyLabel=new JLabel("BUY!");
            BuyLabel.setForeground(Color.WHITE);
            BuyLabel.setFont(new Font("Arial", Font.BOLD, 30));
            
            
            BuyRationLabel=new JLabel("-1      -Ration: +1Food");
            BuyRationLabel.setForeground(Color.WHITE);
            BuyRationLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyPotionLabel=new JLabel("-1      -Health Potion: +1Hp");
            BuyPotionLabel.setForeground(Color.WHITE);
            BuyPotionLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyBigPotionLabel=new JLabel("-3      -Big Health Potion: +4Hp");
            BuyBigPotionLabel.setForeground(Color.WHITE);
            BuyBigPotionLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyArmorLabel=new JLabel("-6      -Armor Piece: +1 Armor");
            BuyArmorLabel.setForeground(Color.WHITE);
            BuyArmorLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyFireLabel=new JLabel("-8      -Fire Spell: +1 Fire Spell");
            BuyFireLabel.setForeground(Color.WHITE);
            BuyFireLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyIceLabel=new JLabel("-8      -Ice Spell: +1 Ice Spell");
            BuyIceLabel.setForeground(Color.WHITE);
            BuyIceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            BuyPoisonLabel=new JLabel("-8      -Poison Spell: +1 Poison Spell");
            BuyPoisonLabel.setForeground(Color.WHITE);
            BuyPoisonLabel.setFont(new Font("Arial", Font.BOLD, 15));
           
            BuyHealLabel=new JLabel("-8      -Heal Spell: +1 Heal Spell");
            BuyHealLabel.setForeground(Color.WHITE);
            BuyHealLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            
            //########################################################################################
            SellJPanel=new JPanel();
            SellJPanel.setBackground(new Color(0, 0, 0, 140));
            SellJPanel.setPreferredSize(new Dimension(700, 240));
            SellJPanel.setMaximumSize(new Dimension(700, 240));
            SellJPanel.setMinimumSize(new Dimension(700, 240));
            SellJPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            
            SellLabel=new JLabel("SELL!!");
            SellLabel.setForeground(Color.WHITE);
            SellLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
                        sell= new JButton[5];
            for( int i=0;i<5;i++){
                   sell[i]=new JButton("SELL");
                   sell[i].setMaximumSize(new Dimension(50, 20));
                   sell[i].setMinimumSize(new Dimension(50, 20));
                   sell[i].setPreferredSize(new Dimension(50, 20));
                   sell[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
                   sell[i].setBackground(new Color(15,145,99));
                   sell[i].setForeground(Color.white);
                   sell[i].setFocusPainted(false);
                   sell[i].setFont(new Font("Arial", Font.BOLD, 15));           
            }
            
            SellAmorLabel=new JLabel("+3      -Armor Piece: -1 Armor");
            SellAmorLabel.setForeground(Color.WHITE);
            SellAmorLabel.setFont(new Font("Arial", Font.BOLD, 15));
<<<<<<< HEAD
            
            SellFireLabel=new JLabel("+4      -Fire Spell: -1 Fire Spell");
            SellFireLabel.setForeground(Color.WHITE);
            SellFireLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            SellIceLabel=new JLabel("+4      -Ice Spell: -1 Ice Spell");
            SellIceLabel.setForeground(Color.WHITE);
            SellIceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            SellPoisonLabel=new JLabel("+4      -Poison Spell: -1 Poison Spell");
            SellPoisonLabel.setForeground(Color.WHITE);
            SellPoisonLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
            
            SellHealLabel=new JLabel("+4      -Heal Spell: -1 Heal Spell");
            SellHealLabel.setForeground(Color.WHITE);
            SellHealLabel.setFont(new Font("Arial", Font.BOLD, 15));
            
                  skip=new JButton("Done");
                  skip.setMaximumSize(new Dimension(70, 30));
                  skip.setMinimumSize(new Dimension(70, 30));
                  skip.setPreferredSize(new Dimension(70, 30));
                  skip.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                  skip.setBackground(new Color(15,145,99));
                  skip.setForeground(Color.white);
                  skip.setFocusPainted(false);
                  skip.setFont(new Font("Arial", Font.BOLD, 25));   
                  
     //#######################################################################
            InfoPanel=new JPanel();
            InfoPanel.setBackground(new Color(0, 0, 0, 140));
            InfoPanel.setPreferredSize(new Dimension(700, 100));
            InfoPanel.setMaximumSize(new Dimension(700, 100));
            InfoPanel.setMinimumSize(new Dimension(700, 100));
            InfoPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            
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
        food_icon= new JLabel(new ImageIcon(Imagem.getImagem(FOOD)));
        fire_icon= new JLabel(new ImageIcon(Imagem.getImagem(FIRE)));
        heal_icon =new JLabel(new ImageIcon(Imagem.getImagem(HEAL)));
        poison_icon= new JLabel(new ImageIcon(Imagem.getImagem(POISON)));
        ice_icon=new JLabel(new ImageIcon(Imagem.getImagem(ICE)));
        coin_icon=new JLabel(new ImageIcon(Imagem.getImagem(COIN)));

        
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
           
    }
    
   public void SetableButtons(){
            for(int i=0;i<8;i++){
                buy[i].setEnabled(true);
            } 
        if(modelo.getGold()<1){
            for(int i=0;i<8;i++){
                buy[i].setEnabled(false);
            }
        } else if(modelo.getGold()<3){
            for(int i=2;i<8;i++){
                buy[i].setEnabled(false);
            }
        }else if(modelo.getGold()<6){
            for(int i=3;i<8;i++){
                buy[i].setEnabled(false);
            }
        }else if(modelo.getGold()<8){
            for(int i=4;i<8;i++){
                buy[i].setEnabled(false);
            }
        }
        for(int i=0;i<5;i++){
                sell[i].setEnabled(true);
            } 
        if(modelo.getstock(1)<1)
            sell[0].setEnabled(false);        
        if(modelo.getstock(2)<1)
            sell[1].setEnabled(false);
        if(modelo.getstock(3)<1)
            sell[2].setEnabled(false);
        if(modelo.getstock(4)<1)
            sell[3].setEnabled(false);
        if(modelo.getstock(5)<1)
            sell[4].setEnabled(false);
    }
    private void dispInfoPanel(){
        SpringLayout INFOLayout = new SpringLayout();
        InfoPanel.setLayout(INFOLayout);
        
        INFOLayout.putConstraint(SpringLayout.WEST, hp_icon, 20, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, hp_icon, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(hp_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, Hp, 60, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, Hp, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(Hp); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, armor_icon, 20, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, armor_icon, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(armor_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, armor, 60, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, armor, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(armor);
        //#############################################################
        INFOLayout.putConstraint(SpringLayout.WEST, coin_icon, 250, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, coin_icon, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(coin_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, gold, 280, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, gold, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(gold); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, food_icon, 250, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, food_icon, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(food_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, food, 280, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, food, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(food); 
        //##############################################################
        
        INFOLayout.putConstraint(SpringLayout.WEST, fire_icon, 500, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, fire_icon, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(fire_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, fire, 530, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, fire, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(fire); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, ice_icon, 500, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, ice_icon, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(ice_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, ice, 530, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, ice, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(ice); 
        //##########################################################################
        
        INFOLayout.putConstraint(SpringLayout.WEST, poison_icon, 590, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, poison_icon, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(poison_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, poison, 620, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, poison, 20, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(poison); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, heal_icon, 590, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, heal_icon, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(heal_icon); 
        
        INFOLayout.putConstraint(SpringLayout.WEST, heal, 620, SpringLayout.WEST, InfoPanel);
        INFOLayout.putConstraint(SpringLayout.NORTH, heal, 60, SpringLayout.WEST, InfoPanel);
        InfoPanel.add(heal); 
=======
>>>>>>> origin/master
    }

    private void DispObj() {
        SpringLayout TRADINGLayout = new SpringLayout();
        this.setLayout(TRADINGLayout);
        TRADINGLayout.putConstraint(SpringLayout.WEST, BuyJPanel, 680, SpringLayout.WEST, this);
        TRADINGLayout.putConstraint(SpringLayout.NORTH, BuyJPanel, 180, SpringLayout.WEST, this);
        this.add(BuyJPanel);
        dispBuyPanel();
        //###################################################################################
       TRADINGLayout.putConstraint(SpringLayout.WEST, SellJPanel, 680, SpringLayout.WEST, this);
       TRADINGLayout.putConstraint(SpringLayout.NORTH, SellJPanel, 500, SpringLayout.WEST, this);
        this.add(SellJPanel);
        dipsSellPanel();
        
<<<<<<< HEAD
        dispInfoPanel();
        
        
       TRADINGLayout.putConstraint(SpringLayout.WEST, skip, 1300, SpringLayout.WEST, this);
       TRADINGLayout.putConstraint(SpringLayout.NORTH, skip, 780, SpringLayout.WEST, this);
        this.add(skip);
        
        TRADINGLayout.putConstraint(SpringLayout.WEST, InfoPanel, 680, SpringLayout.WEST, this);
       TRADINGLayout.putConstraint(SpringLayout.NORTH, InfoPanel, 50, SpringLayout.WEST, this);
        this.add(InfoPanel);

        SetableButtons();
    }

    private void RegistaListeners() {
        buy[0].addActionListener(new Buy0Listner());
        buy[1].addActionListener(new Buy1Listner());
        buy[2].addActionListener(new Buy2Listner());
        buy[3].addActionListener(new Buy3Listner());
        buy[4].addActionListener(new Buy4Listner());
        buy[5].addActionListener(new Buy5Listner());
        buy[6].addActionListener(new Buy6Listner());
        buy[7].addActionListener(new Buy7Listner());
        
        sell[0].addActionListener(new Sell0Listner());
        sell[1].addActionListener(new Sell1Listner());
        sell[2].addActionListener(new Sell2Listner());
        sell[3].addActionListener(new Sell3Listner());
        sell[4].addActionListener(new Sell4Listner());
        skip.addActionListener(new SkipListner());
=======
    }

    private void RegistaListeners() {
>>>>>>> origin/master
    }
    
    private void dipsSellPanel() {
              
        SpringLayout SELLLayout = new SpringLayout();
        SellJPanel.setLayout(SELLLayout);
        
        SELLLayout.putConstraint(SpringLayout.WEST, SellLabel, 300, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellLabel, 10, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellLabel);
        
<<<<<<< HEAD
        //armor piece
=======
>>>>>>> origin/master
        SELLLayout.putConstraint(SpringLayout.WEST, SellAmorLabel, 30, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellAmorLabel, 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellAmorLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[8], 50, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[8], 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[8]);
<<<<<<< HEAD
        //fire spell
        SELLLayout.putConstraint(SpringLayout.WEST, SellFireLabel, 30, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellFireLabel, 120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellFireLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[9], 50, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[9], 120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[9]);
        
        //ice spell
         SELLLayout.putConstraint(SpringLayout.WEST, SellIceLabel, 30, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellIceLabel, 180, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellIceLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[10], 50, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[10], 180, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[10]);
        
                //Poison spell
        SELLLayout.putConstraint(SpringLayout.WEST, SellPoisonLabel, 360, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellPoisonLabel, 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellPoisonLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[11], 380, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[11], 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[11]);
        
        //heal potion
        SELLLayout.putConstraint(SpringLayout.WEST, SellHealLabel, 360, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellHealLabel, 120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellHealLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[12], 380, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[12], 120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[12]);
        
        SELLLayout.putConstraint(SpringLayout.WEST, sell[0], 250, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, sell[0], 60, SpringLayout.WEST, SellJPanel);        
         SellJPanel.add(sell[0]);
        SELLLayout.putConstraint(SpringLayout.WEST, sell[1], 250, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, sell[1],120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(sell[1]);
        SELLLayout.putConstraint(SpringLayout.WEST, sell[2], 250, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, sell[2], 180, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(sell[2]);
        SELLLayout.putConstraint(SpringLayout.WEST, sell[3], 620, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, sell[3], 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(sell[3]);
        SELLLayout.putConstraint(SpringLayout.WEST, sell[4], 620, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, sell[4], 120, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(sell[4]);
=======
>>>>>>> origin/master
    }
    
    private void dispBuyPanel() {
         

         
        SpringLayout BUYLayout = new SpringLayout();
        BuyJPanel.setLayout(BUYLayout);
        //################################################################################
        BUYLayout.putConstraint(SpringLayout.WEST, BuyLabel, 300, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyLabel, 10, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyLabel);
        //food
        BUYLayout.putConstraint(SpringLayout.WEST, BuyRationLabel, 30, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyRationLabel, 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyRationLabel);

        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[0], 45, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[0], 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[0]);
         
        //potion
        BUYLayout.putConstraint(SpringLayout.WEST, BuyPotionLabel, 30, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyPotionLabel, 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyPotionLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[1], 45, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[1], 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[1]);
        
        //big potion
        BUYLayout.putConstraint(SpringLayout.WEST, BuyBigPotionLabel, 30, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyBigPotionLabel, 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyBigPotionLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[2], 45, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[2], 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[2]);
       
        //armor
         BUYLayout.putConstraint(SpringLayout.WEST, BuyArmorLabel, 30, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyArmorLabel, 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyArmorLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[3], 45,SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[3], 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[3]);
        //#####################
        //fire
         BUYLayout.putConstraint(SpringLayout.WEST, BuyFireLabel, 380, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyFireLabel, 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyFireLabel);

        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[4], 395, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[4], 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[4]);
         
        //ice
        BUYLayout.putConstraint(SpringLayout.WEST, BuyIceLabel, 380, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyIceLabel, 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyIceLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[5], 395, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[5], 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[5]);
        
        //poison
        BUYLayout.putConstraint(SpringLayout.WEST, BuyPoisonLabel, 380, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyPoisonLabel, 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyPoisonLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[6], 395, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[6], 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[6]);
       
        //armor
         BUYLayout.putConstraint(SpringLayout.WEST, BuyHealLabel, 380, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, BuyHealLabel, 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(BuyHealLabel);
        
        BUYLayout.putConstraint(SpringLayout.WEST, Coin_Icon[7], 395, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[7], 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(Coin_Icon[7]);
        

        BUYLayout.putConstraint(SpringLayout.WEST, buy[0], 250, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[0], 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[0]);
         BUYLayout.putConstraint(SpringLayout.WEST, buy[1], 250, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[1], 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[1]);
        BUYLayout.putConstraint(SpringLayout.WEST, buy[2], 250, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[2], 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[2]);
        BUYLayout.putConstraint(SpringLayout.WEST, buy[3], 250, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[3], 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[3]);
        
        BUYLayout.putConstraint(SpringLayout.WEST, buy[4], 635, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[4], 60, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[4]);
         BUYLayout.putConstraint(SpringLayout.WEST, buy[5], 635, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[5], 120, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[5]);
        BUYLayout.putConstraint(SpringLayout.WEST, buy[6], 635, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[6], 180, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[6]);
        BUYLayout.putConstraint(SpringLayout.WEST, buy[7], 635, SpringLayout.WEST, BuyJPanel);
        BUYLayout.putConstraint(SpringLayout.NORTH, buy[7], 240, SpringLayout.WEST, BuyJPanel);
        BuyJPanel.add(buy[7]);
    }
 @Override
public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fundo=Imagem.getImagem(FUNDO);
        Image Merchant_image=Imagem.getImagem(MERCHANT_CARD_BIG);
<<<<<<< HEAD
        if(fundo!=null||Merchant_image!=null){
=======
        if(fundo!=null){
>>>>>>> origin/master
            
             g.drawImage(fundo, 0, 0, LARGURA, ALTURA,this);
            g.drawImage(Merchant_image, 100,25,550,790,this);
        }else{
            System.err.println(" imagem == null");
        }
   }

<<<<<<< HEAD
private  class Buy0Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(1);

        }
}
private  class Buy1Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(2);

        }
}
private  class Buy2Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(3);

        }
}
private  class Buy3Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(4);

        }
}
private  class Buy4Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(5);

}
}       
private  class Buy5Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(6);

        }
}
private  class Buy6Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(7);
        }
}
private  class Buy7Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.buy(8);

        }
}
private  class Sell0Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.sell(1);

        }
}
private  class Sell1Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.sell(2);

        }
}
private  class Sell2Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.sell(3);

        }
}
private  class Sell3Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.sell(4);

        }
}
private  class Sell4Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.sell(5);

        }
}
private  class SkipListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.BackToCardSelecton();

        }
}
=======



>>>>>>> origin/master
}
