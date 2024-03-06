package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Circle extends Shape {

	protected Point center;
	protected int radius;
	// Color color;
	// protected Color insideColor = Color.LIGHT_GRAY;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);

	}

	public Circle clone() throws CloneNotSupportedException {
		return (Circle) super.clone();
	}

	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	public double circumference() {
		return 2 * this.radius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if (this.center.equals(pomocni.center) && this.radius == pomocni.radius) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}

	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(getInsideColor());
		g.fillOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
		if (!selected) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLUE);
		}
		g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);

		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);

	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);

	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle) o).area());
		}
		return 0;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) throws Exception {
		if (center.getX() < 0 || center.getY() < 0) {
			throw new Exception("The values of coordinates must be positive!");
		}
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {

		if (radius < 0) {
			throw new Exception("The value of radius must be positive number!");
		}
		this.radius = radius;

	}

	public String toString() {
		// Center=(x,y), radius= radius
		return "Circle: center = (" + center.getX() +", " +center.getY()+")"+ ", radius = " + radius
				+", edge color: " + getColor().toString().substring(14) +", inside color: " 
				+ getInsideColor().toString().substring(14);
	}

//	public Color getColor() {
//		// TODO Auto-generated method stub
//		return this.color;
//
//	}
//
//	public void setColor(Color color) {
//		// TODO Auto-generated method stub
//		this.color = color;
//
//	}
//
//	public Color getInsideColor() {
//		// TODO Auto-generated method stub
//		return this.insideColor;
//
//	}
//
//	public void setInsideColor(Color color) {
//		// TODO Auto-generated method stub
//		this.insideColor = color;
//
//	}

}
