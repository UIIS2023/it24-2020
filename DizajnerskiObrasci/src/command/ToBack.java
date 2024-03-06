package command;

import geometry.Shape;
import mvc.DrawingModel;

public class ToBack implements Command {

	private DrawingModel model;
	
	private int oldIndex;
	private int newIndex;
	private int index = -1;
	
	public ToBack (DrawingModel model, int oldIndex, int newIndex) {
		this.model = model;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
	}
	
	@Override
	public void execute() {
		index = oldIndex;
		Shape shape1 = model.getShape(index);
		Shape shape2 = model.getShape(newIndex);
		model.remove(shape1);
		model.remove(shape2);
		Shape temporary;
		temporary = shape1;
		shape1 = shape2;
		shape2 = temporary;
		model.add(newIndex, shape2);
		model.add(index, shape1);
		
		oldIndex = newIndex;

	}

	@Override
	public void unexecute() {
		Shape shape1 = model.getShape(index);
		Shape shape2 = model.getShape(index-1);
		model.remove(shape1);
		model.remove(shape2);
		oldIndex = index;
		
		Shape temporary;
		temporary = shape1;
		shape1 = shape2;
		shape2 = temporary;
		model.add(newIndex, shape2);
		model.add(index, shape1);
	}

}
