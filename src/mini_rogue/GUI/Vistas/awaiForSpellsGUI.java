/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static mini_rogue.GUI.Vistas.Constantes.*;
import mini_rogue.GUI.modelo.Modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class awaiForSpellsGUI extends JPanel implements Constantes{
    private Modelo modelo;

    
        private JPanel info_Spell;
        private JLabel Spells;

        private cardM monster_card;
        private cardH Hero_card;

        private JButton fireButton;
        private JButton iceButton;
        private JButton poisonButton;
        private JButton healButton;
         private JButton skip;
        private JLabel fire_icon;
        private JLabel ice_icon;
        private JLabel heal_icon;
        private JLabel poison_icon;
        private JLabel fire;
        private JLabel ice;
        private JLabel poison;
        private JLabel heal;
        
    awaiForSpellsGUI(Modelo m) {
        this.modelo=m;
   CriaObjt();
    DispObjt();
    RegistaListners();
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

     
    private void CriaObjt() {
        
        criaPlayerobj();
        
        monster_card=new cardM();
        Hero_card=new cardH();

        Dimension dim=new Dimension(70, 25);
        fireButton=new JButton("FIRE!");
        fireButton.setMaximumSize(dim);
        fireButton.setMinimumSize(dim);
        fireButton.setPreferredSize(dim);
        fireButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        fireButton.setBackground(new Color(15,145,99));
        fireButton.setForeground(Color.white);
        fireButton.setFocusPainted(false);
        fireButton.setFont(new Font("Arial", Font.PLAIN, 15));
        
        fireButton=new JButton("FIRE!");
        fireButton.setMaximumSize(dim);
        fireButton.setMinimumSize(dim);
        fireButton.setPreferredSize(dim);
        fireButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        fireButton.setBackground(new Color(15,145,99));
        fireButton.setForeground(Color.white);
        fireButton.setFocusPainted(false);
        fireButton.setFont(new Font("Arial", Font.PLAIN, 15));
        
        iceButton=new JButton("ICE!");
        iceButton.setMaximumSize(dim);
        iceButton.setMinimumSize(dim);
        iceButton.setPreferredSize(dim);
        iceButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        iceButton.setBackground(new Color(15,145,99));
        iceButton.setForeground(Color.white);
        iceButton.setFocusPainted(false);
        iceButton.setFont(new Font("Arial", Font.PLAIN, 15));
        
        poisonButton=new JButton("POISON!");
        poisonButton.setMaximumSize(dim);
        poisonButton.setMinimumSize(dim);
        poisonButton.setPreferredSize(dim);
        poisonButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        poisonButton.setBackground(new Color(15,145,99));
        poisonButton.setForeground(Color.white);
        poisonButton.setFocusPainted(false);
        poisonButton.setFont(new Font("Arial", Font.PLAIN, 15));
        
        healButton=new JButton("HEAL!");
        healButton.setMaximumSize(dim);
        healButton.setMinimumSize(dim);
        healButton.setPreferredSize(dim);
        healButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        healButton.setBackground(new Color(15,145,99));
        healButton.setForeground(Color.white);
        healButton.setFocusPainted(false);
        healButton.setFont(new Font("Arial", Font.PLAIN, 15));
        
        skip=new JButton("SKIP!");
        skip.setMaximumSize(dim);
        skip.setMinimumSize(dim);
        skip.setPreferredSize(dim);
        skip.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        skip.setBackground(new Color(15,145,99));
        skip.setForeground(Color.white);
        skip.setFocusPainted(false);
        skip.setFont(new Font("Arial", Font.PLAIN, 15));  
        
        if(modelo.getstock(2)==0)
            fireButton.setEnabled(false);
        if(modelo.getstock(3)==0)
            iceButton.setEnabled(false);
        if(modelo.getstock(4)==0)
            poisonButton.setEnabled(false);
        if(modelo.getstock(5)==0)
            healButton.setEnabled(false);
        
        
        
    }
    private void criaPlayerobj() {
        
        fire_icon= new JLabel(new ImageIcon(Imagem.getImagem(FIRE)));
        heal_icon =new JLabel(new ImageIcon(Imagem.getImagem(HEAL)));
        poison_icon= new JLabel(new ImageIcon(Imagem.getImagem(POISON)));
        ice_icon=new JLabel(new ImageIcon(Imagem.getImagem(ICE)));
        
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

          
        info_Spell= new JPanel();
        info_Spell.setBackground(new Color(0, 0, 0, 140));
        info_Spell.setPreferredSize(new Dimension(440, 180));
        info_Spell.setMaximumSize(new Dimension(440, 180));
        info_Spell.setMinimumSize(new Dimension(440, 180));
        info_Spell.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
        Spells=new JLabel("SPELLS");
        Spells.setFont(new Font("Arial", Font.BOLD, 20));
        Spells.setForeground(Color.WHITE);
        
        
    }
   
   
    private void DispObjt() {
        SpringLayout FighLayout = new SpringLayout();
        setLayout(FighLayout);
        
        
        FighLayout.putConstraint(SpringLayout.WEST, monster_card, 50, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, monster_card, 100, SpringLayout.WEST, this);
        add(monster_card);
        
        FighLayout.putConstraint(SpringLayout.WEST, Hero_card, 960, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, Hero_card, 100, SpringLayout.WEST, this);
        add(Hero_card);
        
        FighLayout.putConstraint(SpringLayout.WEST, info_Spell, 485, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, info_Spell, 280, SpringLayout.WEST, this);
        add(info_Spell);
         DispPlayerObj();

    }

    private void DispPlayerObj() {
        SpringLayout PlayerLayout = new SpringLayout();
        info_Spell.setLayout(PlayerLayout);
        
        PlayerLayout.putConstraint(SpringLayout.WEST, Spells, 195, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, Spells, 10, SpringLayout.WEST, info_Spell);
        info_Spell.add(Spells);

        
        //#############################################################

        
        PlayerLayout.putConstraint(SpringLayout.WEST, fire_icon, 70, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, fire_icon, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(fire_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, fire, 100, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, fire, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(fire); 
        //#############################################################
        PlayerLayout.putConstraint(SpringLayout.WEST, ice_icon, 150, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, ice_icon, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(ice_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, ice, 180, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, ice, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(ice); 
        //#############################################################
        PlayerLayout.putConstraint(SpringLayout.WEST, poison_icon, 230, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, poison_icon, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(poison_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, poison, 260, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, poison, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(poison); 
        //#############################################################
        PlayerLayout.putConstraint(SpringLayout.WEST, heal_icon, 310, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, heal_icon, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(heal_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, heal, 340, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, heal, 50, SpringLayout.WEST, info_Spell);
        info_Spell.add(heal); 
        //#############################################################
        PlayerLayout.putConstraint(SpringLayout.WEST, fireButton, 53, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, fireButton, 85, SpringLayout.WEST, info_Spell);
        info_Spell.add(fireButton); 
        
         PlayerLayout.putConstraint(SpringLayout.WEST, iceButton, 133, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, iceButton, 85, SpringLayout.WEST, info_Spell);
        info_Spell.add(iceButton); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, poisonButton, 213, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, poisonButton, 85, SpringLayout.WEST, info_Spell);
        info_Spell.add(poisonButton); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, healButton, 293, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, healButton, 85, SpringLayout.WEST, info_Spell);
        info_Spell.add(healButton); 
        
           PlayerLayout.putConstraint(SpringLayout.WEST, skip, 360, SpringLayout.WEST, info_Spell);
        PlayerLayout.putConstraint(SpringLayout.NORTH, skip, 145, SpringLayout.WEST, info_Spell);
        info_Spell.add(skip); 
        
    }



    private void RegistaListners() {
        fireButton.addActionListener(new fireListner());
        iceButton.addActionListener(new iceListner());
        poisonButton.addActionListener(new poisonListner());
        healButton.addActionListener(new healListner());
        skip.addActionListener(new skipListner());
        }    
 
     private  class fireListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.Spells(1);
        }
     }
  private  class iceListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
               modelo.Spells(2);

        }
     }
    private  class poisonListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  modelo.Spells(3);

        }
     }
      private  class healListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  modelo.Spells(4);

        }
     }
      private  class skipListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  modelo.letsFight();

        }
     }
  private class cardM extends JPanel{
      private JLabel[] token;
      
      
      public cardM(){
          
        setPreferredSize(new Dimension(400, 560));
        setMaximumSize(new Dimension(400, 560));
        setMinimumSize(new Dimension(400, 560));
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
        criaTokens();
        dispTokens();
        }
      
  
         @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image enemy= Imagem.getImagem(MONSTRO);
        
        if(enemy!=null){
            
             g.drawImage(enemy, 0, 0, 400, 560,this);


        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }

        private void criaTokens() {
            
            token=new JLabel[2];
            token[0]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));
            token[1]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       

        }
      
        private void dispTokens(){
        
        SpringLayout infoM = new SpringLayout();
        setLayout(infoM);
        
        int top=0;
        int esq=0;
        //token do nivel
      int area=modelo.getArea();
        if(area<3){
            top=215;
            esq=-14+(44*area);
            
        }else if(area>2&&area<5){
            area=area-2;
            esq=-14+(44*area);
            top=282;
        }else if(area>4&&area<8){
             area=area-4;
            esq=-14+(44*area);
            top=351;
        }else if(area>7&&area<11){
            area=area-7;
            esq=-14+(44*area);
            top=420;
        }else if(area>10&&area<15){
             area=area-10;
            esq=-14+(44*area);
            top=488;
        }
        
       infoM.putConstraint(SpringLayout.WEST, token[0], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[0], top, SpringLayout.WEST, this);
        this.add(token[0]);
        
        
        int vida=modelo.EnemyLife();
        if(vida<11){
            esq=335;
              top=508-(vida*46);
        }else if(vida>10&&vida<21){
             top=508-((vida-10)*46);
            esq=288;
        }else if(vida>20&&vida<32){
           top=508-((vida-20)*46);
            esq=242;
        }
       infoM.putConstraint(SpringLayout.WEST, token[1], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[1], top, SpringLayout.WEST, this);
        this.add(token[1]);
        
        

        
        }
  }
  
  private class cardH extends JPanel{
      private JLabel[] token;
      
      
      public cardH(){
          
        setPreferredSize(new Dimension(400, 560));
        setMaximumSize(new Dimension(400, 560));
        setMinimumSize(new Dimension(400, 560));
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
        criaTokens();
        dispTokens();
        }
      
      
         @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image enemy= Imagem.getImagem(HERO);
        
        if(enemy!=null){
            
             g.drawImage(enemy, 0, 0, 400, 560,this);


        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }

        private void criaTokens() {
            
            token=new JLabel[8];
            token[0]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));
            token[1]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[2]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[3]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[4]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[5]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[6]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       
            token[7]= new JLabel(new ImageIcon(Imagem.getImagem(TOKEN)));       

        }
      
   
        private void dispTokens(){
        
        SpringLayout infoM = new SpringLayout();
        setLayout(infoM);
        
        int top=0;
        int esq=0;
        //token da food

      esq=347;
      top=333-(modelo.getFood()*44)+(modelo.getFood()/2);
       infoM.putConstraint(SpringLayout.WEST, token[0], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[0], top, SpringLayout.WEST, this);
        this.add(token[0]);

        //token da gold
       int gold=modelo.getGold();
        if(gold<11){
            esq=295;
              top=508-(gold*44)+(gold/2);
        }else if(gold>10&&gold<21){
            gold=gold-10;   
            esq=252;
              top=508-(gold*44)+(gold/2);
        }
       infoM.putConstraint(SpringLayout.WEST, token[1], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[1], top, SpringLayout.WEST, this);
        this.add(token[1]);
        
                //token da vida
       int vida=modelo.gethp();
        if(vida<11){
            esq=199;
              top=508-(vida*44)+(vida/2);
        }else if(vida>10&&vida<21){
            vida=vida-10;   
            esq=155;
            top=508-(vida*44)+(vida/2);
        }
       infoM.putConstraint(SpringLayout.WEST, token[2], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[2], top, SpringLayout.WEST, this);
        this.add(token[2]);
        
        
        //token da armor

        top=290-(modelo.getArmor()*44);
        esq=103;
       infoM.putConstraint(SpringLayout.WEST, token[3], esq, SpringLayout.WEST, this);
       infoM. putConstraint(SpringLayout.NORTH, token[3], top, SpringLayout.WEST, this);
        this.add(token[3]);
        
        //tokens spells
        if(modelo.getstock(2)>0){
        infoM.putConstraint(SpringLayout.WEST, token[4], 103, SpringLayout.WEST, this);
        infoM. putConstraint(SpringLayout.NORTH, token[4], 377, SpringLayout.WEST, this);
        this.add(token[4]);
             }
        if(modelo.getstock(3)>0){
        infoM.putConstraint(SpringLayout.WEST, token[5], 103, SpringLayout.WEST, this);
        infoM. putConstraint(SpringLayout.NORTH, token[5], 420, SpringLayout.WEST, this);
        this.add(token[5]);
             }
        if(modelo.getstock(4)>0){
        infoM.putConstraint(SpringLayout.WEST, token[6], 103, SpringLayout.WEST, this);
        infoM. putConstraint(SpringLayout.NORTH, token[6], 464, SpringLayout.WEST, this);
        this.add(token[6]);
             }
         if(modelo.getstock(5)>0){
        infoM.putConstraint(SpringLayout.WEST, token[7], 103, SpringLayout.WEST, this);
        infoM. putConstraint(SpringLayout.NORTH, token[7], 506, SpringLayout.WEST, this);
        this.add(token[7]);
             }
        
        
        }
  }

}