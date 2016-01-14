package to.uk.openbracket;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Block {
	
	boolean isFixed, isAttached;
	
	int x, y, w, h;
	
	Color color;
	
	Player player;
	
	public Block(int x, int y, int w, int h, Color color, Player player) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
		this.player = player;	
		
	}
	
	public void update() {
		/*
		if(player.x <= x+w && player.y <= y+h-1 && player.x > x+1) {
			player.x = x+w;
		}*/
		
		if(player.x > x && player.y <= y+h && player.x < x+w-1 || player.x+player.w > x && player.y <= y+h && player.x+player.w < x+w-1 ) {
			player.y = y+h;
		} else if(!player.bottomCol) {
			player.bottomCol = false;
		}
		
		
	}
	
	public void render(Batch batch, OrthographicCamera cam) {
		
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		//batch.draw(img, (float) x, (float) y);
		
		ShapeRenderer sR = new ShapeRenderer();
		sR.begin(ShapeType.Filled);
        sR.setColor(color);
        sR.rect((float) x,(float) y, (float) w, (float) h);
        sR.end();
		
		batch.end();
		
	}

}
