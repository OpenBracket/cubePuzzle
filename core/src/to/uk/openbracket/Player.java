package to.uk.openbracket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player {
	
	double x, y, vel;
	
	int w, h;
	
	Texture img;
	
	public boolean bottomCol, leftCol, rightCol, topCol;
	
	public Player(double x, double y, int w, int h, double vel) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vel = vel;
		
		img = new Texture("blankCube.jpg");
	}
	
	public void jump() {
		
		if(!bottomCol) return;
		
		vel += 500 * Gdx.graphics.getDeltaTime();
		
		y += vel;
		
		bottomCol = false;
	}
	
	public void update() {
		
		if(Gdx.input.isKeyPressed(Keys.A)) x -= 500 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.D)) x += 500 * Gdx.graphics.getDeltaTime();
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)) jump();
		
		if(y <= 0) {
			bottomCol = true;
			y = 0;
		}
		
		if(!bottomCol) {
			vel += CubePuzzle.GRAVITY;
		} else {
			vel = 0;
		}
		
		y += vel;
		
	}
	
	public void render(Batch batch, OrthographicCamera cam) {
		
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		//batch.draw(img, (float) x, (float) y);
		
		ShapeRenderer sR = new ShapeRenderer();
		sR.begin(ShapeType.Filled);
        sR.setColor(new Color(1f, 0.8f, 0, 1));
        sR.rect((float) x,(float) y, (float) w, (float) h);
        sR.end();
		
		batch.end();
		
	}
	
}
