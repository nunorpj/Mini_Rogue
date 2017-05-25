/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;
import static mini_rogue.GUI.Vistas.Constantes.margem;
import mini_rogue.GUI.modelo.Modelo;

/**+
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AwaitOptionSelectionGUI extends JPanel implements Constantes{
    private Modelo modelo;
    private JPanel option1Panel;
    private JPanel option2Panel;
    private JPanel option3Panel;
    private JLabel  option1label; 
    private JLabel  option2label; 
    private JLabel  option3label; 
    private JButton option1Button;
    private JButton option2Button;
    private JButton option3Button;
    AwaitOptionSelectionGUI(Modelo m) {
        this.modelo=m;
        
        criaObj();
        DispObj();
        RegistaListeners();
    }

    
        private void criaObj() {
            option1Panel=new JPanel();
            option1Panel.setBackground(new Color(0, 0, 0, 140));
            option1Panel.setPreferredSize(new Dimension(240, 100));
            option1Panel.setMaximumSize(new Dimension(240, 100));
            option1Panel.setMinimumSize(new Dimension(240, 100));
            option1Panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            option2Panel=new JPanel();
            option2Panel.setBackground(new Color(0, 0, 0, 140));
            option2Panel.setPreferredSize(new Dimension(240, 100));
            option2Panel.setMaximumSize(new Dimension(240, 100));
            option2Panel.setMinimumSize(new Dimension(240, 100));
            option2Panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            option3Panel=new JPanel();
            option3Panel.setBackground(new Color(0, 0, 0, 140));
            option3Panel.setPreferredSize(new Dimension(240, 100));
            option3Panel.setMaximumSize(new Dimension(240, 100));
            option3Panel.setMinimumSize(new Dimension(240, 100));
            option3Panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, margem));
            
            option1label=new JLabel("Reinforce Your Weapon: +1xp");
            option1label.setForeground(Color.WHITE);
            option1label.setFont(new Font("Arial", Font.BOLD, 15));
            option1label.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            option2label=new JLabel("     Search For Ration: 1+Food");
            option2label.setForeground(Color.WHITE);
            option2label.setFont(new Font("Arial", Font.BOLD, 15));
            option2label.setAlignmentX(Component.CENTER_ALIGNMENT);

            option3label=new JLabel("Heal: +2Hp");
            option3label.setForeground(Color.WHITE);
            option3label.setFont(new Font("Arial", Font.BOLD, 15));
            option3label.setAlignmentX(Component.CENTER_ALIGNMENT);

            option1Button = new JButton("CHOSE");
            option1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
            option1Button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            option1Button.setBackground(new Color(15,145,99,150));
            option1Button.setForeground(Color.white);
            option1Button.setFocusPainted(false);
            option1Button.setFont(new Font("Arial", Font.BOLD, 20));
            
            
            option2Button = new JButton("CHOSE");
            option2Button.setAlignmentX(Component.CENTER_ALIGNMENT);
            option2Button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            option2Button.setBackground(new Color(15,145,99,150));
            option2Button.setForeground(Color.white);
            option2Button.setFocusPainted(false);
            option2Button.setFont(new Font("Arial", Font.BOLD, 20));
            
            
            option3Button = new JButton("CHOSE");
            option3Button.setAlignmentX(Component.CENTER_ALIGNMENT);
            option3Button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            option3Button.setBackground(new Color(15,145,99,150));
            option3Button.setForeground(Color.white);
            option3Button.setFocusPainted(false);
            option3Button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void DispObj() {
        SpringLayout EVENTLayout = new SpringLayout();
        this.setLayout(EVENTLayout);
        
        
        EVENTLayout.putConstraint(SpringLayout.WEST, option1Panel, 900, SpringLayout.WEST, this);
        EVENTLayout.putConstraint(SpringLayout.NORTH, option1Panel, 130, SpringLayout.WEST, this);
        this.add(option1Panel);
        
        option1Panel.setLayout(new BoxLayout(option1Panel, BoxLayout.Y_AXIS));
        
        option1Panel.add(Box.createRigidArea(new Dimension(0,10)));
        option1Panel.add(option1label);
        option1Panel.add(Box.createRigidArea(new Dimension(0,20)));
        option1Panel.add(option1Button);
        
        
        EVENTLayout.putConstraint(SpringLayout.WEST, option2Panel, 900, SpringLayout.WEST, this);
        EVENTLayout.putConstraint(SpringLayout.NORTH, option2Panel, 370, SpringLayout.WEST, this);
        this.add(option2Panel);
        
        
         option2Panel.setLayout(new BoxLayout(option2Panel, BoxLayout.Y_AXIS));
        
        option2Panel.add(Box.createRigidArea(new Dimension(0,10)));
        option2Panel.add(option2label);
        option2Panel.add(Box.createRigidArea(new Dimension(0,20)));
        option2Panel.add(option2Button);
        
        
        EVENTLayout.putConstraint(SpringLayout.WEST, option3Panel, 900, SpringLayout.WEST, this);
        EVENTLayout.putConstraint(SpringLayout.NORTH, option3Panel, 620, SpringLayout.WEST, this);
        this.add(option3Panel);
         
        option3Panel.setLayout(new BoxLayout(option3Panel, BoxLayout.Y_AXIS));
        
        option3Panel.add(Box.createRigidArea(new Dimension(0,10)));
        option3Panel.add(option3label);
        option3Panel.add(Box.createRigidArea(new Dimension(0,20)));
        option3Panel.add(option3Button);
    }
    
        private void RegistaListeners() {
            option1Button.addActionListener(new Opiton1Listner());
            option2Button.addActionListener(new Opiton2Listner());
            option3Button.addActionListener(new Opiton3Listner());
            
    }
    
      private  class Opiton1Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
         modelo.RestingSelectoin(1);
        }
    }
      
      
      
    private  class Opiton2Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  modelo.RestingSelectoin(2);

        }
    }     
     private  class Opiton3Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                  modelo.RestingSelectoin(3);

        }
    }    
        
        
        @Override
        public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image fundo=Imagem.getImagem(FUNDO);
        Image resting_image=Imagem.getImagem(RESTING_CARD_BIG);
        if(fundo!=null){
            
             g.drawImage(fundo, 0, 0, LARGURA, ALTURA,this);
            g.drawImage(resting_image, 200,25,550,790,this);
        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }




}
