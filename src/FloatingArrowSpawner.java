import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

//to randomly produce arrows, and display them as they move
public class FloatingArrowSpawner {
	
	float x, y;
	PApplet window;
	PImage left, down, up, right;
	ArrayList<Arrow> leftArrows, downArrows, upArrows, rightArrows, stationaryArrows;
	
	public FloatingArrowSpawner(PApplet window, float x, float y) {
		this.x = x;
		this.y = y;
		this.window = window;
		
		left = window.loadImage("VIDUSHI://JavaVidushi//leftArrow.png");
		down = window.loadImage("VIDUSHI://JavaVidushi//downArrow.png");
		up = window.loadImage("VIDUSHI://JavaVidushi//upArrow.png");
		right = window.loadImage("VIDUSHI://JavaVidushi//rightArrow.png");
		
		leftArrows = new ArrayList<Arrow>();
		downArrows = new ArrayList<Arrow>();
		upArrows = new ArrayList<Arrow>();
		rightArrows = new ArrayList<Arrow>();
		stationaryArrows = new ArrayList<Arrow>();
		
		stationaryArrows.add(new Arrow(40, 40, 0));
		stationaryArrows.add(new Arrow(180, 40, 0));
		stationaryArrows.add(new Arrow(320, 40, 0));
		stationaryArrows.add(new Arrow(460, 40, 0));
	}
	
	public void addArrow() {
		int direction = (int)(Math.random()*4);
		if (direction == 0) {
			Arrow newArrow = new Arrow(40, 600, 5);
			leftArrows.add(newArrow);
		} else if (direction == 1) {
			Arrow newArrow = new Arrow(180, 600, 5);
			downArrows.add(newArrow);
		} else if (direction == 2) {
			Arrow newArrow = new Arrow(320, 600, 5);
			upArrows.add(newArrow);
		} else if (direction == 3) {
			Arrow newArrow = new Arrow(460, 600, 5);
			rightArrows.add(newArrow);
		}
	}
	
	public void drawAll() {
		draw(leftArrows, 0);
		draw(downArrows, 1);
		draw(upArrows, 2);
		draw(rightArrows, 3);
		drawStationaryArrows();
	}
	
	public void draw(ArrayList<Arrow> arrows, int direction) {
		for(int i = 0; i < arrows.size(); i++) {
			Arrow arrow = arrows.get(i);
			if (direction == 0) window.image(left, arrow.x, arrow.y, 100, 100);
			if (direction == 1) window.image(down, arrow.x, arrow.y, 100, 100);
			if (direction == 2) window.image(up, arrow.x, arrow.y, 100, 100);
			if (direction == 3) window.image(right, arrow.x, arrow.y, 100, 100);
			arrow.move();
			arrow.checkIfDead();
			if (!arrow.isAlive()) arrows.remove(arrow);
		}
	}
	
	public void drawStationaryArrows() {
		for(int i = 0; i < stationaryArrows.size(); i++) {
			Arrow arrow = stationaryArrows.get(i);
			if (i == 0) window.image(left, arrow.x, arrow.y, 100, 100);
			if (i == 1) window.image(down, arrow.x, arrow.y, 100, 100);
			if (i == 2) window.image(up, arrow.x, arrow.y, 100, 100);
			if (i == 3) window.image(right, arrow.x, arrow.y, 100, 100);
		}
	}
	
	public boolean checkIfHitting(int direction) {
		if (direction == 0) {
			Arrow leftArrow = stationaryArrows.get(direction);
			for (int i = 0; i < leftArrows.size(); i++) {
				Arrow arrow = leftArrows.get(i);
				if (arrow.isHitting(leftArrow) && arrow.isHit == false) {
					arrow.isHit = true;
					return true;
				}
			}
		}
		
		if (direction == 1) {
			Arrow downArrow = stationaryArrows.get(direction);
			for (int i = 0; i < downArrows.size(); i++) {
				Arrow arrow = downArrows.get(i);
				if (arrow.isHitting(downArrow) && arrow.isHit == false) {
					arrow.isHit = true;
					return true;
				}
			}
		}
		if (direction == 2) {
			Arrow upArrow = stationaryArrows.get(direction);
			for (int i = 0; i < upArrows.size(); i++) {
				Arrow arrow = upArrows.get(i);
				if (arrow.isHitting(upArrow) && arrow.isHit == false) {
					arrow.isHit = true;
					return true;
				}
			}
		}
		if (direction == 3) {
			Arrow rightArrow = stationaryArrows.get(direction);
			for (int i = 0; i < rightArrows.size(); i++) {
				Arrow arrow = rightArrows.get(i);
				if (arrow.isHitting(rightArrow) && arrow.isHit == false) {
					arrow.isHit = true;
					return true;
				}
			}
		}
		return false;
	}
}
