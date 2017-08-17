import processing.core.PImage;

//blueprint for each arrow object/graphic
public class Arrow {
	
	float x, y, ySpeed, length;
	int steps;
	boolean isAlive;
	boolean isHit;
	
	public Arrow(float x, float y, float ySpeed) {
		this.x = x;
		this.y = y;
		this.ySpeed = ySpeed;
		this.length = 100;
		this.steps = 0;
		isAlive = true;
		isHit = false;
	}
	
	public void move() {
		steps++;
		y -= ySpeed;
	}
	
	public void checkIfDead() {
		if (steps > 1000) isAlive = false;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean isHitting(Arrow fixed) {
		if ((y < (fixed.y + fixed.length)) && ((y + length) > fixed.y)) {
			return true;
			
		}
		return false;
	}
}
