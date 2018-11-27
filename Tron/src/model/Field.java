package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class Field extends GridPane{

	private List<FieldTile> listOfTiles = new ArrayList<FieldTile>();

	public Field() {
		super();
		for (int i = 0; i < 20; i++) {
			for (int k = 0; k < 20; k++) {
				FieldTile tile = new FieldTile();
				listOfTiles.add(tile); 
				this.add(tile, i, k);
			}
		}
	}

	public FieldTile findTile(int tId) throws Exception {

		for (FieldTile tile : listOfTiles) {
			if (tile.id == tId)
				return tile;
		}
		Exception e = new Exception();
		throw e;

	}
	
	public void clear() {
		for (FieldTile tile : listOfTiles) {
			tile.clearColor();
		}
	}

}
