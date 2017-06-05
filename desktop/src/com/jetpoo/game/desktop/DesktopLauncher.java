package com.jetpoo.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jetpoo.game.JetPoo;
import com.jetpoo.game.Server.PlayServices;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		PlayServices playServices;
		new LwjglApplication(new JetPoo(playServices), config);
	}
}
