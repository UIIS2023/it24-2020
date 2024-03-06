package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Rectangle extends Shape {

	private Point upperLeftPoint = new Point();
	private int width;
	private int height;
//	private Color color;
//	private Color insideColor = Color.LIGHT_GRAY;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);

	}

	public int area() {
		return this.height * this.width;
	}

	public int circumference() {
		return this.height * 2 + 2 * this.width;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {

			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		if (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width && y >= upperLeftPoint.getY()
				&& y <= upperLeftPoint.getY() + height)
			return true;
		return false;
	}

	public boolean contains(Point p) {
		if (p.getX() >= upperLeftPoint.getX() && p.getX() <= upperLeftPoint.getX() + width
				&& p.getY() >= upperLeftPoint.getY() && p.getY() <= upperLeftPoint.getY() + height)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics g) {
//		if (upperLeftPoint != null) {
//			g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
//		}
//		if (getInsideColor() != Color.LIGHT_GRAY) {
//			g.setColor(getInsideColor());
//			g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
//		}
		g.setColor(getInsideColor());
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

		
		if (!selected) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLUE);
		}
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}

	}

	@Override
	public Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle) super.clone();
		
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);

	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}
		return 0;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) throws Exception{
		if(upperLeftPoint.getX() < 0 || upperLeftPoint.getY() < 0) {
			throw new Exception("The values of coordinates must be positive!");
		} 
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) throws Exception {

		if (width < 0) {
			throw new Exception("The value of width must be positive number!");
		}
		this.width = width;

	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) throws Exception {

		if (height < 0) {
			throw new Exception("The value of height must be positive number!");
		}
		this.height = height;

	}

	public String toString() {
		return "Rectangle: (" + upperLeftPoint.getX() + "," + upperLeftPoint.getY() + "), " + " width = " + width + 
							", height =" + " " + height + ", edge color: "+ getColor().toString().substring(14) + 
							", inside color: " + getInsideColor().toString().substring(14);
	}

	public void setUpperLeftPoint(int parseInt, int parseInt2) {
		try {
			this.setUpperLeftPoint(new Point(parseInt, parseInt2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

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
