package command;

import geometry.Point;
import geometry.Rectangle;

public class UpdateRectangle implements Command {

	private Rectangle oldR;
	private Rectangle newR;
	private Rectangle original;

	public UpdateRectangle(Rectangle oldRectangle, Rectangle newRectangle) {
		this.oldR = oldRectangle;
		this.newR = newRectangle;
	}

	@Override
	public void execute() {

		try {
			original = oldR.clone();
		} catch (CloneNotSupportedException e2) {
			e2.printStackTrace();
		}

		try {
			oldR.setUpperLeftPoint(newR.getUpperLeftPoint());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			oldR.setHeight(newR.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldR.setWidth(newR.getWidth());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldR.setColor(newR.getColor());
		oldR.setInsideColor(newR.getInsideColor());
		//oldR.setSelected(false);

	}

	@Override
	public void unexecute() {
		
		try {
			oldR.setUpperLeftPoint(original.getUpperLeftPoint());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			oldR.setHeight(original.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldR.setWidth(original.getWidth());
		} catch (Exception e) {
			e.printStackTrace();
		}

		oldR.setColor(original.getColor());
		oldR.setInsideColor(original.getInsideColor());
	}
}
