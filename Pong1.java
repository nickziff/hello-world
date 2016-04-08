package pong1;

import processing.core.PApplet;

import java.util.Random;

import processing.data.*;
public class Pong1 extends PApplet {
	

	
	//allows paddles and ping pong ball to move
	public float speed = 100;
	float ballx;
	float bally;
	float paddle1Y;
	float paddle2Y;
	float ballSpeedX = 10;
	float ballSpeedY = 10;

	int paddle1X = 1860;
	int paddle2X = 20;
	
	//creates movement 
	int score2 = 0;
	public boolean moveUp = false;
	public boolean moveDown = false;
	public boolean moving = false;
	public boolean start = false;
	int score1 = 0;
	
	
	//background
	public void setup() { 
		keyPressed();
		draw();		
		size(1280, 900);
		background(0, 0, 0);
		ballx = width/2;
		bally = height/2;
		ballBounceDown();
		singlePlayer();
	}
	//Creates ping pong ball, lines and paddles
	public void draw() {
		fill(0,0,0);
		rect(0,0,1900,900);
		fill(255,255, 255);
		rect(20, paddle1Y, 20, 200);
		fill(0,0,0);
		rect(1880,0,1900,900);
		fill(255,255, 255);
		rect(1260,paddle2Y, 20, 200);
		rect(width/2, 0, 10, 40);
		rect(width/2, 50, 10, 40);
		rect(width/2, 100, 10, 40);
		rect(width/2, 150, 10, 40);
		rect(width/2, 200, 10, 40);
		rect(width/2, 250, 10, 40);
		rect(width/2, 300, 10, 40);
		rect(width/2, 350, 10, 40);
		rect(width/2, 400, 10, 40);
		rect(width/2, 450, 10, 40);
		rect(width/2, 500, 10, 40);
		rect(width/2, 550, 10, 40);
		rect(width/2, 600, 10, 40);
		rect(width/2, 650, 10, 40);
		rect(width/2, 700, 10, 40);
		rect(width/2, 750, 10, 40);
		rect(width/2, 800, 10, 40);
		rect(width/2, 850, 10, 40);
		rect(width/2, 900, 10, 40);
		rect(width/2, 950, 10, 40);
		rect(width/2, 1000, 10, 40);
		ellipse(ballx, bally, 30, 30);
		ball();
		score();
		showScore();
		ballBounceUp();
		ballBounceDown();
		System.out.println(ballSpeedX + " " + ballSpeedY);
		bounce();
		
		
	
		}	
	
	
	//starts ball speed
	public void ball(){
		ballx += ballSpeedX;
		bally += ballSpeedY;
		
		}
	
	//bouncing off top wall
	public void ballBounceUp(){
		 if (bally > 700){
			ballSpeedY = -ballSpeedY;
			

		}
	}
	//bouncing off bottom wall
	public void ballBounceDown(){
		if (bally < 15){
			ballSpeedY = -ballSpeedY;
			
		}
	}
	

	
	public void keyPressed() {
		player1KeyPressed();
		player2KeyPressed();
		player1KeyReleased();
		player2KeyReleased();
	}
	
	//controls for player 1, pressed
	public void player1KeyPressed(){
		if((key == 's') && (paddle1Y < 700)) {
			paddle1Y += speed;
			moveDown = true;
			moving = true;
		} 
		else if((key == 'w') && (paddle1Y > 0)){
			paddle1Y -= speed;
			moveUp = true;
			moving = true;	
		}
		
	}
	
	// controls for player 1, released
	public void player1KeyReleased(){
		if((key == 's') && (paddle1Y < 700)) {
			moveDown = false;
			moving = false;
		} 
		else if((key == 'w') && (paddle1Y > 0)){
			moveUp = false;
			moving = false;
		}
	}
	public void player2KeyPressed(){
		if((key == 'i') && (paddle2Y > 0)){
			paddle2Y -= speed;
			moveUp = true;
			moving = true;
		}
		else if ((key == 'k') && (paddle2Y < 700)){
			paddle2Y += speed;
			moveDown = true;
			moving = true;
		}
		
				
	}
	public void player2KeyReleased(){
		if((key == 'i') && (paddle2Y > 0)){
			moveUp = false;
			moving = false;
		}
		else if ((key == 'k') && (paddle2Y < 700)){
			moveDown = false;
			moving = false;
		}
		
				
	}
		
		
	
	//Sets parameters for scoring / restarting
	public void score(){
		if(ballx < 0){
			text(score1++, 890, 0);
			ballx = width/2;
			bally = height/2;
			ballSpeedX = -10;
			ballSpeedY = -10;
		} else if (ballx > 1280){
			text(score2++, 970, 0);
			ballx = width/2;
			bally = height/2;
			ballSpeedX = 10;
			ballSpeedY = 10;
		} if(score1 == 10){
			textSize(50);
			text("Winner!", 750, 200);
			ballx = width/2;
			bally = height/2;
			ballSpeedX = 0;
			ballSpeedY = 0;
		} else if(score2 == 10){
			textSize(50);
			text("Winner!", 1000, 200);
			
			ballx = width/2;
			bally = height/2;
			ballSpeedX = 0;
			ballSpeedY = 0;
		} 
		
		if(key == 'b'){
			score1 = 0;
			score2 = 0;
			ballx = width/2;
			bally = height/2;
			ballSpeedX = 10;
			ballSpeedY = 10;
			ballx += ballSpeedX;
			bally += ballSpeedY;
			text("Player 1 Controls: W = Up", 500, 100);
			text("Player 2 Controls: I = Up", 1000, 100);
			text("S = Down", 750, 150);
			text("K = Down", 1250, 150);
			
		}
		
	}
		
	//shows score
	public void showScore() {
		fill(255, 255, 255);
		textSize(30);
		text(score2, width/2 - 20, 100);
		text(score1, width/2 + 20, 100);
	}
	//bouncing off paddles
	public void bounce(){
		if(((ballx >= 40) && (ballx <= 61)) && ((bally >= paddle1Y) && (bally <= (paddle1Y + 210)))){
			ballSpeedY = +ballSpeedY;
			ballSpeedX = -ballSpeedX;
		} else if (((bally >= paddle2Y) && (bally <= (paddle2Y + 210))) && ((ballx >= 1250) && (ballx <= 1280))){
			ballSpeedY = +ballSpeedY;
			ballSpeedX = -ballSpeedX;
		}
		
		//starts singleplayer mode BETA
	} public void singlePlayer(){
		if(key == 'v'){
			ballSpeedX -= .2;
			ballSpeedY += .2;
			ballx += ballSpeedX;
			bally += ballSpeedY;
		}
	}
	
	{

		

}
}
	
	