package input;

public class Mouse {
	private static int x;
	private static int y;
	
	public static boolean scrollUp;
	public static boolean scrollDown;
	
	protected static void setX(int x) {
		Mouse.x = x;
	}
	protected static void setY(int y) {
		Mouse.y = y;
	}
	
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
}
