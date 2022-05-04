package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameCamera extends OrthographicCamera {
	
	private float zoom = 1f;
	private float x, y;
	
	private float maxZoom = 0.01f;
	
	public GameCamera() {
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	    super.position.set(super.viewportWidth / 2, super.viewportHeight / 2, 0);
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
		if (this.zoom < maxZoom) this.zoom = maxZoom;
		super.zoom = zoom;
	}
	
	public void changeZoom(float zoom, int pointX, int pointY) {
		var worldPosBefore = super.unproject(new Vector3(pointX, pointY, 0));
		float worldXBefore = worldPosBefore.x, worldYBefore = worldPosBefore.y;
		
		
		this.zoom += zoom * (this.zoom - maxZoom);
		if (this.zoom < maxZoom) this.zoom = maxZoom;
		super.zoom = this.zoom;
		super.update();
		
		var worldPosAfter = super.unproject(new Vector3(pointX, pointY, 0));
		float worldXAfter = worldPosAfter.x, worldYAfter = worldPosAfter.y;
		
		x-=(worldXAfter - worldXBefore);// * zoom; //zoom/5;
		y-=(worldYAfter - worldYBefore);// * zoom; //(zoom)/5 ;
		
		//x-= x - (worldXAfter - x);
		//y-= y - (worldYAfter - y);
		
		//worldX - worldX - x
		//System.out.println("x: " + worldXAfter + " y: " + worldYAfter + " zoom: " + this.zoom);
		//System.out.println(pointX - Gdx.graphics.getWidth() / 2);
		//x -= (pointX - Gdx.graphics.getWidth() / 2) * (1.0f / zoom);
		//y += (pointY - Gdx.graphics.getHeight() / 2) * (1.0f / zoom);
		//System.out.println("x: " + worldXAfter + " y: " + worldYAfter);
		
		updatePosition();
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
		updatePosition();
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
		updatePosition();
	}
	
	void updatePosition() {
		super.position.set(this.x, this.y, 0);
		super.update();
	}
	
}
