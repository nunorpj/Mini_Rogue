/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mini_rogue.GUI.Vistas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Constantes {
    int  ALTURA=900;
    int LARGURA=1440;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int x=dim.width/2-720;
    int y=dim.height/2-450;
    
    Color margem = new Color(201,180,137);
          
        JPanel n =new JPanel();
        JPanel s =new JPanel();
        JPanel e =new JPanel();
        JPanel w =new JPanel();
    
        Dimension bSize= new Dimension(250,50);
    
    
    
    
    String Start="Start";
    String StartingArea= "Set Starting Area!";
    String StartingDificulty= "Set Starting Dificulty";
    String Quit="Quit!";
    String Load= "Load Game!";
    
    
    String LOGO= "logo";
    String PATH_IMG_LOGO = "imagens/logo.jpg";
    
    String TOCHA= "tocha";
    String PATH_IMG_TOCHA= "imagens/tocha.png";
    
    String  OLHOS= "olhos";
    String PATH_IMG_OLHOS="imagens/olhos.png";
    
    
    String BACK= "back";
    String PATH_IMG_BACK= "imagens/back.png";
    
    String FUNDO="fundo";
    String PATH_IMG_FUNDO= "imagens/table.jpg";
    
    String SWORD= "sword";
    String PATH_IMG_SWORD = "imagens/sword.png";
    
    String BOSS= "Boss Monster";
    String PATH_IMG_BOSS = "imagens/boss_monster_front.png";

    
    String MONSTER_CARD= "Monster Card";
    String PATH_IMG_MONSTER_CARD="imagens/monster_front.png";
    

    
    String TREASURE_CARD="Treasure Card";
    String PATH_IMG_TREASURE_CARD="imagens/treasure_front.png";

    String TRAP_CARD="Trap Card";
    String PATH_IMG_TRAP_CARD="imagens/trap_front.png";

    String RESTING_CARD="Resting Card";
    String PATH_IMG_RESTING_CARD="imagens/resting_front.png";

    String MERCHANT_CARD="Merchant Card";
    String PATH_IMG_MERCHANT_CARD="imagens/merchant_front.png";

    String EVENT_CARD="Event Card";
    String PATH_IMG_EVENT_CARD="imagens/event_front.png";
    

    
    String RESTING_CARD_BIG="Resting Card big";
    String PATH_IMG_RESTING_CARD_BIG="imagens/resting_front_big.png";
    
    String MERCHANT_CARD_BIG="Merchant Card big";
    String PATH_IMG_MERCHANT_CARD_BIG="imagens/merchant_front_big.png";
    
    String VIDA="hp";
    String PATH_IMG_VIDA="imagens/hp.png";
    
    String SHIELD="shield";
    String PATCH_IMG_SHIELD="imagens/SHIELD.png";
    
    String FOOD="food";
    String PATCH_IMG_FOOD="imagens/FOOD.png";

    String COIN="coin";
    String PATCH_IMG_COIN="imagens/coin.png";
    
    String XP="xp";
    String PATCH_IMG_XP="imagens/xp.png";
     
    String FIRE="fire";
    String PATCH_IMG_FIRE="imagens/fire.png";
    
    String HEAL="heal";
    String PATCH_IMG_HEAL="imagens/heal.png";
    
    String POISON="poson";
    String PATCH_IMG_POISON="imagens/POISON.png";

   String ICE= "ice";
   String PATCH_IMG_ICE="imagens/ICE.png";

   String HERO= "hero";
   String PATCH_IMG_HERO="imagens/character_stats_small_front.png";
   
      String MONSTRO= "monstro";
   String PATCH_IMG_MONSTRO="imagens/the_dungeon_front.png";
   
   
   String TOKEN="Token";
   String PATCH_IMG_TOKEN="imagens/token.png";
   
     String STATUS="status";
   String PATCH_IMG_STATUS="imagens/Character_Stats.png";
   
   String TOKEN_SMALL="Token small";
   String PATCH_IMG_TOKEN_SMALL="imagens/token_small.png";
   
   String DUNGEON= "dungeon";
   String PATCH_IMG_DUNGEON="imagens/the_dungeon_front_small.png";
   
   
   String MENU_SOM="menu";
   String PATCH_SOM_MENU="Sons/menu.au";
   
   
   String FIGHT_SOUND="fight sound";
  String PATCH_FIGHT_SOUND="Sons/fight_music.au";

  String MAIN_SOUND="main sound";
  String PATCH_MAIN_SOUND="Sons/main.au";

  String DICE_1="dice 1";
  String PATCH_IMAGE_DICE_1="imagens/1.png";
  
  String DICE_2="dice 2";
  String PATCH_IMAGE_DICE_2="imagens/2.png";
  
  String DICE_3="dice 3";
  String PATCH_IMAGE_DICE_3="imagens/3.png";
  
  String DICE_4="dice 4";
  String PATCH_IMAGE_DICE_4="imagens/4.png";
  
  String DICE_5="dice 5";
  String PATCH_IMAGE_DICE_5="imagens/5.png";
  
  String DICE_6="dice 6";
  String PATCH_IMAGE_DICE_6="imagens/6.png";
  
  String LOST="lost";
  String PATCH_IMAGE_LOST="imagens/lost.png";  
}
