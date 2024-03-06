package command;

import geometry.Circle;
import geometry.Point;

public class UpdateCircle implements Command {

	private Circle oldCircle;
	private Circle newCircle;
	private Circle original = new Circle(new Point(0,0), 0);
	
	public UpdateCircle(Circle oldCircle, Circle newCircle) {
		this.oldCircle = oldCircle;
		this.newCircle = newCircle;
	}
	
	@Override
	public void execute() {
		try {
			original = oldCircle.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	
	try {
		oldCircle.setCenter(newCircle.getCenter());
	} catch (Exception e1) {
		e1.printStackTrace();
	}
		try {
			oldCircle.setRadius(newCircle.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldCircle.setColor(newCircle.getColor());
		oldCircle.setInsideColor(newCircle.getInsideColor());
	}

	@Override
	public void unexecute() {
		try {
			oldCircle.setCenter(original.getCenter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			oldCircle.setRadius(original.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldCircle.setColor(original.getColor());
		oldCircle.setInsideColor(original.getInsideColor());
	}

}
