package mini_rogue.GUI.Vistas.Sons;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mini_rogue.GUI.Vistas.Constantes;
import mini_rogue.GUI.Vistas.Resources;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

public class Som implements Constantes{
     static  AudioClip som;
     static  Map<String, AudioClip> sons = new HashMap<String, AudioClip>();
       static {
           sons.put(MENU_SOM,Applet.newAudioClip(Resources.getResourceFile(PATCH_SOM_MENU)));
           sons.put(FIGHT_SOUND,Applet.newAudioClip(Resources.getResourceFile(PATCH_FIGHT_SOUND)));
           sons.put(MAIN_SOUND,Applet.newAudioClip(Resources.getResourceFile(PATCH_MAIN_SOUND)));
    }

public Som(String s){
    som=sons.get(s);
    som.loop();
}


public void play(){
        if ( som != null)
            som.play();
}
public void stop(){
       if ( som != null) 
           som.stop();
}
public void loop(){
        if ( som != null) 
            som.loop();
}



}
