/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.COIN;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;
import static mini_rogue.GUI.Vistas.Constantes.RESTING_CARD_BIG;
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
    private JButton[] sell;    

AwaitForTradingGUI(Modelo m) {
            modelo=m; 
            
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
        
    }

    private void RegistaListeners() {
    }
    
    private void dipsSellPanel() {
              
        SpringLayout SELLLayout = new SpringLayout();
        SellJPanel.setLayout(SELLLayout);
        
        SELLLayout.putConstraint(SpringLayout.WEST, SellLabel, 300, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellLabel, 10, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, SellAmorLabel, 30, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, SellAmorLabel, 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(SellAmorLabel);
        
        SELLLayout.putConstraint(SpringLayout.WEST, Coin_Icon[8], 50, SpringLayout.WEST, SellJPanel);
        SELLLayout.putConstraint(SpringLayout.NORTH, Coin_Icon[8], 60, SpringLayout.WEST, SellJPanel);
        SellJPanel.add(Coin_Icon[8]);
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
        if(fundo!=null){
            
             g.drawImage(fundo, 0, 0, LARGURA, ALTURA,this);
            g.drawImage(Merchant_image, 100,25,550,790,this);
        }else{
            System.err.println(" imagem == null");
        }
   }




}
