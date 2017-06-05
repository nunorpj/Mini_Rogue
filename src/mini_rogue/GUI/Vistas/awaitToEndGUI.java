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
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static mini_rogue.GUI.Vistas.Constantes.ALTURA;
import static mini_rogue.GUI.Vistas.Constantes.FUNDO;
import static mini_rogue.GUI.Vistas.Constantes.LARGURA;

import mini_rogue.GUI.modelo.Modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class awaitToEndGUI extends JPanel implements Constantes {

    private  Modelo modelo;
    private coordenadas[] coord;
    private int  contador ;
    
    private JButton newGame;
    private JLabel result;
    
    public awaitToEndGUI(Modelo m){
    this.modelo=m;
    coord=new coordenadas[10000];
    for(int i=0; i<10000;i++)
        coord[i]=new coordenadas();
    desenhar des=new desenhar();
    des.start();
    
    CriaObjt();
    DispObjt();
    RegistaListners();
    }

    private void CriaObjt() {
        result= new JLabel(new ImageIcon(Imagem.getImagem(LOST)));
        
        
        newGame = new JButton("New Game!");
        newGame.setMaximumSize(bSize);
        newGame.setMinimumSize(bSize);
        newGame.setPreferredSize(bSize);
        newGame.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        newGame.setBackground(Color.darkGray);
        newGame.setForeground(margem);
        newGame.setFocusPainted(false);
        newGame.setFont(new Font("Serif", Font.BOLD, 25));
        
        
    }

    private void DispObjt() {
        SpringLayout layout=new SpringLayout();
        
        setLayout(layout);
        //if perdeu
        layout.putConstraint(SpringLayout.WEST, result, 427, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, result, 200, SpringLayout.WEST, this);
        add(result);   
        //else  ganhou
        
        
        
        
        layout.putConstraint(SpringLayout.WEST, newGame, 570, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, newGame, 500, SpringLayout.WEST, this);
        add(newGame);   
    }

    private void RegistaListners() {
    }
    
    @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        Image fundo=Imagem.getImagem(FUNDO);
                //if perdeu

        Image span= Imagem.getImagem(POISON);
               //else  ganhou

        if(fundo!=null){
             g.drawImage(fundo, 0, 0, LARGURA, ALTURA,this);
            
             for(int i=0; i<contador;i++){
               g.drawImage(span, coord[i].esq, coord[i].norte, 20,  20,this);
              i++;
               g.drawImage(span, coord[i].esq, coord[i].norte, 20,  20,this);
            }


        }else{
            System.err.println(" imagem == null");
        }
            
           
            
         }
     
         public class desenhar extends Thread {
        

         @Override
         public void run(){ 

            for(contador=0;contador<10000;contador++){
                repaint();
                try{
                        Thread.sleep(125);
                }catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                }
            }
        }


            
}
  
     
     public class coordenadas{
         public int esq;
         public int norte;
         
         public coordenadas(){
              esq = ThreadLocalRandom.current().nextInt(0, LARGURA + 1);
              norte = ThreadLocalRandom.current().nextInt(0, ALTURA + 1);
         }
         
     }
     
}
