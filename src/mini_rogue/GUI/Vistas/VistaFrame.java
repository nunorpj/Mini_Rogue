
package mini_rogue.GUI.Vistas;
import java.awt.BorderLayout;
import mini_rogue.GUI.modelo.Modelo;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VistaFrame extends JFrame implements  Observer,Constantes {

    private Modelo modelo;
    private Container cp;
    
    public VistaFrame(Modelo m)  {
        super("The Test");
        modelo=m;
        modelo.addObserver(this);
        setLocation(x, y);
        setSize(LARGURA, ALTURA);
        
        criaMargem();
        DispObj();
       
        
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

       
    @Override
    public void update(Observable o, Object o1) {
        
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
    }

}
