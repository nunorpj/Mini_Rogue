
package mini_rogue.GUI.Vistas;
import java.awt.BorderLayout;
import mini_rogue.GUI.modelo.Modelo;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static mini_rogue.GUI.Vistas.Constantes.MENU_SOM;
import mini_rogue.GUI.Vistas.Sons.Som;
import mini_rogue.logic.states.*;

public class VistaFrame extends JFrame implements  Observer,Constantes {

    private Modelo modelo;
    private Container cp;
    private SomThread thread_som;
    public VistaFrame(Modelo m)  {
        super("Mini Rogue");
        modelo=m;
        modelo.addObserver(this);
        setLocation(x, y);
        setSize(LARGURA, ALTURA);
        cp=getContentPane();
        setResizable(false);
        thread_som=new SomThread();
        thread_som.start();
        

        
       
       
        criaObj();
        DispObj();
        add(new AwaitForBeginningGUI(modelo),BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

       
    @Override
    public void update(Observable o, Object o1) {
        IStates state=modelo.getState();
        cp.removeAll();
        DispObj();
        if (state instanceof AwaitBeginning){
            cp.add(new AwaitForBeginningGUI(modelo),BorderLayout.CENTER);
            thread_som.MudaSom(MENU_SOM);
        }else if (state instanceof AwaitCardSelection){
            cp.add(new AwaitCardSelectioGUI(modelo),BorderLayout.CENTER);
            thread_som.MudaSom(MAIN_SOUND);
        }else if (state instanceof AwaitTrading){
            cp.add(new AwaitForTradingGUI(modelo),BorderLayout.CENTER);
            
        }else if (state instanceof AwaitOptionSelection){
            cp.add(new AwaitOptionSelectionGUI(modelo),BorderLayout.CENTER);
            
        }else if (state instanceof RolledDices){
         cp.add(new RolledDicesGUI(modelo),BorderLayout.CENTER);
          thread_som.MudaSom(FIGHT_SOUND);

        }else if (state instanceof AwaitForSpell){
         cp.add(new awaiForSpellsGUI(modelo),BorderLayout.CENTER);
        }else if (state instanceof WaitForFeats){
         cp.add(new waitForFeatsGUI(modelo),BorderLayout.CENTER);
       }else if (state instanceof AwaitToEnd){
         cp.add(new awaitToEndGUI(modelo),BorderLayout.CENTER);
        }
        repaint();
        revalidate();
    }

    private void criaObj() {
        n.setBackground(margem);
        e.setBackground(margem);
        w.setBackground(margem);
        s.setBackground(margem); 
    }

    private void DispObj() {
        cp.setLayout(new BorderLayout());
        cp.add(n,BorderLayout.NORTH);
        cp.add(s,BorderLayout.SOUTH);
        cp.add(e,BorderLayout.EAST);
        cp. add(w,BorderLayout.WEST);
       
    }

    public class SomThread extends Thread {
        private Som som;   
        @Override
        public void run(){  
         som = new Som(MENU_SOM);
         
            }
        public void MudaSom(String s){

            if(modelo.getState().getClass()==(modelo.getLastState().getClass())||modelo.getLastState() instanceof AwaitTrading||modelo.getLastState() instanceof AwaitOptionSelection){
            } else {
                som.stop();
                som = new Som(s);
            }
            if(modelo.getLastState().getClass()==modelo.getState().getClass() && modelo.getState() instanceof AwaitBeginning ){
                 som.stop();
                som = new Som(s);
            }
            

            
        }
            
}
  
        
}
