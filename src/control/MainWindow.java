package control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Snake;
import javafx.fxml.Initializable;

/**
 * Class to control the main window of the game.
 * 
 * @author Yuluka Gigante
 */
public class MainWindow implements Initializable {
	
	private final int BORDERSIZE = 15;

	private static final int MOVEMENT_DISTANCE = 35;
	
//	Screen game.
    @FXML
    private Pane MAIN_PANE;
    
    private GraphicsContext gc;

    @FXML
    private Canvas CANVAS;
    
//  Screen borders.
    private Label L_BORDER;

    private Label D_BORDER;

    private Label R_BORDER;

    private Label U_BORDER;
    
//	Player
    private Snake player;
    
    private boolean keyUp = false;
	private boolean keyLeft = false;
	private boolean keyDown = false;
	private boolean keyRight = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = CANVAS.getGraphicsContext2D();
		CANVAS.setFocusTraversable(true);
		
		paintBackground();
		
		paintBorders();
		
		createPlayer();
	}
	
	/**
	 * Paints the background of the screen with blue.
	 */
	private void paintBackground() {
		MAIN_PANE.setStyle("-fx-background-color: cyan");
	}
	
	/**
	 * Paints the borders of the game screen.
	 */
	private void paintBorders() {
		Label rightBorder = new Label();
		
		rightBorder.relocate(MAIN_PANE.getPrefWidth()-BORDERSIZE, 0);
		
		rightBorder.setPrefHeight(MAIN_PANE.getPrefHeight());
		rightBorder.setPrefWidth(BORDERSIZE);
		
		Background bg = new Background(new BackgroundFill(Color.BLACK, null, null));
		rightBorder.setBackground(bg);
		
		MAIN_PANE.getChildren().add(rightBorder);
		
		this.R_BORDER = rightBorder;
		
		Label leftBorder = new Label();
		
		leftBorder.relocate(0, 0);
		
		leftBorder.setPrefHeight(MAIN_PANE.getPrefHeight());
		leftBorder.setPrefWidth(BORDERSIZE);
		
		leftBorder.setBackground(bg);
		
		MAIN_PANE.getChildren().add(leftBorder);
		
		this.L_BORDER = leftBorder;
		
		Label downBorder = new Label();
		
		downBorder.relocate(0, MAIN_PANE.getPrefHeight()-BORDERSIZE);
		
		downBorder.setPrefHeight(BORDERSIZE);
		downBorder.setPrefWidth(MAIN_PANE.getPrefWidth());
		
		downBorder.setBackground(bg);
		
		MAIN_PANE.getChildren().add(downBorder);
		
		this.D_BORDER = downBorder;
		
		Label upBorder = new Label();
		
		upBorder.relocate(0,0);
		
		upBorder.setPrefHeight(BORDERSIZE);
		upBorder.setPrefWidth(MAIN_PANE.getPrefWidth());
		
		upBorder.setBackground(bg);
		
		MAIN_PANE.getChildren().add(upBorder);
		
		this.U_BORDER = upBorder;
	}
	
	/**
	 * Creates the player and positions it in the game screen, respecting the 
	 * edges of the game screen.
	 */
	private void createPlayer() {
		this.player = new Snake();
		
		int x = new Random().nextInt((int) CANVAS.getWidth() - (int) R_BORDER.getWidth() 
				- (int) player.getSkin().getWidth()) + (int) L_BORDER.getWidth();
		int y = new Random().nextInt((int) CANVAS.getHeight() - (int) D_BORDER.getHeight() 
				- (int) player.getSkin().getHeight()) + (int) U_BORDER.getHeight();
		
		player.setX(x);
		player.setY(y);
		
		paintPlayer();
	}
	
	/**
	 * Paints the player skin in the game screen.
	 */
	private void paintPlayer() {
		gc.drawImage(player.getSkin(), player.getX(), player.getY());
	}
	
	/**
	 * Establishes which key, of the allowed keys, has been pressed.
	 * Only the last key pressed can have a true value, because the idea is that the 
	 * player moves in only one direction
	 * 
	 * @param event the key pressed by the user.
	 */
    @FXML
    void onKeyPressed(KeyEvent event) {
    	keyUp = false;
    	keyDown = false;
		keyLeft = false;
		keyRight = false;
    	
    	if(event.getCode().equals(KeyCode.UP)) {
    		keyUp = true;
    	} else if(event.getCode().equals(KeyCode.DOWN)) {
    		keyDown = true;
    	} else if(event.getCode().equals(KeyCode.LEFT)) {
    		keyLeft = true;
    	} else if(event.getCode().equals(KeyCode.RIGHT)) {
    		keyRight = true;
    	}
    	
    	makeKeyPressedActions();
    }
    
    /**
     * Performs the pertinent actions from the key pressed.
     */
    private void makeKeyPressedActions() {
		if(keyUp) {
			movePlayer('U');
		} else if(keyDown) {
			movePlayer('D');
		} else if(keyRight) {
			movePlayer('R');
		} else if(keyLeft) {
			movePlayer('L');
		}
	}
    
    /**
     * Receives a direction and moves the player in this one.
     * 
     * @param direction the direction to move the player.
     */
    private void movePlayer(char direction) {
    	gc.clearRect(player.getX(), player.getY(), player.getSkin().getWidth(), player.getSkin().getHeight());
    	
    	if(direction == 'U') {
    		player.moveYBy(-MOVEMENT_DISTANCE);
    	} else if(direction == 'D') {
    		player.moveYBy(MOVEMENT_DISTANCE);
    	} else if(direction == 'L') {
    		player.moveXBy(-MOVEMENT_DISTANCE);
    	} else if(direction == 'R') {
    		player.moveXBy(MOVEMENT_DISTANCE);
    	}
    	
    	paintPlayer();
	}
}
