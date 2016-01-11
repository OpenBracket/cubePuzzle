package to.uk.openbracket.desktop;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import to.uk.openbracket.CubePuzzle;

public class DesktopLauncher {
	public static void main (String[] arg) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = width;
		config.height = height;
		config.fullscreen = true;
		new LwjglApplication(new CubePuzzle(), config);
	}
}
