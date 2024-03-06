package command;

import geometry.Shape;
import mvc.DrawingModel;

public class DeleteShape implements Command{
	
	private DrawingModel model;
	private Shape shape;
	
	

	public DeleteShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.remove();
		
	}

	@Override
	public void unexecute() {
		model.add(shape);
		
	}

}
