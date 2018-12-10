package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Visuals {
	public void setBorder(Canvas c) {
		c.setHeight(20);
		c.setWidth(20);
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.moveTo(0, 0);
		gc.lineTo(0, 19);
		gc.lineTo(19, 19);
		gc.lineTo(19, 0);
		gc.lineTo(0, 0);
		gc.stroke();
	}

	public void fill(Canvas c, Paint p) {
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.setFill(p);
		gc.fill();
	}
}
