package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

/**
 * Class to control the main window of the game.
 * 
 * @author Yuluka Gigante
 */
public class MainWindow implements Initializable {
    @FXML
    private Pane MAIN_PANE;

    @FXML
    private Canvas CANVAS;
    
    @FXML
    private Label L_BORDER;

    @FXML
    private Label D_BORDER;

    @FXML
    private Label R_BORDER;

    @FXML
    private Label U_BORDER;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		paintBackground();
	}
	
	/**
	 * Paints the background of the screen with blue.
	 */
	private void paintBackground() {
		MAIN_PANE.setStyle("-fx-background-color: cyan");
	}
	
}
