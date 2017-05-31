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
           imagens.put(TOCHA,ImageIO.read(Resources.getResourceFile(PATH_IMG_TOCHA)));
           imagens.put(LOGO, ImageIO.read(Resources.getResourceFile(PATH_IMG_LOGO)));
           imagens.put(BACK,ImageIO.read(Resources.getResourceFile(PATH_IMG_BACK)));
           imagens.put(FUNDO,ImageIO.read(Resources.getResourceFile(PATH_IMG_FUNDO)));
           imagens.put(BOSS,ImageIO.read(Resources.getResourceFile(PATH_IMG_BOSS)));
           imagens.put(EVENT_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_EVENT_CARD)));
           imagens.put(RESTING_CARD_BIG,ImageIO.read(Resources.getResourceFile(PATH_IMG_RESTING_CARD_BIG)));
           imagens.put(MERCHANT_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_MERCHANT_CARD)));
           imagens.put(MONSTER_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_MONSTER_CARD)));
           imagens.put(RESTING_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_RESTING_CARD)));
           imagens.put(BOSS,ImageIO.read(Resources.getResourceFile(PATH_IMG_BOSS)));
           imagens.put(TRAP_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_TRAP_CARD)));
           imagens.put(TREASURE_CARD,ImageIO.read(Resources.getResourceFile(PATH_IMG_TREASURE_CARD)));
           imagens.put(MERCHANT_CARD_BIG,ImageIO.read(Resources.getResourceFile(PATH_IMG_MERCHANT_CARD_BIG)));  
           imagens.put(HERO,ImageIO.read(Resources.getResourceFile(PATCH_IMG_HERO)));
           imagens.put(FOOD,ImageIO.read(Resources.getResourceFile(PATCH_IMG_FOOD)));
           imagens.put(VIDA,ImageIO.read(Resources.getResourceFile(PATH_IMG_VIDA)));
           imagens.put(SHIELD,ImageIO.read(Resources.getResourceFile(PATCH_IMG_SHIELD)));
           imagens.put(COIN,ImageIO.read(Resources.getResourceFile(PATCH_IMG_COIN)));
           imagens.put(XP,ImageIO.read(Resources.getResourceFile(PATCH_IMG_XP)));
           imagens.put(FIRE,ImageIO.read(Resources.getResourceFile(PATCH_IMG_FIRE)));
           imagens.put(HEAL,ImageIO.read(Resources.getResourceFile(PATCH_IMG_HEAL)));
           imagens.put(POISON,ImageIO.read(Resources.getResourceFile(PATCH_IMG_POISON)));
           imagens.put(ICE,ImageIO.read(Resources.getResourceFile(PATCH_IMG_ICE)));
           imagens.put(SWORD,ImageIO.read(Resources.getResourceFile(PATH_IMG_SWORD)));
           imagens.put(MONSTRO,ImageIO.read(Resources.getResourceFile(PATCH_IMG_MONSTRO)));
           imagens.put(TOKEN,ImageIO.read(Resources.getResourceFile(PATCH_IMG_TOKEN)));
          imagens.put(TOKEN_SMALL,ImageIO.read(Resources.getResourceFile(PATCH_IMG_TOKEN_SMALL)));
           imagens.put(STATUS,ImageIO.read(Resources.getResourceFile(PATCH_IMG_STATUS)));
           imagens.put(DUNGEON,ImageIO.read(Resources.getResourceFile(PATCH_IMG_DUNGEON)));
         
           imagens.put(DICE_1,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_1)));
           imagens.put(DICE_2,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_2)));
           imagens.put(DICE_3,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_3)));
           imagens.put(DICE_4,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_4)));
           imagens.put(DICE_5,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_5)));
           imagens.put(DICE_6,ImageIO.read(Resources.getResourceFile(PATCH_IMAGE_DICE_6)));
           imagens.put(OLHOS,ImageIO.read(Resources.getResourceFile(PATH_IMG_OLHOS)));


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
