package command;

import java.util.HashMap;
import java.util.List;

import geometry.Shape;
import mvc.DrawingModel;

public class RemoveShape implements Command {

	private DrawingModel model;
	private Shape shape;
	private List<Shape> deleteList;
	private HashMap<Integer, Shape> map = new HashMap<>();

	public RemoveShape(DrawingModel model, List<Shape> deleteList) {
		this.model = model;
		this.deleteList = deleteList;
	}

	@Override
	public void execute() {

		for (Shape s : this.deleteList) {
			map.put(model.getShapes().indexOf(s), s);
		}
		for (Shape s : this.deleteList) {
			model.remove(s);
			model.removeSel(s);
		}

		// model.removeSel(shape);
		System.out.println(model.getLstSelectedShapes().size());
		map.forEach((k, v) -> System.out.println("key: " + k + "value: " + v));

	}

	@Override
	public void unexecute() {
		map.forEach((k, v) -> {
			model.add(k, v);
			model.addSel(v);
		});

		System.out.println(model.getLstSelectedShapes().size());
		System.out.println("provera velicine liste");
		System.out.println(model.getShapes().size());

	}

}