package command;

import javax.swing.JOptionPane;

import geometry.Line;
import geometry.Point;

public class UpdateLine implements Command {

	private Line oldL;
	private Line newL;
	private Line original = new Line(new Point(0, 0), new Point(0, 0));

	public UpdateLine(Line oldLine, Line newLine) {
		this.oldL = oldLine;
		this.newL = newLine;
	}

	@Override
	public void execute() {
		try {
			original = oldL.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		
		try {
			oldL.setStartPoint(newL.getStartPoint());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldL.setEndPoint(newL.getEndPoint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		oldL.setColor(newL.getColor());
		//oldL.setSelected(false);
	}

	@Override
	public void unexecute() {
		try {
			oldL.setStartPoint(original.getStartPoint());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			oldL.setEndPoint(original.getEndPoint());
		} catch (Exception e) {
			e.printStackTrace();
		}

		oldL.setColor(original.getColor());

	}

}
