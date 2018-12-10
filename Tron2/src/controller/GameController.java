package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import model.Field;
import model.Vehicle;

public class GameController {
	public Field field = new Field();
	public Vehicle player1, player2;
	static Producer producer;
	Consumer consumer;
	

	private enum EndGame {
		YES, NO
	}

	public enum WhoseTurn {
		RED, BLUE
	}

	public WhoseTurn whoseTurn = WhoseTurn.RED;
	EndGame endGame;
	
	int i = 0;

	// C O N S T R U C T O R
	// public GameController() {};
	public GameController(Scene scene, Field fld, Paint colA, Paint colB, String nameA, String nameB) {
		this.field = fld;
		this.field.clear();
		this.endGame = EndGame.NO;
		try {
			producer = new Producer("localhost:4848/jms", "producerQueue");
		} catch (JMSException e) {
			showAlert("Problem with server connection!");
		}
		producer.sendQueueMessage(nameA);
		try {
			consumer = new Consumer("localhost:4848/jms", "consumerQueue");
		} catch (JMSException e) {
			showAlert("Problem with server connection!");
		}
		consumer.getJMSConsumer().setMessageListener(new MsgListener());

		// I N I T I A L I Z E
		int posA = new Random().nextInt(400);
		int posB = new Random().nextInt(400);
		while (posB == posA) {
			posB = new Random().nextInt(400);
		}
		this.player1 = new Vehicle(posA, colA, nameA);
		this.player2 = new Vehicle(posB, colB, nameB);

		this.showAlert(
				"Instructions: \n Move: arrows \n Jump: spacebar (you can't  jump twice in a row, idk, some bug, but it makes it only more interesting) \n Don't get killed");

		while (true) {
			if (this.whoseTurn.equals(WhoseTurn.RED))
			this.turn(scene, this.player1);

			if (this.whoseTurn.equals(WhoseTurn.BLUE))
				this.turn(scene, this.player2);
		}
	}

	private class MsgListener implements MessageListener {

		@Override
		public void onMessage(Message message) {
			if (message instanceof TextMessage) {
				/*
				 * try { String position = ((TextMessage) message).getText(); letsGo(player2, )
				 * }catch(JMSException) {
				 * 
				 * }
				 */
			}
		}
	}

	public void showAlert(String communicate) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("!");
		alert.setHeaderText(null);
		alert.setContentText(communicate);
		alert.showAndWait();
	}

	private void letsGo(Vehicle player, String key) {

		player.move(key);
		System.out.println(player.getPosition());

		try {
			if (this.field.findTile(player.getPosition()).isColored()) {
				this.endGame = EndGame.YES;
				showAlert(player.vehName + " przegrywa!");
			} else {
				// System.out.println("letsGoDziala");
				update(player);
				if(whoseTurn.equals(WhoseTurn.RED)) whoseTurn = WhoseTurn.BLUE;
				if(whoseTurn.equals(WhoseTurn.BLUE)) whoseTurn = WhoseTurn.RED;
			}
		} catch (Exception e) {
			System.out.println("bladletsGo");
		}

	}

	/*----------TUTAJ NIE DZIALA----------*/

	// TODO: mozna wcisnac klawisz tylko raz na ture
	public void turn(Scene scene, Vehicle player) {
		i = 0;

		if (endGame.equals(EndGame.YES)) {
			endGame = EndGame.NO;
			field.clear();
		}

		update(player);

		showAlert("Now playing: " + player.vehName);

		List<KeyEvent> listOfKeys = new ArrayList<KeyEvent>();

		// nie dziala
		// while (listOfKeys.isEmpty()) {

		scene.setOnKeyPressed(event -> {
			if (i < 1) {
				if (!(convertKey(event).equals("notValid"))) {
					letsGo(player, convertKey(event));
				}
				listOfKeys.add(event);
				i++;
			}

		});

		// }
		/*
		 * try { System.in.read(); } catch (Exception e) {
		 * System.out.println("INPUT NIE DZIALA"); }
		 */

	}

	// P O M O C N I C Z E

	private void update(Vehicle player) {
		try {
			field.findTile(player.getPosition()).setColor(player.vehColor);
			// System.out.println("UpdateDziala");
		} catch (Exception e) {
			System.out.println("bladUpdate");
		}

	}

	private String convertKey(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
			return "w";
		case DOWN:
			return "s";
		case RIGHT:
			return "d";
		case LEFT:
			return "a";
		case SPACE:
			return "super";

		default:
			return "notValid";
		}
	}

}
