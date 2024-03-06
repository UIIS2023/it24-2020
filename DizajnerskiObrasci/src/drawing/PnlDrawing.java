package drawing;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class PnlDrawing extends JPanel {

	/**
	 * Create the panel.
	 */
	public boolean clickedPoint = false;
	public boolean clickedLine = false;
	public boolean clickedRectangle = false;
	public boolean clickedCircle = false;
	public boolean clickedDonut = false;
	public boolean isModify = false;
	public boolean isSelect = false;
	public boolean isDelete = false;
	public int indexOfShape = -1;
	Point startPoint = null;

	public ArrayList<Shape> lstShape = new ArrayList<Shape>();
	protected Line l;
	protected Rectangle r;
	protected Circle c;
	protected Donut d;

	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clickedPoint) {
					Point p = new Point(e.getX(), e.getY());
					lstShape.add(p);

				}
				if (clickedLine) {
					isSelect = false;
					if (startPoint == null) {
						startPoint = (new Point(e.getX(), e.getY()));
					} else {
						lstShape.add(new Line(startPoint, new Point(e.getX(), e.getY())));
						startPoint = null;
					}

				}
				if (clickedRectangle) {
					Rectangle r = new Rectangle();
					try {
						r.setUpperLeftPoint(new Point(e.getX(), e.getY()));
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					DlgRectangle dlgRect = new DlgRectangle();
					dlgRect.txtULPX.setText(Integer.toString(e.getX()));
					dlgRect.txtULPY.setText(Integer.toString(e.getY()));
					dlgRect.txtULPX.setEditable(false);
					dlgRect.txtULPY.setEditable(false);
					dlgRect.setVisible(true);
					try {
						r.setWidth(Integer.parseInt(dlgRect.txtW.getText()));
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						r.setHeight(Integer.parseInt(dlgRect.txtH.getText()));
						lstShape.add(r);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if (clickedCircle) {
					Circle c = new Circle();
					try {
						c.setCenter(new Point(e.getX(), e.getY()));
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					DlgModifyCircle dlgCircle = new DlgModifyCircle();
					dlgCircle.txtCenterX.setText(Integer.toString(e.getX()));
					dlgCircle.txtCenterY.setText(Integer.toString(e.getY()));
					dlgCircle.txtCenterX.setEditable(false);
					dlgCircle.txtCenterY.setEditable(false);
					dlgCircle.setVisible(true);
					try {
						c.setRadius(Integer.parseInt(dlgCircle.txtRadius.getText()));
						lstShape.add(c);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lstShape.add(c);
				}
				if (clickedDonut) {
					Donut d = new Donut();
					try {
						d.setCenter(new Point(e.getX(), e.getY()));
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					DlgModifyDonut dlgDonut = new DlgModifyDonut();
					dlgDonut.txtCenterX.setText(Integer.toString(e.getX()));
					dlgDonut.txtCenterY.setText(Integer.toString(e.getY()));
					dlgDonut.txtCenterX.setEditable(false);
					dlgDonut.txtCenterY.setEditable(false);
					dlgDonut.setVisible(true);
					try {
						d.setRadius(Integer.parseInt(dlgDonut.txtRadius.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						d.setInnerRadius(Integer.parseInt(dlgDonut.txtInnerRadius.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					lstShape.add(d);
				}
				if (isSelect) {
					ListIterator<Shape> it = lstShape.listIterator(lstShape.size());

					while (it.hasPrevious()) {
						Shape tempShape = it.previous();

						if (tempShape.contains(e.getX(), e.getY())) {
							indexOfShape = lstShape.indexOf(tempShape);
							boolean isSelected = lstShape.get(indexOfShape).isSelected();

							ListIterator<Shape> itSec = lstShape.listIterator(lstShape.size());
							while (itSec.hasPrevious()) {
								itSec.previous().setSelected(false);
							}
							if (!isSelected) {
								lstShape.get(indexOfShape).setSelected(true);
							}
							break;
						} else {
							tempShape.setSelected(false);
						}

					}

				}
				repaint();
			}
		});

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = lstShape.iterator();
		while (it.hasNext()) {
			g.setColor(Color.BLACK);
			it.next().draw(g);
		}

	}
}