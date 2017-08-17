import processing.core.PApplet;
import processing.core.PImage;


public class StationaryArrowDisplay {
	
	PApplet window;
	float x, y;
	Arrow leftArrow, downArrow, upArrow, rightArrow;
	PImage left, down, up, right;
	
	public StationaryArrowDisplay(PApplet window, float x, float y) {
		
		this.x = x;
		this.y = y;
		this.window = window;
		
		leftArrow = new Arrow(40, 40, 0);
		downArrow = new Arrow(180, 40, 0);
		upArrow = new Arrow(320, 40, 0);
		rightArrow = new Arrow(460, 40, 0);
		
		left = window.loadImage("D://Java//leftArrow.png");
		left.resize(100, 100);
		down = window.loadImage("D://Java//downArrow.png");
		down.resize(100, 100);
		up = window.loadImage("D://Java//upArrow.png");
		up.resize(100, 100);
		right = window.loadImage("D://Java//rightArrow.png");
		right.resize(100, 100);
	}
	
	public void drawArrows() {
		window.image(left, leftArrow.x, leftArrow.y, 100, 100);
	}
}
