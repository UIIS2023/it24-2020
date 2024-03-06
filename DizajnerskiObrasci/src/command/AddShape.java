package command;

import geometry.Shape;
import mvc.DrawingModel;

public class AddShape implements Command  {
	
	private DrawingModel model;
	private Shape shape;
	

	public AddShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		
		model.add(shape);
		if(shape.isSelected()) {
			model.addSel(shape);
		}
		System.out.println(model.getLstSelectedShapes().size());
		System.out.println(shape.isSelected());
	}

	@Override
	public void unexecute() {
		
		model.remove(shape);
	
		if(shape.isSelected()) {
			model.removeSel(shape);
		}
		System.out.println(model.getLstSelectedShapes().size());
		System.out.println(shape.isSelected());


		
	}

}
