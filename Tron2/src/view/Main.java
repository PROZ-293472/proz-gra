package view;

import java.util.Random;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Field;

public class Main extends Application {

	public static void main(String[] args) throws Exception {

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {

			// Parent root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
			Field field = new Field();
			Scene scene = new Scene(field, 400, 400);
			stage.setScene(scene);
			stage.show();
			GameController gameplay = new GameController(scene, field, Color.CRIMSON, Color.DARKBLUE, "Red", "Blue");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
