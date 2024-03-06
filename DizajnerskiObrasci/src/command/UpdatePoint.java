package command;

import java.awt.Color;

import geometry.Point;

public class UpdatePoint implements Command, Cloneable{

	private Point oldP;
	private Point newP;
	private Point original = new Point();
	
	public UpdatePoint (Point oldPoint, Point newPoint) {
		this.oldP = oldPoint;
		this.newP = newPoint;
	}
	
	@Override
	public void execute() {
		try {
			original = oldP.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}	
		try {
			oldP.setX(newP.getX());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldP.setY(newP.getY());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldP.setColor(newP.getColor());
		//oldP.setSelected(false);
	}

	@Override
	public void unexecute() {
		try {
			oldP.setX(original.getX());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldP.setY(original.getY());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oldP.setColor(original.getColor());
		
	}

}
