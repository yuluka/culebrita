package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
		Parent root = loader.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.show();
		
		st.setResizable(false);

//		When I try to set the resizable property to false, the stage gets the wrong sizes.
//		So I got the sizes by test and error xdn't 'cause I couldn't by no other way.
		st.setWidth(622);
		st.setHeight(470);
	}

}
