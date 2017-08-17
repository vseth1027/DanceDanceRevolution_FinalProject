//to run the actual game
import javazoom.jl.player.Player;
import processing.core.PApplet;
import processing.core.PFont;

public class DanceGame extends PApplet {
	
	FloatingArrowSpawner spawner;
	int score;
	int counter, rand, totalCounter;
	boolean gameOver;
	PFont scoreFont;
	int fontColor;
	MP3 mp3;
	String filename;

	
	public void setup() {
		size(600, 600);
		
		spawner = new FloatingArrowSpawner(this, 40, 600);
			
		score = 0;
		counter = 0;
		rand = 0;
		totalCounter = 0;
		gameOver = false;
		
		scoreFont = createFont("IMPACT", 32);
		textFont(scoreFont);
		fontColor = color(240, 128, 128);
		
		filename = "E://04 Vitamin C.mp3";
        mp3 = new MP3(filename);
        mp3.play();
	}
	
	public void draw() {
		if (mp3.player.isComplete() == false) { ////
			background(222);
			counter++;
			
			rand = (int)(Math.random()*400);
			totalCounter += rand;
			
			if (counter > rand) {
				counter = 0; 
				spawner.addArrow();
			}
			
			spawner.drawAll();
			
			
			//display score
			fill(fontColor);
			text("Score: " + score, 450, 550);
		}
		
		if(mp3.player.isComplete() == true) {		//fix code so that the end of the music is the end of the game
			gameOver = true;
			mp3.close();
			background(222);
			text("Game Over!\nYou scored " + score + " points.", 200, 200);
		}
		
	
	}
	
	public boolean isGameOver() {
		return gameOver;
		
	}

	public void keyReleased() {
		if (gameOver == false) {
			if (keyCode == LEFT) {
				if (spawner.checkIfHitting(0)) score += 10;
			}
			
			if (keyCode == DOWN) {
				if (spawner.checkIfHitting(1)) score += 10;
			}
			
			if (keyCode == UP) {
				if (spawner.checkIfHitting(2)) score += 10;
			}
			
			if (keyCode == RIGHT) {
				if (spawner.checkIfHitting(3)) score += 10;
			}
		}
	}
}
