package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Field;
import model.Vehicle;

public class Main extends Application{
	
	static public Field gridpane = new Field();
	Scene scene = new Scene (gridpane, 400, 400);
	
	public static void main(String[] args) throws Exception {
		Vehicle veh = new Vehicle(10, "TwojaStara");
		String test = gridpane.findTile(3).tileColor;
		System.out.println(test);
		launch(args);
		
		
	}
	
	 @Override
	    public void start(Stage stage) throws Exception{
	        try {
	        	stage.setScene(scene);
	        	stage.show();
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	 }
}
