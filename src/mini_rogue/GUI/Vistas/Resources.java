package mini_rogue.GUI.Vistas;

import java.net.URL;

public class Resources {
	
	public static URL getResourceFile(String name){
		// opens file with path relative to location of the Resources class
		URL url=Resources.class.getResource(name);
		return url; 
	}

}
