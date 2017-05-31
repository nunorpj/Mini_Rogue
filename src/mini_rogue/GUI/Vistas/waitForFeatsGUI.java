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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class waitForFeatsGUI extends JPanel implements Constantes{
       
 
        public int contador_aux;
        private JPanel info_feats;
        private JLabel feats;
        
        private JButton backButton;
        private JButton useHpButton;
        private JButton useXpButton;
        
        private cardM monster_card;
        private cardH Hero_card;

        private Modelo modelo;
        private DicePanel[] dados;
  
        public waitForFeatsGUI(Modelo m) {
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
        
        criaFeatsobj();
        
        monster_card=new cardM();
        Hero_card=new cardH();

        
        dados=new DicePanel[modelo.getNumberOfDices()];
        for(int i=0;i<modelo.getNumberOfDices();i++){
           dados[i]=new DicePanel(i);
        }
    }
 
   public void criaFeatsobj(){
        info_feats= new JPanel();
        info_feats.setBackground(new Color(0, 0, 0, 140));
        info_feats.setPreferredSize(new Dimension(440, 180));
        info_feats.setMaximumSize(new Dimension(440, 180));
        info_feats.setMinimumSize(new Dimension(440, 180));
        info_feats.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem)); 

        feats=new JLabel("FEATS");
        feats.setFont(new Font("Arial", Font.BOLD, 20));
        feats.setForeground(Color.WHITE);

        Dimension dim=new Dimension(80, 25);
        backButton=new JButton("Return");
        backButton.setMaximumSize(dim);
        backButton.setMinimumSize(dim);
        backButton.setPreferredSize(dim);
        backButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        backButton.setBackground(new Color(15,145,99));
        backButton.setForeground(Color.white);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        dim=new Dimension(100, 30);
        useHpButton=new JButton("USE 2 HP");
        useHpButton.setMaximumSize(dim);
        useHpButton.setMinimumSize(dim);
        useHpButton.setPreferredSize(dim);
        useHpButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        useHpButton.setBackground(new Color(15,145,99));
        useHpButton.setForeground(Color.white);
        useHpButton.setFocusPainted(false);
        useHpButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        if(modelo.gethp()<3)
            useHpButton.setEnabled(false);
        
        useXpButton=new JButton("USE 1 XP");
        useXpButton.setMaximumSize(dim);
        useXpButton.setMinimumSize(dim);
        useXpButton.setPreferredSize(dim);
        useXpButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        useXpButton.setBackground(new Color(15,145,99));
        useXpButton.setForeground(Color.white);
        useXpButton.setFocusPainted(false);
        useXpButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        if(modelo.getXp()<1)
            useXpButton.setEnabled(false);
        
        useXpButton.setVisible(false);
        useHpButton.setVisible(false);
    }
   
       private void DispFeatsObj() {
         SpringLayout MosntroLayout = new SpringLayout();
        info_feats.setLayout(MosntroLayout);
        
        MosntroLayout.putConstraint(SpringLayout.WEST, feats, 180, SpringLayout.WEST, info_feats);
        MosntroLayout.putConstraint(SpringLayout.NORTH, feats, 10, SpringLayout.WEST, info_feats);
        info_feats.add(feats);

        MosntroLayout.putConstraint(SpringLayout.WEST, backButton, 350, SpringLayout.WEST, info_feats);
        MosntroLayout.putConstraint(SpringLayout.NORTH, backButton, 145, SpringLayout.NORTH, info_feats);
        info_feats.add(backButton);
        
        MosntroLayout.putConstraint(SpringLayout.WEST, useHpButton, 100, SpringLayout.WEST, info_feats);
        MosntroLayout.putConstraint(SpringLayout.NORTH, useHpButton, 80, SpringLayout.NORTH, info_feats);
        info_feats.add(useHpButton);
        
         MosntroLayout.putConstraint(SpringLayout.WEST, useXpButton, 210, SpringLayout.WEST, info_feats);
        MosntroLayout.putConstraint(SpringLayout.NORTH, useXpButton, 80, SpringLayout.NORTH, info_feats);
        info_feats.add(useXpButton);

    }
   
   
    private void DispObjt() {
        SpringLayout FighLayout = new SpringLayout();
        setLayout(FighLayout);
         
        FighLayout.putConstraint(SpringLayout.WEST, dados[0], 1075, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, dados[0], 700, SpringLayout.WEST, this);
        add(dados[0]);
        
        if(modelo.getNumberOfDices()>1){
        FighLayout.putConstraint(SpringLayout.WEST, dados[1], 750, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, dados[1], 700, SpringLayout.WEST, this);
        add(dados[1]);
    }
     if(modelo.getNumberOfDices()>2){
        FighLayout.putConstraint(SpringLayout.WEST, dados[2], 425, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, dados[2], 700, SpringLayout.WEST, this);
        add(dados[2]);
    }
   if(modelo.getNumberOfDices()>3){
        FighLayout.putConstraint(SpringLayout.WEST, dados[3], 100, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, dados[3], 700, SpringLayout.WEST, this);
        add(dados[3]);
    }
        
        
        FighLayout.putConstraint(SpringLayout.WEST, monster_card, 50, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, monster_card, 100, SpringLayout.WEST, this);
        add(monster_card);
        
        FighLayout.putConstraint(SpringLayout.WEST, Hero_card, 960, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, Hero_card, 100, SpringLayout.WEST, this);
        add(Hero_card);
 

        FighLayout.putConstraint(SpringLayout.WEST, info_feats, 485, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, info_feats, 480, SpringLayout.WEST, this);
        add(info_feats);
        DispFeatsObj();
        
        

    }

 private  class backListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.backToRolledDices();
        }
     }
 
 private void dispXpOrHp(int dice){
     useXpButton.setVisible(true);
     useXpButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             modelo.useFeats(2, dice);
         }
     });
     useHpButton.setVisible(true);
     useHpButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             modelo.useFeats(1, dice);
         }
     });
     
     
 }

    private void RegistaListners() {
        backButton.addActionListener(new backListner());
        
        contador_aux=1;
        
        for(int i=0;i<modelo.getNumberOfDices();i++){
            dados[i].addMouseListener(new MouseAdapter() {
                          @Override
                           public void mouseClicked(MouseEvent e) {
                                            dispXpOrHp(contador_aux);
                                            contador_aux++;
                            }
                         });        
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
        
        //token da vida
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

  
     private class DicePanel extends JPanel{
      private Image dice_1;
      private Image dice_2;
      private int dice;
      public DicePanel(int v){
          dice=v;
        setPreferredSize(new Dimension(230, 120));
        setMaximumSize(new Dimension(230, 120));
        setMinimumSize(new Dimension(230, 120));
        setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLUE));
        setBackground(new Color(0, 0, 0, 140));
        criaDados();
        
       repaint();
        }
      
      
   @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

     
            if(dice_1!=null)
            g.drawImage(dice_1, 10, 10, 100, 100,this);
           if(dice_2!=null)
            g.drawImage(dice_2, 120, 10, 100, 100,this);

             //g.drawImage(enemy, 0, 0, 400, 560,this);

         }
 
        private void criaDados() {
            
         int value= modelo.diceVauleNumber(dice);
         
         if(value>6){
             dice_1=Imagem.getImagem(DICE_6);
             value=value-6;
             switch(value){
              case 1:
                  dice_2= Imagem.getImagem(DICE_1);
                  break; 
              case 2:
                 dice_2= Imagem.getImagem(DICE_2);
                  break; 
              case 3:
                  dice_2= Imagem.getImagem(DICE_3);
                  break; 
              case 4:
                  dice_2= Imagem.getImagem(DICE_4);
                  break; 
              case 5:
                  dice_2= Imagem.getImagem(DICE_5);
                  break; 
              case 6:
                  dice_2= Imagem.getImagem(DICE_6);
                  break;
            }
         }else{
              switch(value){
              case 0:
              case 1:
                  dice_1= Imagem.getImagem(DICE_1);
                  break; 
              case 2:
                 dice_1= Imagem.getImagem(DICE_2);
                  break; 
              case 3:
                  dice_1= Imagem.getImagem(DICE_3);
                  break; 
              case 4:
                  dice_1= Imagem.getImagem(DICE_4);
                  break; 
              case 5:
                  dice_1= Imagem.getImagem(DICE_5);
                  break; 
              case 6:
                  dice_1= Imagem.getImagem(DICE_6);
                  break;
         }
             
          

        }
      

  }
  }
  
}