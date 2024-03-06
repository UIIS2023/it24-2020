package adapter;

import java.awt.Color;
import java.awt.Graphics;

import geometry.Point;
import geometry.Shape;
import hexagon.Hexagon;

public class HexagonAdapter extends Shape {

	private Hexagon heksagon = new Hexagon(0, 0, 0);
	private Point center;

	private int radius;
	// Color color = Color.BLACK;
	protected Color insideColor = Color.WHITE;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) throws Exception {
		if (center.getX() < 0 || center.getY() < 0) {
			throw new Exception("The values of coordinates must be positive!");
		}
		heksagon.setX(center.getX());
		heksagon.setY(center.getY());
		this.center = center;

	}

	public int getRadius() {
		return heksagon.getR();
	}

	public void setRadius(int radius) throws Exception {

		if (radius < 0) {
			throw new Exception("The value of radius must be positive number!");
		}
		this.radius = radius;
		heksagon.setR(radius);
	}

	public HexagonAdapter() {

	}

	public HexagonAdapter(int x, int y, int radius) {
		super();
		this.heksagon = new Hexagon(x, y, radius);
		this.center = new Point(x, y);
		this.radius = radius;
	}

	@Override
	public void moveTo(int x, int y) {
		heksagon.setX(x);
		heksagon.setY(y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		heksagon.setX(heksagon.getX() + byX);
		heksagon.setX(heksagon.getY() + byY);

	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public HexagonAdapter clone() throws CloneNotSupportedException {
		return (HexagonAdapter) super.clone();
	}

	@Override
	public boolean contains(int x, int y) {
		return heksagon.doesContain(x, y);
	}

	public boolean contains(Point p) {
		return heksagon.doesContain(p.getX(), p.getY());
	}

	public void draw(Graphics g) {
		heksagon.setSelected(selected);
		if (insideColor != Color.LIGHT_GRAY) {
			heksagon.setAreaColor(getInsideColor());
		}
		if (!selected) {
			heksagon.setBorderColor(getColor());
		} else {
			heksagon.setBorderColor(Color.BLUE);
		}
		heksagon.paint(g);

	}

	@Override
	public String toString() {
		return "Hexagon: center = (" + center.getX() + ", " + center.getY() + ")" + ", radius = " + radius
				+ ", edge color: " + getColor().toString().substring(14) + ", inside color: "
				+ getInsideColor().toString().substring(14);
	}

}
