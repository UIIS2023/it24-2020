package strategy;

import mvc.DrawingController;

public interface EIStrategy {

	void exportShapes(DrawingController drawingController);

	void importShapes(DrawingController drawingController);
}
