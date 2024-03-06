package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.util.Iterator;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingView extends JPanel implements Serializable {

	private DrawingModel model = new DrawingModel();

	public DrawingView() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.white);

	}

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = model.getShapes().iterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}

	}

}
