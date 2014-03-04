package GUI1_4;

import java.awt.Color;
import java.awt.Font;

public class Transfer {
	private Font font;
	private int fontSize;
	private Color charColor;
	private Color bgColor;

	private int height;
	private int width;

	public Transfer() {
		this.font = new Font("arial", Font.BOLD, 50);
		this.fontSize = 50;
		this.charColor = Color.BLACK;
		this.bgColor = Color.WHITE;
		this.height = 50;
		this.width = 235;
	}

	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public Color getCharColor() {
		return charColor;
	}
	public void setCharColor(Color charColor) {
		this.charColor = charColor;
	}
	public Color getBgColor() {
		return bgColor;
	}
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
	public void setWidthAndHeight(int fontSize){
		this.height = fontSize;
		this.width = (int) (this.height * 4.7);
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public Color toColor(String str) {
		if(str.equals("Black")) {
			return Color.black;
		} else if(str.equals("White")) {
			return Color.white;
		} else if(str.equals("Red")) {
			return Color.red;
		} else if(str.equals("Green")) {
			return Color.green;
		} else if(str.equals("Blue")) {
			return Color.blue;
		} else {
			return null;
		}
	}
	public String colorToStr(Color color) {
		if(color == Color.BLACK) {
			return "Black";
		} else if(color == Color.WHITE) {
			return "White";
		} else if(color == Color.RED) {
			return "Red";
		} else if(color == Color.GREEN) {
			return "Green";
		} else if(color == Color.BLUE) {
			return "Blue";
		} else {
			return null;
		}
	}
}
