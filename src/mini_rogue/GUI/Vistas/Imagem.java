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
<<<<<<< HEAD
           imagens.put(LOGO, ImageIO.read(Resources.getResourceFile(PATH_IMG_LOGO)));
           imagens.put(TOCHA,ImageIO.read(Resources.getResourceFile(PATH_IMG_TOCHA)));
           imagens.put(BACK,ImageIO.read(Resources.getResourceFile(PATH_IMG_BACK)));
           imagens.put(FUNDO,ImageIO.read(Resources.getResourceFile(PATH_IMG_FUNDO)));
           imagens.put(BOSS,ImageIO.read(Resources.getResourceFile(PATH_IMG_BOSS)));
           imagens.put(EVENT_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_EVENT_CARD)));
           imagens.put(MERCHANT_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_MERCHANT_CARD)));
           imagens.put(MONSTER_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_MONSTER_CARD)));
           imagens.put(RESTING_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_RESTING_CARD)));
           imagens.put(BOSS,ImageIO.read(Resources.getResourceFile(PATH_IMG_BOSS)));
           imagens.put(TRAP_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_TRAP_CARD)));
           imagens.put(TREASURE_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_TREASURE_CARD)));
           imagens.put(FOOD,ImageIO.read(Resources.getResourceFile(PATCH_IMG_FOOD)));

           
           
           imagens.put(VIDA,ImageIO.read(Resources.getResourceFile(PATH_IMG_VIDA)));
           imagens.put(SHIELD,ImageIO.read(Resources.getResourceFile(PATCH_IMG_SHIELD)));
           imagens.put(COIN,ImageIO.read(Resources.getResourceFile(PATCH_IMG_COIN)));
           imagens.put(XP,ImageIO.read(Resources.getResourceFile(PATCH_IMG_XP)));
           imagens.put(FIRE,ImageIO.read(Resources.getResourceFile(PATCH_IMG_FIRE)));
           imagens.put(HEAL,ImageIO.read(Resources.getResourceFile(PATCH_IMG_HEAL)));
           imagens.put(POISON,ImageIO.read(Resources.getResourceFile(PATCH_IMG_POISON)));
           imagens.put(ICE,ImageIO.read(Resources.getResourceFile(PATCH_IMG_ICE)));


=======
            imagens.put(LOGO, ImageIO.read(Resources.getResourceFile(PATH_IMG_LOGO)));
            imagens.put(TOCHA,ImageIO.read(Resources.getResourceFile(PATH_IMG_TOCHA)));
>>>>>>> origin/master
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
