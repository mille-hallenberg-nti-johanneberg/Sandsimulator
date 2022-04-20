package cell;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class Cell {
	private CellType type;
	private Color color;
	
	public int frameUpdated;
	public boolean isBurning;
	
	float velocity_x, velocity_y;
	
	public Cell(CellType type){
		Random rand = new Random();
		
		this.setType(type);
		this.setColor(type.getColor(rand.nextFloat()));
	}

	public CellType getType() {
		return type;
	}

	public void setType(CellType type) {
		this.type = type;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}