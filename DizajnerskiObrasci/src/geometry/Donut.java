package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JOptionPane;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {

		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);

	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (this.center.equals(pomocni.center) && this.getRadius() == pomocni.getRadius()
					&& innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(int x, int y) {
		double dFromCenter = getCenter().distance(x, y);
		return dFromCenter > innerRadius && super.contains(x, y);
	}

	public boolean contains(Point p) {
		double dFromCenter = getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius && super.contains(p.getX(), p.getY());
	}

	@Override
	public void draw(Graphics g) {
//		super.draw(g);
//		if (getInsideColor() != Color.LIGHT_GRAY) {
//			g.setColor(Color.LIGHT_GRAY);
//			g.fillOval(center.getX() - innerRadius, center.getY() - innerRadius, innerRadius * 2, innerRadius * 2);
//			
//		}
		Ellipse2D innerEllipse = new Ellipse2D.Float(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		Ellipse2D outerEllipse = new Ellipse2D.Float(center.getX() - getRadius(), center.getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
		Area outerArea = new Area(outerEllipse);
		Area innerArea = new Area(innerEllipse);
		outerArea.subtract(innerArea);
		g.setColor(getInsideColor());
		((Graphics2D) g).fill(outerArea);

	
		if (!selected) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLUE);
		}
		// TODO Auto-generated method stub
		
		g.drawOval(center.getX() - getRadius(), center.getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, innerRadius * 2, innerRadius * 2);


		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - innerRadius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + innerRadius - 2, 4, 4);
			
			g.drawRect(center.getX() -  getRadius() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() +  getRadius() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() -  getRadius() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() +  getRadius() - 2, 4, 4);
		}

	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
	@Override
    public Donut clone()
        throws CloneNotSupportedException
    {
        return (Donut) super.clone();
    }

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) throws Exception {

		if (innerRadius < 0) {
			throw new Exception("The value of innerRadius must be positive!");
		}
		else if(innerRadius>= radius){
			
			throw new Exception("The value of radius must be must be larger than inner radius!");
		}
		this.innerRadius = innerRadius;

	}

	public String toString() {
		// Center=(x,y), radius= radius, innerRadius= innerRadius
		return "Donut: center = (" + center.getX()+ ", " + center.getY() + "), radius = " +
				radius + ", inner radius = " + innerRadius + ", edge color: " + getColor().toString().substring(14) +
				", inside color: " + getInsideColor().toString().substring(14);
	}
	
	

}
