/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import mini_rogue.GUI.modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.LineBorder;
import static mini_rogue.GUI.Vistas.Constantes.margem;


/**
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitCardSelectioGUI extends JPanel implements Constantes {
    private Modelo modelo;
    private JButton quit;

    private SpringLayout tableLayout;

    private status stats;
    private Dungeon dungeon;
   
    private JButton card0;
    private JButton card1;
    private JButton card2;
    private JButton card3;
    private JButton card4;
    private JButton card5;
    private JButton card6;

    //private JTextArea logGAme;
    private LogPanel  Gamelogs;

    AwaitCardSelectioGUI(Modelo m) {
        this.modelo = m;
        setBackground(Color.BLACK);


        criaObjGraf();
        disporVista();
        registarListeners();

    }

    private void CriaCards() {
        card0 = new JButton();
        String teste1 = modelo.getCardName(0);
        card0.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(0))));
        card0.setMargin(new Insets(0, 0, 0, 0));
        card0.setBorder(null);
        
        card1 = new JButton();
        card1.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(1))));
        card1.setMargin(new Insets(0, 0, 0, 0));
        card1.setBorder(null);

        card2 = new JButton();
        card2.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(2))));
        card2.setMargin(new Insets(0, 0, 0, 0));
        card2.setBorder(null);

        card3 = new JButton();
        card3.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(3))));
        card3.setMargin(new Insets(0, 0, 0, 0));
        card3.setBorder(null);

        card4 = new JButton();
        card4.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(4))));
        card4.setMargin(new Insets(0, 0, 0, 0));
        card4.setBorder(null);

        card5 = new JButton();
        card5.setIcon(new ImageIcon(Imagem.getImagem(modelo.getCardName(5))));
        card5.setMargin(new Insets(0, 0, 0, 0));
        card5.setBorder(null);

        card6 = new JButton();
        card6.setIcon(new ImageIcon(Imagem.getImagem(BOSS)));
        card6.setMargin(new Insets(0, 0, 0, 0));
        card6.setBorder(null);
        
        switch(modelo.CollunLvl()){
            case 1:
                card0.setBorder(new LineBorder(Color.blue, 3));
                break;
            case 2:
                card1.setBorder(new LineBorder(Color.blue, 3));
                card2.setBorder(new LineBorder(Color.blue, 3));
                break;
            case 3:
                card3.setBorder(new LineBorder(Color.blue, 3));
                break;
            case 4:
                card4.setBorder(new LineBorder(Color.blue, 3));
                card5.setBorder(new LineBorder(Color.blue, 3));
                break;
            case 5:
                 card6.setBorder(new LineBorder(Color.blue, 3));
                break;
            
        }

    }


    private void criaObjGraf() {
        CriaCards();
        stats = new status();
        dungeon = new Dungeon();
        String[] test= { "sdf","hasdgfh"};
        Gamelogs=new LogPanel(test);

    }


    private void disporCard() {


        tableLayout.putConstraint(SpringLayout.WEST, card0, 15, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card0, 160, SpringLayout.WEST, this);
        this.add(card0);

        tableLayout.putConstraint(SpringLayout.WEST, card1, 240, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card1, 10, SpringLayout.WEST, this);
        this.add(card1);

        tableLayout.putConstraint(SpringLayout.WEST, card2, 240, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card2, 300, SpringLayout.WEST, this);
        this.add(card2);

        tableLayout.putConstraint(SpringLayout.WEST, card3, 460, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card3, 160, SpringLayout.WEST, this);
        this.add(card3);

        tableLayout.putConstraint(SpringLayout.WEST, card4, 680, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card4, 10, SpringLayout.WEST, this);
        this.add(card4);

        tableLayout.putConstraint(SpringLayout.WEST, card5, 680, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, card5, 300, SpringLayout.WEST, this);
        this.add(card5);

        int area = modelo.getArea();

        if (area == 2 || area == 4 || area == 7 || area == 10 || area == 14) {
            tableLayout.putConstraint(SpringLayout.WEST, card6, 900, SpringLayout.WEST, this);
            tableLayout.putConstraint(SpringLayout.NORTH, card6, 160, SpringLayout.WEST, this);
            this.add(card6);
        }
    }


    private void disporVista() {
        tableLayout = new SpringLayout();
        this.setLayout(tableLayout);

        disporCard();
        tableLayout.putConstraint(SpringLayout.WEST, stats, 20, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, stats, 590, SpringLayout.WEST, this);
        this.add(stats);

        tableLayout.putConstraint(SpringLayout.WEST, Gamelogs, 800, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, Gamelogs, 590, SpringLayout.WEST, this);
        this.add(Gamelogs);

        tableLayout.putConstraint(SpringLayout.WEST, dungeon, 1120, SpringLayout.WEST, this);
        tableLayout.putConstraint(SpringLayout.NORTH, dungeon, 160, SpringLayout.WEST, this);
        this.add(dungeon);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image fundo = Imagem.getImagem(FUNDO);

        if (fundo != null) {

            g.drawImage(fundo, 0, 0, LARGURA, ALTURA, this);

        } else {
            System.err.println(" imagem == null");
        }


    }

    private void registarListeners() {
        card0.addActionListener(new card0listner());
        card1.addActionListener(new card1listner());
        card2.addActionListener(new card2listner());
        card3.addActionListener(new card3listner());
        card4.addActionListener(new card4listner());
        card5.addActionListener(new card5listner());
        card6.addActionListener(new card6listner());


    }

    private class card0listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 1)
                modelo.resolvecard(0);

        }

    }

    private class card1listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 2)
                modelo.resolvecard(1);

        }

    }

    private class card2listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 2)
                modelo.resolvecard(3);

        }

    }

    private class card3listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 3)
                modelo.resolvecard(3);

        }

    }

    private class card4listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 4)
                modelo.resolvecard(1);

        }

    }

    private class card5listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 4)
                modelo.resolvecard(2);

        }

    }

    private class card6listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (modelo.CollunLvl() == 5)
                modelo.resolvecard(6);

        }

    }

    private class Dungeon extends JPanel {
        private JLabel token;


        public Dungeon() {

            setPreferredSize(new Dimension(280, 390));
            setMaximumSize(new Dimension(280, 390));
            setMinimumSize(new Dimension(280, 390));
            setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));

            criaTokens();
            dispTokens();
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image enemy = Imagem.getImagem(DUNGEON);

            if (enemy != null) {

                g.drawImage(enemy, 0, 0, 280, 390, this);


            } else {
                System.err.println(" imagem == null");
            }


        }

        private void criaTokens() {

            token = new JLabel(new ImageIcon(Imagem.getImagem(TOKEN_SMALL)));

        }

        private void dispTokens() {

            SpringLayout infoM = new SpringLayout();
            setLayout(infoM);

            int top = 0;
            int esq = 0;
            //token do nivel
            int area = modelo.getArea();

            if (area < 3) {
                top = 147;
                esq = -12 + (31 * area);

            } else if (area > 2 && area < 5) {
                area = area - 2;
                esq = -12 + (31 * area);
                top = 195;
            } else if (area > 4 && area < 8) {
                area = area - 4;
                esq = -12 + (31 * area);
                top = 243;
            } else if (area > 7 && area < 11) {
                area = area - 7;
                esq = -12 + (31 * area);
                top = 291;
            } else if (area > 10 && area < 15) {
                area = area - 10;
                esq = -12 + (31 * area);
                top = 339;
            }

            infoM.putConstraint(SpringLayout.WEST, token, esq, SpringLayout.WEST, this);
            infoM.putConstraint(SpringLayout.NORTH, token, top, SpringLayout.WEST, this);
            this.add(token);


        }
    }


    private class status extends JPanel {

        private JLabel[] token;

        public status() {
            setPreferredSize(new Dimension(770, 250));
            setMaximumSize(new Dimension(770, 250));
            setMinimumSize(new Dimension(770, 250));
            setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));

            criaTokens();
            dispTokens();
        }

        private void criaTokens() {
            token = new JLabel[13];
            for (int i = 0; i < 13; i++)
                token[i] = new JLabel(new ImageIcon(Imagem.getImagem(TOKEN_SMALL)));

        }

        private void dispTokens() {
            SpringLayout info = new SpringLayout();
            setLayout(info);
            int esq = 0;
            int top = 0;
            //xp
            int stat_xp = modelo.getXp();
            if (stat_xp < 21) {
                esq = 53 + (stat_xp * 33);
                top = 19;
            }
            if (stat_xp > 20 && stat_xp < 37) {
                stat_xp = stat_xp - 20;
                esq = 53 + (stat_xp * 33);
                top = 49;
            }

            info.putConstraint(SpringLayout.WEST, token[0], esq, SpringLayout.WEST, this);
            info.putConstraint(SpringLayout.NORTH, token[0], top, SpringLayout.WEST, this);
            this.add(token[0]);


            //money
            top = 101;
            esq = 53 + (modelo.getGold() * 33);
            info.putConstraint(SpringLayout.WEST, token[1], esq, SpringLayout.WEST, this);
            info.putConstraint(SpringLayout.NORTH, token[1], top, SpringLayout.WEST, this);
            this.add(token[1]);
            //hp
            top = 149;
            esq = 53 + (modelo.gethp() * 33);
            info.putConstraint(SpringLayout.WEST, token[2], esq, SpringLayout.WEST, this);
            info.putConstraint(SpringLayout.NORTH, token[2], top, SpringLayout.WEST, this);
            this.add(token[2]);
            //armor
            top = 198;
            esq = 53 + (modelo.getArmor() * 33);
            info.putConstraint(SpringLayout.WEST, token[3], esq, SpringLayout.WEST, this);
            info.putConstraint(SpringLayout.NORTH, token[3], top, SpringLayout.WEST, this);
            this.add(token[3]);
            //food
            top = 198;
            esq = 515 + (modelo.getFood() * 33);
            info.putConstraint(SpringLayout.WEST, token[4], esq, SpringLayout.WEST, this);
            info.putConstraint(SpringLayout.NORTH, token[4], top, SpringLayout.WEST, this);
            this.add(token[4]);

            //fire spell
            top = 198;
            if (modelo.getstock(2) > 0) {
                esq = 251;
                info.putConstraint(SpringLayout.WEST, token[5], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[5], top, SpringLayout.WEST, this);
                this.add(token[5]);
            }
            if (modelo.getstock(2) > 1) {
                esq = 284;
                info.putConstraint(SpringLayout.WEST, token[6], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[6], top, SpringLayout.WEST, this);
                this.add(token[6]);
            }

            //ice spell
            if (modelo.getstock(3) > 0) {
                esq = 317;
                info.putConstraint(SpringLayout.WEST, token[7], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[7], top, SpringLayout.WEST, this);
                this.add(token[7]);
            }
            if (modelo.getstock(3) > 1) {
                esq = 350;
                info.putConstraint(SpringLayout.WEST, token[8], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[8], top, SpringLayout.WEST, this);
                this.add(token[8]);
            }
            //poison spell
            if (modelo.getstock(4) > 0) {
                esq = 383;
                info.putConstraint(SpringLayout.WEST, token[9], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[9], top, SpringLayout.WEST, this);
                this.add(token[9]);
            }
            if (modelo.getstock(4) > 1) {
                esq = 416;
                info.putConstraint(SpringLayout.WEST, token[10], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[10], top, SpringLayout.WEST, this);
                this.add(token[10]);
            }

            //poison spell
            if (modelo.getstock(5) > 0) {
                esq = 449;
                info.putConstraint(SpringLayout.WEST, token[11], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[11], top, SpringLayout.WEST, this);
                this.add(token[11]);
            }
            if (modelo.getstock(5) > 1) {
                esq = 482;
                info.putConstraint(SpringLayout.WEST, token[12], esq, SpringLayout.WEST, this);
                info.putConstraint(SpringLayout.NORTH, token[12], top, SpringLayout.WEST, this);
                this.add(token[12]);
            }

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image enemy = Imagem.getImagem(STATUS);

            if (enemy != null) {

                g.drawImage(enemy, 0, 0, 770, 250, this);


            } else {
                System.err.println(" imagem == null");
            }


        }

    }
    
    private class LogPanel extends JPanel{
            private JTextArea logGAme;
            private JLabel title;
            private JScrollPane scroll;
            
            public  LogPanel( String[] logs){
                super();
             setBackground(new Color(0, 0, 0, 140));
            setPreferredSize(new Dimension(600, 250));
            setMaximumSize(new Dimension(600, 250));
            setMinimumSize(new Dimension(600, 250));
            setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            criaObj(logs);
            DispObj();
            }
            
            private void criaObj(String[] logs){
                        
                         title= new JLabel("Logs:");
                         title.setForeground(Color.WHITE);
                         title.setFont(new Font("Arial", Font.BOLD, 20));
                         
                         
                         logGAme = new JTextArea();
                         logGAme.setBackground(Color.BLACK);
                       
                         logGAme.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
                         logGAme.setEditable(false);
                         logGAme.setForeground(margem);
                         logGAme.setFont(new Font("Arial", Font.PLAIN, 18));
                         logGAme.setAutoscrolls(true);
                         logGAme.setHighlighter(null);//impede que se sublinhe +/-
                        
                         logGAme.setLineWrap(true);
                         
                         
                         scroll = new JScrollPane(logGAme);
                         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                         
                        scroll.setPreferredSize(new Dimension(570, 210));
                        scroll.setMaximumSize(new Dimension(570, 210));
                        scroll.setMinimumSize(new Dimension(570, 210));
                        scroll.setForeground(margem);
                        scroll.setOpaque(false);
                        
                                             /* -> LEITAO <- */
                        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss >> ");
                        Date now = new Date();
                        String strDate = sdfDate.format(now);
                        logGAme.append(strDate+"ola mundo teste teste jagsh");
                        
            }
            
            private void DispObj(){
            SpringLayout logLayout = new SpringLayout();
            this.setLayout(logLayout);
            
            logLayout.putConstraint(SpringLayout.WEST, title, 12, SpringLayout.WEST, this);
            logLayout.putConstraint(SpringLayout.NORTH, title, 4, SpringLayout.NORTH, this);
            this.add(title);
            
            //logLayout.putConstraint(SpringLayout.WEST, logGAme, 12, SpringLayout.WEST, this);
           // logLayout.putConstraint(SpringLayout.NORTH, logGAme, 30, SpringLayout.WEST, this);
          //this.add(logGAme);
            
             logLayout.putConstraint(SpringLayout.WEST, scroll, 12, SpringLayout.WEST, this);
            logLayout.putConstraint(SpringLayout.NORTH, scroll, 30, SpringLayout.NORTH, this);
            this.add(scroll);
            
            

            }
    }
    
}
