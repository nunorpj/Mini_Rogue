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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.DICE_1;
import static mini_rogue.GUI.Vistas.Constantes.DICE_2;
import static mini_rogue.GUI.Vistas.Constantes.DICE_3;
import static mini_rogue.GUI.Vistas.Constantes.DICE_4;
import static mini_rogue.GUI.Vistas.Constantes.DICE_5;
import static mini_rogue.GUI.Vistas.Constantes.DICE_6;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.HERO;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;
import static mini_rogue.GUI.Vistas.Constantes.MONSTRO;
import static mini_rogue.GUI.Vistas.Constantes.SHIELD;
import static mini_rogue.GUI.Vistas.Constantes.Start;
import static mini_rogue.GUI.Vistas.Constantes.TOKEN;
import static mini_rogue.GUI.Vistas.Constantes.bSize;
import static mini_rogue.GUI.Vistas.Constantes.margem;
import mini_rogue.GUI.modelo.Modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RolledDicesGUI extends JPanel implements Constantes{
       
        private JButton AttackButton;
        private JButton FeatsButton;
    
        private JPanel info_hero;
        private JLabel hero;
        private JPanel info_monster;
        private JLabel monster;

        private cardM monster_card;
        private cardH Hero_card;
        
        
        private JProgressBar Hero_Hp;
        private JProgressBar Monster_Hp;
        private JLabel hp_icon_monster;
        private JLabel attack_monster;
        private JLabel attack_monster_icon;

        private JLabel attack;
        private JLabel attack_icon;
        private JProgressBar armor;
        private JLabel hp_icon;
        private JLabel armor_icon;
        private JLabel fire_icon;
        private JLabel ice_icon;
        private JLabel heal_icon;
        private JLabel poison_icon;
        private JLabel fire;
        private JLabel ice;
        private JLabel poison;
        private JLabel heal;
        private Modelo modelo;
        private DicePanel[] dados;
    public RolledDicesGUI(Modelo m) {
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
        criaMonsterobj();
        
        monster_card=new cardM();
        Hero_card=new cardH();
        
        Dimension dim=new Dimension(110, 40);
        AttackButton=new JButton("Attack!");
        AttackButton.setMaximumSize(dim);
        AttackButton.setMinimumSize(dim);
        AttackButton.setPreferredSize(dim);
        AttackButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        AttackButton.setBackground(new Color(15,145,99));
        AttackButton.setForeground(Color.white);
        AttackButton.setFocusPainted(false);
        AttackButton.setFont(new Font("Serif", Font.BOLD, 25));
        
        FeatsButton=new JButton("Feats!");
        FeatsButton.setMaximumSize(dim);
        FeatsButton.setMinimumSize(dim);
        FeatsButton.setPreferredSize(dim);
        FeatsButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        FeatsButton.setBackground(new Color(15,145,99));
        FeatsButton.setForeground(Color.white);
        FeatsButton.setFocusPainted(false);
        FeatsButton.setFont(new Font("Serif", Font.BOLD, 25));
        if(modelo.isFeatsAlreadyUsed()==true)
            FeatsButton.setEnabled(false);
        
        
        dados=new DicePanel[modelo.getNumberOfDices()];
        for(int i=0;i<modelo.getNumberOfDices();i++){
           dados[i]=new DicePanel(i);
        }
    }
    private void criaPlayerobj() {
        Hero_Hp = new JProgressBar(0, 20);
        Hero_Hp.setValue(modelo.gethp());
        Hero_Hp.setString(modelo.gethp()+"/20");
        Hero_Hp.setStringPainted(true);
        Hero_Hp.setPreferredSize(new Dimension(150, 20));
        Hero_Hp.setMaximumSize(new Dimension(150, 20));
        Hero_Hp.setMinimumSize(new Dimension(150, 20));
        Hero_Hp.setForeground(Color.RED);
        Hero_Hp.setBorder(new LineBorder(margem));
        Hero_Hp.setBackground(new Color(250, 250,250, 250));
      
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
        
        attack_icon= new JLabel(new ImageIcon(Imagem.getImagem(SWORD)));
        hp_icon = new JLabel(new ImageIcon(Imagem.getImagem(VIDA)));
        armor_icon= new JLabel(new ImageIcon(Imagem.getImagem(SHIELD)));      
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
                  
        attack=new JLabel(modelo.getHeroAttack()+" Damage");
        attack.setForeground(Color.WHITE);       
          attack.setFont(new Font("Arial", Font.BOLD, 15)); 
          
        info_hero= new JPanel();
        info_hero.setBackground(new Color(0, 0, 0, 140));
        info_hero.setPreferredSize(new Dimension(440, 180));
        info_hero.setMaximumSize(new Dimension(440, 180));
        info_hero.setMinimumSize(new Dimension(440, 180));
        info_hero.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        
        hero=new JLabel("HERO");
        hero.setFont(new Font("Arial", Font.BOLD, 20));
        hero.setForeground(Color.WHITE);
        
        
    }
   public void criaMonsterobj(){
        info_monster= new JPanel();
        info_monster.setBackground(new Color(0, 0, 0, 140));
        info_monster.setPreferredSize(new Dimension(440, 180));
        info_monster.setMaximumSize(new Dimension(440, 180));
        info_monster.setMinimumSize(new Dimension(440, 180));
        info_monster.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem)); 
       
       
       Monster_Hp = new JProgressBar(0, modelo.getEnemyMaxHp());
        Monster_Hp.setValue(modelo.EnemyHp());
        Monster_Hp.setString(modelo.EnemyHp()+"/"+modelo.getEnemyMaxHp());
        Monster_Hp.setStringPainted(true);
        Monster_Hp.setPreferredSize(new Dimension(150, 20));
        Monster_Hp.setMaximumSize(new Dimension(150, 20));
        Monster_Hp.setMinimumSize(new Dimension(150, 20));
        Monster_Hp.setForeground(Color.RED);
        Monster_Hp.setBorder(new LineBorder(margem));
        Monster_Hp.setBackground(new Color(250, 250,250, 250));
        hp_icon_monster =new JLabel(new ImageIcon(Imagem.getImagem(VIDA)));
        attack_monster_icon =new JLabel(new ImageIcon(Imagem.getImagem(SWORD)));

        monster=new JLabel(modelo.EnemyName());
        monster.setFont(new Font("Arial", Font.BOLD, 20));
        monster.setForeground(Color.WHITE);
         
        attack_monster =new JLabel(modelo.EnemyAttack()+" Damage");
        attack_monster.setForeground(Color.WHITE);
        attack_monster.setFont(new Font("Arial", Font.BOLD, 15)); 

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
        
        FighLayout.putConstraint(SpringLayout.WEST, info_hero, 485, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, info_hero, 100, SpringLayout.WEST, this);
        add(info_hero);
         DispPlayerObj();

        FighLayout.putConstraint(SpringLayout.WEST, info_monster, 485, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, info_monster, 480, SpringLayout.WEST, this);
        add(info_monster);
        DispMonstroObj();
        
        
        FighLayout.putConstraint(SpringLayout.WEST, AttackButton, 485, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, AttackButton, 350, SpringLayout.WEST, this);
        add(AttackButton);
        
        FighLayout.putConstraint(SpringLayout.WEST, FeatsButton, 810, SpringLayout.WEST, this);
        FighLayout.putConstraint(SpringLayout.NORTH, FeatsButton, 350, SpringLayout.WEST, this);
        add(FeatsButton);
        
        
    }

    private void DispPlayerObj() {
        SpringLayout PlayerLayout = new SpringLayout();
        info_hero.setLayout(PlayerLayout);
        
        PlayerLayout.putConstraint(SpringLayout.WEST, hero, 195, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, hero, 10, SpringLayout.WEST, info_hero);
        info_hero.add(hero);
        
         PlayerLayout.putConstraint(SpringLayout.WEST, hp_icon, 20, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, hp_icon, 50, SpringLayout.WEST, info_hero);
        info_hero.add(hp_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, Hero_Hp, 60, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, Hero_Hp, 50, SpringLayout.WEST, info_hero);
        info_hero.add(Hero_Hp); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, armor_icon, 20, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, armor_icon, 100, SpringLayout.WEST, info_hero);
        info_hero.add(armor_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, armor, 60, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, armor, 100, SpringLayout.WEST, info_hero);
        info_hero.add(armor);
        
         PlayerLayout.putConstraint(SpringLayout.WEST, attack_icon, 170, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, attack_icon, 140, SpringLayout.WEST, info_hero);
        info_hero.add(attack_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, attack, 200, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, attack, 140, SpringLayout.WEST, info_hero);
        info_hero.add(attack);
        
        //#############################################################

        
        PlayerLayout.putConstraint(SpringLayout.WEST, fire_icon, 270, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, fire_icon, 50, SpringLayout.WEST, info_hero);
        info_hero.add(fire_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, fire, 300, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, fire, 50, SpringLayout.WEST, info_hero);
        info_hero.add(fire); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, ice_icon, 270, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, ice_icon, 100, SpringLayout.WEST, info_hero);
        info_hero.add(ice_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, ice, 300, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, ice, 100, SpringLayout.WEST, info_hero);
        info_hero.add(ice); 
        //##########################################################################
        
        PlayerLayout.putConstraint(SpringLayout.WEST, poison_icon, 350, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, poison_icon, 50, SpringLayout.WEST, info_hero);
        info_hero.add(poison_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, poison, 380, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, poison, 50, SpringLayout.WEST, info_hero);
        info_hero.add(poison); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, heal_icon, 350, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, heal_icon, 100, SpringLayout.WEST, info_hero);
        info_hero.add(heal_icon); 
        
        PlayerLayout.putConstraint(SpringLayout.WEST, heal, 380, SpringLayout.WEST, info_hero);
        PlayerLayout.putConstraint(SpringLayout.NORTH, heal, 100, SpringLayout.WEST, info_hero);
        info_hero.add(heal); 
        
    }

    private void DispMonstroObj() {
         SpringLayout MosntroLayout = new SpringLayout();
        info_monster.setLayout(MosntroLayout);
        
        MosntroLayout.putConstraint(SpringLayout.WEST, monster, 160, SpringLayout.WEST, info_monster);
        MosntroLayout.putConstraint(SpringLayout.NORTH, monster, 10, SpringLayout.WEST, info_monster);
        info_monster.add(monster);
        
        MosntroLayout.putConstraint(SpringLayout.WEST, hp_icon_monster, 130, SpringLayout.WEST, info_monster);
        MosntroLayout.putConstraint(SpringLayout.NORTH, hp_icon_monster, 70, SpringLayout.WEST, info_monster);
        info_monster.add(hp_icon_monster); 
        
        MosntroLayout.putConstraint(SpringLayout.WEST, Monster_Hp, 160, SpringLayout.WEST, info_monster);
        MosntroLayout.putConstraint(SpringLayout.NORTH, Monster_Hp, 70, SpringLayout.WEST, info_monster);
        info_monster.add(Monster_Hp); 
        
        MosntroLayout.putConstraint(SpringLayout.WEST, attack_monster_icon, 170, SpringLayout.WEST, info_monster);
        MosntroLayout.putConstraint(SpringLayout.NORTH, attack_monster_icon, 120, SpringLayout.WEST, info_monster);
        info_monster.add(attack_monster_icon); 
        
        MosntroLayout.putConstraint(SpringLayout.WEST, attack_monster, 200, SpringLayout.WEST, info_monster);
        MosntroLayout.putConstraint(SpringLayout.NORTH, attack_monster, 120, SpringLayout.WEST, info_monster);
        info_monster.add(attack_monster);
    }

    private void RegistaListners() {
        AttackButton.addActionListener(new AttackListner());
        FeatsButton.addActionListener(new FeatsListner());

          

        }    
 
     private  class AttackListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.attack();
        }
     }
  
     private  class FeatsListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            modelo.feats();
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
       int vida=modelo.EnemyHp();
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
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
        setBackground(new Color(0, 0, 0, 140));
        criaDados();
        
       // dispDados();
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


