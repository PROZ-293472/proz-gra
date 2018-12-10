package model;

import javafx.scene.paint.Paint;

public class Vehicle {

	private int position;
	private int lastPosition = 0;
	public String vehName;
	public Paint vehColor;

	public Vehicle(int pos, Paint col, String name) {
		this.position = pos;
		this.vehColor = col;
		this.vehName = name;
	}

	public int getPosition() {
		return this.position;
	}

	
	public void move(String key) { 

		if (key.equals("super")) {
			if (this.position - this.lastPosition >= 20)
				this.position += 40;
			if (this.position - this.lastPosition <= -20)
				this.position -= 40;
			if (this.position - this.lastPosition == 1 || this.position - this.lastPosition == 2)
				this.position += 2;
			if (this.position - this.lastPosition == -1 || this.position - this.lastPosition == -2)
				this.position -= 2;

		}

		this.lastPosition = this.position;

		// ROGI
		if (this.position == 1) {
			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "d":
				this.position += 1;
				break;
			}
		}

		else if (this.position == 20) {
			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "a":
				this.position -= 1;
				break;
			}
		}

		else if (this.position == 381) {
			switch (key) {
			case "w":
				this.position -= 20;
				break;
			case "d":
				this.position += 1;
				break;
			}
		}

		else if (this.position == 400) {
			switch (key) {
			case "w":
				this.position -= 20;
				break;
			case "a":
				this.position -= 1;
				break;
			}
		}

		// BOKI
		else if (this.position > 1 && this.position < 20) {
			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "d":
				if (this.position + 1 == this.lastPosition)
					break;
				else {
					this.position += 1;
					break;
				}
			case "a":
				if (this.position - 1 == this.lastPosition)
					break;
				else {
					this.position -= 1;
					break;
				}
			}
		}

		else if (this.position % 20 == 1 && this.position != 1 && this.position != 381) {
			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "d":
				if (this.position + 1 == this.lastPosition)
					break;
				else {
					this.position += 1;
					break;
				}
			case "w":
				if (this.position - 20 == this.lastPosition)
					break;
				else {
					this.position -= 20;
					break;
				}
			}
		}

		else if (this.position > 381 && this.position < 400) {
			switch (key) {
			case "w":
				this.position -= 20;
				break;
			case "d":
				if (this.position + 1 == this.lastPosition)
					break;
				else {
					this.position += 1;
					break;
				}
			case "a":
				if (this.position - 1 == this.lastPosition)
					break;
				else {
					this.position -= 1;
					break;
				}
			}
		}

		else if (this.position % 20 == 0 && this.position != 20 && this.position != 400) {

			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "a":
				if (this.position - 1 == this.lastPosition)
					break;
				else {
					this.position -= 1;
					break;
				}
			case "w":
				if (this.position - 20 == this.lastPosition)
					break;
				else {
					this.position -= 20;
					break;
				}
			}
		}
		// WNÊTRZE
		else {
			switch (key) {
			case "s":
				this.position += 20;
				break;
			case "a":
				if (this.position - 1 == this.lastPosition)
					break;
				else {
					this.position -= 1;
					break;
				}
			case "w":
				if (this.position - 20 == this.lastPosition)
					break;
				else {
					this.position -= 20;
					break;
				}
			case "d":
				if (this.position + 1 == this.lastPosition)
					break;
				else {
					this.position += 1;
					break;
				}
			}
		}

	}
}