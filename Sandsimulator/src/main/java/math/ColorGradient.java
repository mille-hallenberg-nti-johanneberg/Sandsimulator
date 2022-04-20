package math;

import com.badlogic.gdx.graphics.Color;

public class ColorGradient {
	private Color color1; 
	private Color color2;
	
	public ColorGradient(Color color1, Color color2){
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public Color getColor(float point) {
		float r = color1.r + point * (color2.r - this.color1.r);
		float g = color1.g + point * (color2.g - this.color1.g);
		float b = color1.b + point * (color2.b - this.color1.b);
		float a = color1.a + point * (color2.a - this.color1.a);
		return new Color(r,g,b,a);
		//return color1.lerp(color2, point);
	}
}
