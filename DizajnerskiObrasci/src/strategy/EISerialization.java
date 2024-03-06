package strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import geometry.Shape;
import mvc.DrawingController;

public class EISerialization implements EIStrategy {

	@Override
	public void exportShapes(DrawingController drawingController) {
		System.out.println("provera export serialization");
		try {
			FileOutputStream fileOutput = new FileOutputStream(drawingController.getFilePath());
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			objectOutput.writeObject(drawingController.getModel().getShapes());

			objectOutput.close();
			fileOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void importShapes(DrawingController drawingController) {
		System.out.println("provera import");
		try {
			FileInputStream fileInput = new FileInputStream(drawingController.getFilePath());
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			List<Shape> shapes = new ArrayList<Shape>();
			try {
				shapes.addAll((ArrayList<Shape>) objectInput.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			for (Shape shape : shapes) {
				drawingController.getModel().getShapes().add(shape);
				if (shape.isSelected()) {
					drawingController.getModel().getLstSelectedShapes().add(shape);
				}

			}
			// objectInput.readObject();

			objectInput.close();
			fileInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
