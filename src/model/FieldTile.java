package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import view.Visuals;


public class FieldTile extends Canvas{

	private static int staticId = 0;
	public final int id;
	Visuals visualCreator = new Visuals();
	
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
	
	public void setColor(Paint fillColor) { 
		visualCreator.fill(this, fillColor);
		this.colState = ColState.YES;
	}
	
	public void clearColor() { 
		visualCreator.fill(this, Color.WHITE);
		this.colState = ColState.NO;
	}
	
	public boolean  isColored() {
		if (this.colState.equals(ColState.YES)) return true;
	 return false;
	}

}
