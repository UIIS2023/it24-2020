package mvc;

import java.util.ArrayList;
import java.util.List;

import geometry.Shape;

public class DrawingModel {

	private List<Shape> shapes = new ArrayList<Shape>();
	private List<Shape> selectedShapes = new ArrayList<Shape>();

	public List<Shape> getLstSelectedShapes() {
		return selectedShapes;
	}

	public Shape getSelectedShape(int index) {
		return selectedShapes.get(index);
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public Shape getShape(int index) {
		return shapes.get(index);
	}

	public void add(Shape s) {
		shapes.add(s);
	}

	public void add(int index, Shape s) {
		shapes.add(index, s);
	}

	public void addSel(Shape s) {
		selectedShapes.add(s);
	}

	public void remove(Shape s) {

		shapes.remove(s);
	}

	public void removeSel(Shape s) {
		selectedShapes.remove(s);
	}

	public void removeSel() {
		selectedShapes.clear();
	}

	public void remove() {
		shapes.clear();

	}

	public int size() {
		return shapes.size();
	}

	public int sizeSel() {
		return selectedShapes.size();
	}

}
