package command;

import java.util.ListIterator;

import geometry.Shape;
import mvc.DrawingModel;

public class FrontBack implements Command{

	private DrawingModel model;
	private Shape shape;
	
	private int oldIndex;
	private int newIndex;
	private int index = -1;
	
	public FrontBack (DrawingModel model, int oldIndex, int newIndex) {
		this.model = model;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
		
	}
	
	@Override
	public void execute() {
		index = oldIndex;
		Shape shape = model.getShape(index);
		model.remove(shape);
		model.add(newIndex, shape);
		
		oldIndex = newIndex;
	}

	@Override
	public void unexecute() {
		Shape shape = model.getShape(oldIndex);
		oldIndex = index;
		model.remove(shape);
		model.add(index, shape);
	}

}
