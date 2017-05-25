
package mini_rogue.GUI.Vistas;
import java.awt.BorderLayout;
import mini_rogue.GUI.modelo.Modelo;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD
import mini_rogue.logic.states.*;
=======
<<<<<<< HEAD
import mini_rogue.logic.states.*;
=======
>>>>>>> origin/master
>>>>>>> origin/master


public class VistaFrame extends JFrame implements  Observer,Constantes {

    private Modelo modelo;
    private Container cp;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    
>>>>>>> origin/master
>>>>>>> origin/master
    public VistaFrame(Modelo m)  {
        super("The Test");
        modelo=m;
        modelo.addObserver(this);
        setLocation(x, y);
        setSize(LARGURA, ALTURA);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
        cp=getContentPane();
        setResizable(false);
       
        criaObj();
        DispObj();
        add(new AwaitForBeginningGUI(modelo),BorderLayout.CENTER);
<<<<<<< HEAD
        //add(new AwaitOptionSelectionGUI(modelo),BorderLayout.CENTER);
        //add(new AwaitForTradingGUI(modelo),BorderLayout.CENTER);

=======
=======
        
        criaMargem();
        DispObj();
       
        
        
>>>>>>> origin/master
        
>>>>>>> origin/master
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

       
    @Override
    public void update(Observable o, Object o1) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
        IStates state=modelo.getState();
        cp.removeAll();
        DispObj();
        if (state instanceof AwaitBeginning)
        cp.add(new AwaitCardSelectioGUI(modelo),BorderLayout.CENTER);
        if (state instanceof AwaitCardSelection)
        cp.add(new AwaitCardSelectioGUI(modelo),BorderLayout.CENTER);
        
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
        
        
        //add(new AwaitForBeginningGUI(modelo),BorderLayout.CENTER);
        
        //add( new AwaitCardSelectioGUI(modelo),BorderLayout.CENTER);
<<<<<<< HEAD
=======
=======
        
    }

    private void criaMargem() {
        n.setBackground(margem);
        e.setBackground(margem);
        w.setBackground(margem);
        s.setBackground(margem);   
    
    }

    private void DispObj() {
        setLayout(new BorderLayout());
        add(n,BorderLayout.NORTH);
        add(s,BorderLayout.SOUTH);
        add(e,BorderLayout.EAST);
        add(w,BorderLayout.WEST);

        add(new AwaitForBeginningGUI(modelo),BorderLayout.CENTER);
        
        //add(new vista2(modelo));    
>>>>>>> origin/master
>>>>>>> origin/master
    }

}
