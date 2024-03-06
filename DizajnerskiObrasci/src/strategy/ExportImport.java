package strategy;

import mvc.DrawingController;

public class ExportImport {

	public void exportShapes(EIStrategy eiStrategy, DrawingController drawingController) {
		eiStrategy.exportShapes(drawingController);
	}

	public void importShapes(EIStrategy eiStrategy, DrawingController drawingController) {
		eiStrategy.importShapes(drawingController);
	}

}
