package to.uk.openbracket;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class CubePuzzle extends ApplicationAdapter {
	
	private OrthographicCamera cam;
	
	public static double GRAVITY = -0.3;
	
	SpriteBatch batch;
	
	public Player player;
	
	public Block testBlock;
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int scrnWidth = gd.getDisplayMode().getWidth();
	int scrnHeight = gd.getDisplayMode().getHeight();
	
	@Override
	public void create () {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, scrnWidth, scrnHeight);
		
		player = new Player(0,1080,64,64,0);
		player.x = scrnWidth/2 -player.w/2;
		
		testBlock = new Block(0,0,64,64,new Color(0.2f, 0.2f, 0.2f, 1), player);
		
		batch = new SpriteBatch();
	}
	
	public void update() {
		
		player.update();
		testBlock.update();
		
		//collision detection 
		/*if(player.x < 0) player.x = 0;
		if(player.x > scrnWidth - 128) player.x = scrnWidth - 128;*/
		
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		player.render(batch, cam);
		testBlock.render(batch, cam);
		cam.update();
		
	}
}
