package module2;

public class Points {
	private float x;
	private float y;
	
	public Points (float ax, float ay) {
		x = ax;
		y = ay;
	}
	
	public Points () {
		x = 0;
		y = 0;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}