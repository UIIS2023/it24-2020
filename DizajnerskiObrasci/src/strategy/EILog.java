package strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import geometry.Shape;
import mvc.DrawingController;

public class EILog implements EIStrategy {

	@Override
	public void exportShapes(DrawingController drawingController) {
		System.out.println("provera export log");
		try {
			FileWriter fileWriter = new FileWriter(drawingController.getFilePath() + ".txt");

			PrintWriter printWriter = new PrintWriter(fileWriter);

			List<Object> listPrint = new ArrayList<Object>();

			listPrint.addAll(Arrays.asList(drawingController.getDefaultListModel().toArray()));

			Iterator<Object> it = listPrint.iterator();

			while (it.hasNext()) {
				printWriter.println(it.next());

			}

			printWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void importShapes(DrawingController drawingController) {
		System.out.println("provera import log");

		try {
			FileReader fileReader = new FileReader(drawingController.getFilePath());
			List<String> listString = new ArrayList<String>();

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String st;

			while ((st = bufferedReader.readLine()) != null) {
				listString.add(st);

			}
			drawingController.getListString().addAll(listString);
			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
