package net.tcollins.nugget;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class NuggetGameDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "nugget";
		cfg.useGL20 = false;
		cfg.width = 960;
		cfg.height = 640;
		
		new LwjglApplication(new NuggetGame(), cfg);
	}
}
