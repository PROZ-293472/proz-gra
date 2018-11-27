package model;

import javafx.scene.canvas.Canvas;


public class FieldTile extends Canvas{

	private static int staticId = 0;
	public final int id;
	public String tileColor;
	
	enum ColState {
		YES, NO
	};
	
	private ColState colState;
	
	public FieldTile() {
		super();
		staticId++;
		id= staticId;
		colState = ColState.NO;
	}
	
	public void setColor(String color) {
		tileColor = color;
		//trzeba skumac: jesli ustawiasz na bialy (kod bialego??) to colState = NO
		this.setStyle("-fx-background-color: "+color);
		this.colState = ColState.YES;
	}
	
	public void clearColor() { //trzeba wyznaczyc wartosc bialego
		tileColor = "bialy";
		this.setStyle("-fx-background-color: bialy");
		this.colState = ColState.NO;
	}
	
	public boolean  isColored() {
		if (colState.equals(ColState.YES)) return true;
	 return false;
	}
	

}
