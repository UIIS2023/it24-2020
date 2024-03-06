package command;

import geometry.Donut;
import geometry.Point;

public class UpdateDonut implements Command {
	private Donut oldD;
	private Donut newD;
	private Donut original = new Donut(new Point(0,0), 1, 0);
	
	public UpdateDonut(Donut oldDonut, Donut newDonut) {
		this.oldD = oldDonut;
		this.newD = newDonut;
	}
	
	@Override
	public void execute() {
		try {
			original = oldD.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
		try {
			oldD.setCenter(newD.getCenter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			oldD.setRadius(newD.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldD.setInnerRadius(newD.getInnerRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldD.setColor(newD.getColor());
		oldD.setInsideColor(newD.getInsideColor());
		//oldD.setSelected(false);
	}

	@Override
	public void unexecute() {
		try {
			oldD.setCenter(original.getCenter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			oldD.setRadius(original.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldD.setInnerRadius(original.getInnerRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldD.setColor(original.getColor());
		oldD.setInsideColor(original.getInsideColor());
	}
}
