package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	//public Color color;
	
	boolean cancel = true;

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
		// dolazi do promene nakon uvodjenja Shape
		// this.selected = selected;

	}
	

	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {

			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint)) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return (this.startPoint.distance(x, y) + this.endPoint.distance(x, y)) - length() <= 2;
	}

	@Override
	public void draw(Graphics g) {
		if (!selected) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLUE);
		}
		g.drawLine(this.startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());

		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX() - 2, startPoint.getY() - 2, 4, 4);
			g.drawRect(endPoint.getX() - 2, endPoint.getY() - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		// necemo implementirati

	}
	
	@Override
    public Line clone()
        throws CloneNotSupportedException
    {
        return (Line) super.clone();
    }

	@Override
	public void moveBy(int byX, int byY) {
		this.startPoint.moveBy(byX, byY);
		this.endPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}

	public void setStartPoint(Point startPoint) throws Exception{
		if(startPoint.getX() < 0 || startPoint.getY() < 0) {
			throw new Exception("The values of coordinates must be positive!");
		}
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) throws Exception{
		if(endPoint.getX() < 0 || endPoint.getY() < 0) {
			throw new Exception("The values of coordinates must be positive!");
		} 
		this.endPoint = endPoint;
	}

	public String toString() {
		return "Line: (" + startPoint.getX() + "," + startPoint.getY()+ "),"
				+ " (" + endPoint.getX() + "," + endPoint.getY()+ ") color: "+ getColor().toString().substring(14);
	}


//	public Color getColor() {
//		return color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	
	
}
