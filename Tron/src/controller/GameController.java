package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import model.Field;
import model.Vehicle;

public class GameController {
	public Field field = new Field();
	public List<Vehicle> listOfPlayers = new ArrayList<Vehicle>();

	private enum EndGame {
		YES, NO
	}

	EndGame endGame;

	public GameController(int posA, int posB, String colA, String colB, String nameA, String nameB) {
		this.field.clear();
		Vehicle player1 = new Vehicle(posA, colA, nameA);
		Vehicle player2 = new Vehicle(posB, colB, nameB);
		listOfPlayers.add(player1);
		listOfPlayers.add(player2);
		this.endGame = EndGame.NO;

	}

	private void showAlert(String communicate) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("!");
		alert.setHeaderText(null);
		alert.setContentText(communicate);
		alert.showAndWait();
	}

	public void turn(Vehicle player, KeyEvent key) {
		showAlert("Now playing: " + player.vehName);
		player.move(key);
		try {
			if (this.field.findTile(player.getPosition()).isColored())
				this.endGame = EndGame.YES;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
