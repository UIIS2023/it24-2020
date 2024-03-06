package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Moveable, Comparable, Cloneable, Serializable{

	protected boolean selected;
	private Color insideColor;
	private Color color;
	
	public Shape() {
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
