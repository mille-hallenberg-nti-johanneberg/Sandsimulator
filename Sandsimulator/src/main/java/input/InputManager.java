package input;

import java.util.ArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputManager implements InputProcessor{
	private Keys[] keys = new Keys[256];
	private ArrayList<Keys> processDown = new ArrayList<Keys>();
	private ArrayList<Keys> processUp = new ArrayList<Keys>();
	
	public int mouseX, mouseY;
	
	public InputManager() {
		for (var key : Keys.values()) {
			keys[key.code] = key; 
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		try {
			keys[keycode].pressed = true;
			keys[keycode].down = true;
			
			processDown.add(keys[keycode]);
		}
		catch (Exception e) {
			System.out.println("Key not is not supported");
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		try {
			keys[keycode].pressed = false;
			keys[keycode].up = true;
			
			processUp.add(keys[keycode]);
		}
		catch (Exception e) {
			System.out.println("Key is not supported");
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		try {
			keys[button].pressed = true;
			keys[button].down = true;
			
			processUp.add(keys[button]);
		}
		catch (Exception e) {
			System.out.println("Key is not supported");
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		try {
			keys[button].pressed = false;
			keys[button].up = true;
			
			processUp.add(keys[button]);
		}
		catch (Exception e) {
			System.out.println("Key is not supported");
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Mouse.setX(screenX);
		Mouse.setY(screenY);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		Mouse.setX(screenX);
		Mouse.setY(screenY);
		//System.out.println("Mouse: " + screenX + " " + screenY);
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		Mouse.scrollUp = amountY > 0;
		Mouse.scrollDown = amountY < 0;
		return false;
	}
	
	public void update() {
		Mouse.scrollUp = false;
		Mouse.scrollDown = false;
		for (var key: processDown) {
			key.down = false;
		}
		processDown.clear();
		
		for (var key: processUp) {
			key.up = false;
		}
		processUp.clear();
	}
}


