package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

/**
 * Object to represent the player.
 * 
 * @author Yuluka Gigante
 */
public class Snake {
	private Image skin;
	
	private int length;
	
	private int x,y;

	public Snake() {
		setSkin();
	}

	public Image getSkin() {
		return skin;
	}

	private void setSkin() {
		File f = new File("src/images/Player.png");
		
		try {
			this.skin = new Image(new FileInputStream(f));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			System.out.println("Skin not found");
		}
	}
	
	/**
	 * Changes the player's X position by the distance received.
	 * 
	 * @param movementDistance the distance to move the player.
	 */
	public void moveXBy(int movementDistance) {
		x += movementDistance;
	}
	
	/**
	 * Changes the player's Y position by the distance received.
	 * 
	 * @param movementDistance the distance to move the player.
	 */
	public void moveYBy(int movementDistance) {
		y += movementDistance;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
