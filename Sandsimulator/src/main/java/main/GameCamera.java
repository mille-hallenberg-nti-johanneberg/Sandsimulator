package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameCamera {
	
	private Camera camera;
	private float zoom = 1f;
	private float x, y;
	
	private float maxZoom = 0.01f;
	
	public GameCamera() {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	    camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}
	
	public Camera getCamera() {
		return camera;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
		if (this.zoom < maxZoom) this.zoom = maxZoom;
		((OrthographicCamera)camera).zoom = zoom;
	}
	
	public void changeZoom(float zoom, int pointX, int pointY) {
		var worldPosBefore = camera.unproject(new Vector3(pointX, pointY, 0));
		float worldXBefore = worldPosBefore.x, worldYBefore = worldPosBefore.y;
		
		
		this.zoom += zoom * (this.zoom - maxZoom);
		if (this.zoom < maxZoom) this.zoom = maxZoom;
		((OrthographicCamera)camera).zoom = this.zoom;
		camera.update();
		
		var worldPosAfter = camera.unproject(new Vector3(pointX, pointY, 0));
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
		camera.position.set(this.x, this.y, 0);
		camera.update();
	}
	
}
