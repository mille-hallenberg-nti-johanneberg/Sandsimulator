package main;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("Program started");
		//new Game("Sandsimulator", 1980/2, 1080/2);
		var config = new LwjglApplicationConfiguration();
		config.addIcon("images/BarIcon.png", FileType.Internal);
		
		//config.
		new LwjglApplication(new Game("Sandsimulator", 1980/2, 1080/2), config);
	}

}
