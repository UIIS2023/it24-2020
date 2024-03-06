package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	//private Color color = Color.black;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		setColor(c);
	}

	public Point(int x, int y, boolean selected) {
		// this.x=x;
		// this.y=y;
		this(x, y);
		this.selected = selected;

		
		// dolazi do promene nakon uvodjenja Shape
		// this.selected = selected;
	}

	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {

			Point pomocna = (Point) obj;
			if (this.x == pomocna.x && this.y == pomocna.y) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	@Override
	public void draw(Graphics g) {
		if (!selected) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLUE);
		}
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);

		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x - 2, y - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;

	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point) o).distance(0, 0));
		}

		return 0;
	}
	
	@Override
    public Point clone()
        throws CloneNotSupportedException
    {
        return (Point) super.clone();
    }



	public void setX(int x) throws Exception{
		if (x <= 0) {
			throw new Exception("The values of coordinates must be positive!");
		}
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y)throws Exception{
		if (y <= 0) {
			throw new Exception("The values of coordinates must be positive!");
		}
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public String toString() {
		return "Point: (" + x + "," + y + "), color: "+ getColor().toString().substring(14);
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
	

}
