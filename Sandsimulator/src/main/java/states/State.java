package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import input.InputManager;
import main.GameCamera;
import main.Handler;

public abstract class State {
	
	protected Handler handler;
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update(InputManager input);
	
	public abstract void render(ShapeRenderer sr, GameCamera camera);

	public abstract void renderUi(SpriteBatch batch, GameCamera camera);
}
