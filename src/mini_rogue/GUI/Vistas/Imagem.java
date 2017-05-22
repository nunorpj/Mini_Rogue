/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Imagem implements Constantes{

    private static Map<String, Image> imagens = new HashMap<String, Image>();
    static {
        try {
            imagens.put(LOGO, ImageIO.read(Resources.getResourceFile(PATH_IMG_LOGO)));
            imagens.put(TOCHA,ImageIO.read(Resources.getResourceFile(PATH_IMG_TOCHA)));
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    
     public static Image getImagem(String nome) {
        return imagens.get(nome);
     }
    public static Map<String, Image> getImagens() {
        return imagens;
    }

}
