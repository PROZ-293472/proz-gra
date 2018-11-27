package model;

import javafx.scene.input.KeyEvent;

public class Vehicle {

	private int position;
	private int lastPosition;
	public String vehColor;
	public String vehName;

	public Vehicle(int pos, String col, String name) {
		this.position = pos;
		this.vehColor = col;
		this.vehName = name;
	}

	public int getPosition() {
		return this.position;
	}
	
	
	//trzeba skumaæ, ¿eby nie móg³ jechaæ do ty³u
	public void move(KeyEvent key) {
		lastPosition = position;

		// ROGI
		if (this.position == 0) {
			switch (key.getCharacter().toLowerCase()) {
			case "s":
				this.position += 20;
				break;
			case "d":
				this.position += 1;
				break;
			}
		}

		else if (this.position == 19) {
			switch (key.getCharacter().toLowerCase()) {
			case "s":
				this.position += 20;
				break;
			case "a":
				this.position -= 1;
				break;
			}
		}

		else if (this.position == 380) {
			switch (key.getCharacter().toLowerCase()) {
			case "w":
				this.position -= 20;
				break;
			case "d":
				this.position += 1;
				break;
			}
		}

		else if (this.position == 399) {
			switch (key.getCharacter().toLowerCase()) {
			case "w":
				this.position -= 20;
				break;
			case "a":
				this.position -= 1;
				break;
			}
		}

		// BOKI
		else if (this.position > 0 && this.position < 19) {
			switch (key.getCharacter().toLowerCase()) {
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

		else if (this.position % 20 == 0 && this.position != 0 && this.position != 380) {
			switch (key.getCharacter().toLowerCase()) {
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

		else if (this.position > 380 && this.position < 399) {
			switch (key.getCharacter().toLowerCase()) {
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

		else if (this.position % 20 == 19 && this.position != 19 && this.position != 399) {


			switch (key.getCharacter().toLowerCase()) {
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
		//WNÊTRZE
		else {
			switch (key.getCharacter().toLowerCase()) {
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
