package mvc;

import drawing.DlgModifyDonut;
import drawing.DlgModifyHexagon;
import drawing.DlgModifyLine;
import drawing.DlgModifyPoint;
import drawing.DlgModifyRectangle;
import drawing.DlgRectangle;
import drawing.DlgRectangle;
import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgHexagon;
import drawing.DlgModifyCircle;
import geometry.Circle;
import geometry.Donut;
import geometry.Rectangle;
import geometry.Line;
import geometry.Point;
import geometry.Shape;
import strategy.EILog;
import strategy.EISerialization;
import strategy.EIStrategy;
import strategy.ExportImport;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import adapter.HexagonAdapter;
import command.AddShape;
import command.Command;
import command.FrontBack;
import command.DeleteShape;
import command.RemoveShape;
import command.ToBack;
import command.ToFront;
import command.UpdateCircle;
import command.UpdateDonut;
import command.UpdateHexagon;
import command.UpdateLine;
import command.UpdatePoint;
import command.UpdateRectangle;

public class DrawingController {

	private DrawingModel model;
	private DrawingFrame frame;

	public boolean clickedPoint = false;
	public boolean clickedLine = false;
	public boolean clickedRectangle = false;
	public boolean clickedCircle = false;
	public boolean clickedDonut = false;
	public boolean clickedHexagon = false;

	public boolean select = false;
	public boolean delete = false;
	public boolean modify = false;

	public int index = -1;
	public Point startPoint = null;

	private List<Command> undoList = new ArrayList<>();
	private List<Command> redoList = new ArrayList<>();

	private PropertyChangeSupport propertyChangeSupport;

	private DefaultListModel<String> defaultListModel = new DefaultListModel<String>();

	private String filePath;
	private int listStringIndex = 0;

	private List<String> listString = new ArrayList<String>();

	public DrawingController() {

	}

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		propertyChangeSupport = new PropertyChangeSupport(this);
		this.defaultListModel = frame.getDefaultListModel();
	}

	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
	}

	public void mouseClicked(MouseEvent e) {
		if (clickedPoint) {
			addPoint(e.getX(), e.getY(), frame.getBtnColor().getBackground());

		}

		if (clickedLine) {
			addLine(e.getX(), e.getY(), frame.getBtnColor().getBackground());
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
			dlgRect.setVisible(true);
			if (dlgRect.isCancel() == false) {

				try {
					r.setWidth(Integer.parseInt(dlgRect.txtW.getText()));
				} catch (Exception e2) {
					// e2.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"The height and width value of the rectangle must be a positive number");
					return;

				}
				try {
					r.setHeight(Integer.parseInt(dlgRect.txtH.getText()));

				} catch (Exception e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"The height and width value of the rectangle must be a positive number");
					return;

				}
				r.setColor(frame.getBtnColor().getBackground());
				r.setInsideColor(frame.getBtnInteriorColor().getBackground());
				addRectangle(r);
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
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.txtCentarx.setText(Integer.toString(e.getX()));
			dlgCircle.txtCentary.setText(Integer.toString(e.getY()));
			dlgCircle.txtCentarx.setEditable(false);
			dlgCircle.txtCentary.setEditable(false);
			dlgCircle.setVisible(true);
			if (dlgCircle.isCancel() == false) {
				try {
					c.setRadius(Integer.parseInt(dlgCircle.txtRadius.getText()));
				} catch (Exception e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "The value of radius must be positive number!");
					return;

				}
				c.setColor(frame.getBtnColor().getBackground());
				c.setInsideColor(frame.getBtnInteriorColor().getBackground());
				addCircle(c);
			}

		}
		if (clickedDonut) {
			Donut d = new Donut();
			try {
				d.setCenter(new Point(e.getX(), e.getY()));
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.txtCenterX.setText(Integer.toString(e.getX()));
			dlgDonut.txtCenterY.setText(Integer.toString(e.getY()));
			dlgDonut.txtCenterX.setEditable(false);
			dlgDonut.txtCenterY.setEditable(false);
			dlgDonut.setVisible(true);
			if (dlgDonut.isCancel() == false) {

				try {
					d.setRadius(Integer.parseInt(dlgDonut.txtRadius.getText()));
				} catch (Exception e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"The value of radius and inner radius must be positive number!");
					return;

				}
				try {
					d.setInnerRadius(Integer.parseInt(dlgDonut.txtInnerRadius.getText()));

				} catch (Exception e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"The value of radius must be larger than inner radius or the value of inner radius must be positive number!");

					return;

				}

				d.setColor(frame.getBtnColor().getBackground());
				d.setInsideColor(frame.getBtnInteriorColor().getBackground());

				addDonut(d);

			}
		}
		if (clickedHexagon) {
			HexagonAdapter h = new HexagonAdapter();
			try {
				h.setCenter(new Point(e.getX(), e.getY()));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			DlgHexagon dlgHex = new DlgHexagon();
			dlgHex.txtX.setText(Integer.toString(e.getX()));
			dlgHex.txtY.setText(Integer.toString(e.getY()));
			dlgHex.txtX.setEditable(false);
			dlgHex.txtY.setEditable(false);
			dlgHex.setVisible(true);
			if (dlgHex.isCancel() == false) {

				try {
					h.setRadius(Integer.parseInt(dlgHex.txtRadius.getText()));
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "The value of radius must be positive number!");
					return;

				}
				h.setColor(frame.getBtnColor().getBackground());
				h.setInsideColor(frame.getBtnInteriorColor().getBackground());
				addHexagon(h);

			}
		}

		if (select) {
			ListIterator<Shape> it = model.getShapes().listIterator(model.getShapes().size());
			boolean tempContains = false;
			while (it.hasPrevious()) {
				Shape tempShape = it.previous();

				if (tempShape.contains(e.getX(), e.getY())) {
					tempContains = false;
					boolean isSel = tempShape.isSelected();
					if (!isSel) {
						select(tempShape);
					} else {
						unselect(tempShape);
					}
					break;
				} else {
					tempContains = true;
				}
			}
			if (tempContains) {
				unselectedAll();
			}

			if (model.getLstSelectedShapes().size() == 1) {
				propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
				propertyChangeSupport.firePropertyChange("Modify button enable", false, true);

			} else if (model.getLstSelectedShapes().size() == 0) {
				propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
				propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
			} else {
				propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
				propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
			}
		}
		frame.repaint();
		System.out.println(model.getLstSelectedShapes().size());

	}

	public void addPoint(int x, int y, Color c) {
		Point p = new Point(x, y, c);
		AddShape addShape = new AddShape(model, p);
		addShape.execute();
		undoList.add(addShape);
		redoList.clear();
		checkUndoRedo();
		defaultListModel.addElement(p.toString());

	}

	public void addRectangle(Rectangle r) {
		AddShape addShape = new AddShape(model, r);
		addShape.execute();
		undoList.add(addShape);
		redoList.clear();
		checkUndoRedo();
		defaultListModel.addElement(r.toString());

	}

	public void addCircle(Circle c) {
		AddShape addShape = new AddShape(model, c);
		addShape.execute();
		undoList.add(addShape);
		redoList.clear();
		checkUndoRedo();
		defaultListModel.addElement(c.toString());

	}

	public void addDonut(Donut d) {
		AddShape addShape = new AddShape(model, d);
		addShape.execute();
		undoList.add(addShape);
		redoList.clear();
		checkUndoRedo();
		defaultListModel.addElement(d.toString());

	}

	public void addHexagon(HexagonAdapter h) {
		AddShape addShape = new AddShape(model, h);
		addShape.execute();
		undoList.add(addShape);
		redoList.clear();
		checkUndoRedo();
		defaultListModel.addElement(h.toString());

	}

	public void addLine(int x, int y, Color c) {
		if (startPoint == null) {
			startPoint = (new Point(x, y));
		} else {
			Line l = new Line(startPoint, new Point(x, y));
			l.setColor(c);
			AddShape addShape = new AddShape(model, l);
			addShape.execute();
			undoList.add(addShape);
			redoList.clear();
			checkUndoRedo();

			startPoint = null;

			defaultListModel.addElement(l.toString());

		}

	}

	public void remove(List<Shape> deleteList) {

		if (model.sizeSel() != 0) {

			RemoveShape removeShape = new RemoveShape(model, deleteList);
			removeShape.execute();
			undoList.add(removeShape);
			redoList.clear();
			checkUndoRedo();

		} else {
			JOptionPane.showMessageDialog(null, "Action can not be executed!");

		}
	}

	public void delete() {

		List<Shape> deleteList = new ArrayList<Shape>();

		if (model.sizeSel() >= 0) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure?", "Question", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				ListIterator<Shape> it = model.getLstSelectedShapes().listIterator(model.getLstSelectedShapes().size());
				while (it.hasPrevious()) {
					Shape tempShape = it.previous();
					if (tempShape.isSelected()) {

						deleteList.add(tempShape);
						// defaultListModel.addElement("Delete " + tempShape.toString());

					}
				}
				if (deleteList.size() == 1) {
					defaultListModel.addElement("Delete " + deleteList.get(0).toString());
				} else if (deleteList.size() > 1) {
					defaultListModel.addElement("Delete all selected shapes");

				}
				remove(deleteList);
				model.removeSel();
				propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
				propertyChangeSupport.firePropertyChange("Modify button disable", true, false);

			}
			delete = false;
			frame.repaint();
		}
	}

	public void select(Shape s) {
		model.addSel(s);
		int index2 = model.getShapes().indexOf(s);
		model.getShape(index2).setSelected(true);
		defaultListModel
				.addElement("Selected shape on index = " + index2 + " (" + model.getShape(index2).toString() + ")");

	}

	public void unselect(Shape s) {
		model.removeSel(s);
		int index2 = model.getShapes().indexOf(s);
		model.getShape(index2).setSelected(false);
		defaultListModel
				.addElement("Unselected shape on index = " + index2 + " (" + model.getShape(index2).toString() + ")");

	}

	public void unselectedAll() {
		if (model.sizeSel() != 0) {
			model.removeSel();
			ListIterator<Shape> it2 = model.getShapes().listIterator(model.getShapes().size());
			while (it2.hasPrevious()) {
				Shape tempShape = it2.previous();
				index = model.getShapes().indexOf(tempShape);
				model.getShape(index).setSelected(false);
			}
			defaultListModel.addElement("Unselected all selected shapes");

		} else {
			JOptionPane.showMessageDialog(null, "All shapes are unselected!");
		}
	}

	public void toFront() {
		if (!model.getLstSelectedShapes().isEmpty()) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != (model.size() - 1)) {
						ToFront toFront = new ToFront(model, index, index + 1);
						toFront.execute();
						undoList.add(toFront);
						redoList.clear();
						checkUndoRedo();
						defaultListModel.addElement("To front " + tempShape.toString());

						break;
					} else {
						JOptionPane.showMessageDialog(null, "Shape is on the front!");
					}
				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "No object is selected");

		}

	}

	public void bringToFront() {
		if (!model.getLstSelectedShapes().isEmpty()) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != (model.size() - 1)) {
						FrontBack bringToFront = new FrontBack(model, index, model.size() - 1);
						bringToFront.execute();
						undoList.add(bringToFront);
						redoList.clear();
						checkUndoRedo();
						defaultListModel.addElement("Bring to front " + tempShape.toString());

						break;
					} else {
						JOptionPane.showMessageDialog(null, "Shape is on the front!");
					}
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "No object is selected");

		}
	}

	public void toBack() {
		if (!model.getLstSelectedShapes().isEmpty()) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != 0) {
						ToBack toBack = new ToBack(model, index, index - 1);
						toBack.execute();
						undoList.add(toBack);
						redoList.clear();
						checkUndoRedo();
						defaultListModel.addElement("To back " + tempShape.toString());

						break;
					} else {
						JOptionPane.showMessageDialog(null, "Shape is on the back!");
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No object is selected");

		}
	}

	public void bringToBack() {
		if (!model.getLstSelectedShapes().isEmpty()) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != 0) {
						FrontBack bringToBack = new FrontBack(model, index, 0);
						bringToBack.execute();
						undoList.add(bringToBack);
						redoList.clear();
						checkUndoRedo();
						defaultListModel.addElement("Bring to back " + tempShape.toString());

						break;
					} else {
						JOptionPane.showMessageDialog(null, "Shape is on the back!");
					}
				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "No object is selected");
		}
	}

	public void undo() {
		ListIterator<Command> it = undoList.listIterator(undoList.size());

		Command temp = it.previous();
		temp.unexecute();
		undoList.remove(undoList.size() - 1);
		redoList.add(temp);
		checkUndoRedo();

		defaultListModel.addElement("Undo");

		if (model.getLstSelectedShapes().size() == 1) {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button enable", false, true);

		} else if (model.getLstSelectedShapes().size() == 0) {
			propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		} else {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		}

	}

	public void redo() {
		ListIterator<Command> it = redoList.listIterator(redoList.size());

		Command temp = it.previous();
		temp.execute();
		redoList.remove(redoList.size() - 1);
		undoList.add(temp);
		checkUndoRedo();

		defaultListModel.addElement("Redo");

		if (model.getLstSelectedShapes().size() == 1) {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button enable", false, true);

		} else if (model.getLstSelectedShapes().size() == 0) {
			propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		} else {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		}
	}

	public void checkUndoRedo() {
		if (undoList.size() > 0) {
			propertyChangeSupport.firePropertyChange("Undo button enable", false, true);
		} else {
			propertyChangeSupport.firePropertyChange("Undo button disable", true, false);

		}

		if (redoList.size() > 0) {
			propertyChangeSupport.firePropertyChange("Redo button enable", false, true);

		} else {
			propertyChangeSupport.firePropertyChange("Redo button disable", true, false);

		}
	}

	public void modify() {
		if (!model.getLstSelectedShapes().isEmpty()) {

			for (int i = 0; i < model.size(); i++) {
				if (model.getShape(i).equals(model.getSelectedShape(0)))
					index = i;
			}

			if (model.getShape(index) instanceof Point) {
				Point pt1 = (Point) model.getSelectedShape(0);
				if (index >= 0) {
					Point pt2 = new Point();
					DlgModifyPoint dlgPoint = new DlgModifyPoint();
					dlgPoint.getTxtX().setText(Integer.toString(pt1.getX()));
					dlgPoint.getTxtY().setText(Integer.toString(pt1.getY()));
					dlgPoint.setColor(pt1.getColor());
					dlgPoint.setVisible(true);
					if (!dlgPoint.isCancel() == false) {

						try {
							pt2.setX(Integer.parseInt(dlgPoint.getTxtX().getText()));
							pt2.setY(Integer.parseInt(dlgPoint.getTxtY().getText()));
							pt2.setColor(dlgPoint.getColor());
							UpdatePoint updatePoint = new UpdatePoint(pt1, pt2);
							updatePoint.execute();
							undoList.add(updatePoint);

							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + pt2.toString());

							// model.removeSel();
							modify = false;
						} catch (Exception e) {
							if (e.getMessage().equals("The values of coordinates must be positive!")) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter integers!");
							}
						}
					}
				}

			}
			if (model.getShape(index) instanceof Line) {
				Line line1 = (Line) model.getSelectedShape(0);
				if (index >= 0) {
					Line line2 = new Line();
					DlgModifyLine dlgLine = new DlgModifyLine();
					dlgLine.getTxtStartPointX().setText(Integer.toString(line1.getStartPoint().getX()));
					dlgLine.getTxtStartPointY().setText(Integer.toString(line1.getStartPoint().getY()));
					dlgLine.getTxtEndPointX().setText(Integer.toString(line1.getEndPoint().getX()));
					dlgLine.getTxtEndPointY().setText(Integer.toString(line1.getEndPoint().getY()));
					dlgLine.setColor(line1.getColor());
					dlgLine.setVisible(true);
					if (!dlgLine.isCancel() == false) {

						try {
							line2.setStartPoint(new Point(Integer.parseInt(dlgLine.getTxtStartPointX().getText()),
									Integer.parseInt(dlgLine.getTxtStartPointY().getText())));
							line2.setEndPoint(new Point(Integer.parseInt(dlgLine.getTxtEndPointX().getText()),
									Integer.parseInt(dlgLine.getTxtEndPointY().getText())));
							line2.setColor(dlgLine.getColor());
							UpdateLine updateLine = new UpdateLine(line1, line2);
							updateLine.execute();
							undoList.add(updateLine);
							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + line2.toString());

							// model.removeSel();

							modify = false;

						} catch (Exception e) {
							if (e.getMessage().equals("The values of coordinates must be positive!")) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter integers!");
							}
						}
					}
				}
			}

			if (model.getShape(index) instanceof Rectangle) {
				Rectangle r1 = (Rectangle) model.getSelectedShape(0);
				if (index >= 0) {
					Rectangle r2 = new Rectangle();
					DlgModifyRectangle dlgRect = new DlgModifyRectangle();
					dlgRect.getTxtULPX().setText(Integer.toString(r1.getUpperLeftPoint().getX()));
					dlgRect.getTxtULPY().setText(Integer.toString(r1.getUpperLeftPoint().getY()));
					dlgRect.getTxtW().setText(Integer.toString(r1.getWidth()));
					dlgRect.getTxtH().setText(Integer.toString(r1.getHeight()));
					dlgRect.setColor1(r1.getColor());
					dlgRect.setColor2(r1.getInsideColor());
					dlgRect.setVisible(true);
					if (!dlgRect.isCancel() == false) {
						try {
							r2.setUpperLeftPoint(new Point(Integer.parseInt(dlgRect.getTxtULPX().getText()),
									Integer.parseInt(dlgRect.getTxtULPY().getText())));
							r2.setWidth(Integer.parseInt(dlgRect.getTxtW().getText()));
							r2.setHeight(Integer.parseInt(dlgRect.getTxtH().getText()));
							r2.setColor(dlgRect.getColor1());
							r2.setInsideColor(dlgRect.getColor2());

							UpdateRectangle updateRectangle = new UpdateRectangle(r1, r2);
							updateRectangle.execute();
							undoList.add(updateRectangle);
							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + r2.toString());

							// model.removeSel();
							modify = false;

						} catch (Exception e) {

							if (e.getMessage().equals("The value of width must be positive!")) {
								JOptionPane.showMessageDialog(null, "The value of width must be positive!");
							} else if (e.getMessage().equals("The value of height must be positive!")) {
								JOptionPane.showMessageDialog(null, "The value of height must be positive!");
							} else if (e.getMessage().equals("The values of coordinates must be positive!")) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter integers!");
							}
						}
					}

				}
			}
			if (model.getShape(index) instanceof Circle && !(model.getShape(index) instanceof Donut)) {
				Circle c1 = (Circle) model.getSelectedShape(0);
				if (index >= 0) {
					Circle c2 = new Circle();
					DlgModifyCircle dlgCircle = new DlgModifyCircle();
					dlgCircle.getTxtCenterX().setText(Integer.toString(c1.getCenter().getX()));
					dlgCircle.getTxtCenterY().setText(Integer.toString(c1.getCenter().getY()));
					dlgCircle.getTxtRadius().setText(Integer.toString(c1.getRadius()));
					dlgCircle.setColor1(c1.getColor());
					dlgCircle.setColor2(c1.getInsideColor());
					dlgCircle.setVisible(true);
					if (!dlgCircle.isCancel() == false) {
						try {
							c2.setCenter(new Point(Integer.parseInt(dlgCircle.getTxtCenterX().getText()),
									Integer.parseInt(dlgCircle.getTxtCenterY().getText())));
							c2.setRadius(Integer.parseInt(dlgCircle.getTxtRadius().getText()));
							c2.setColor(dlgCircle.getColor1());
							c2.setInsideColor(dlgCircle.getColor2());

							UpdateCircle updateCircle = new UpdateCircle(c1, c2);
							updateCircle.execute();
							undoList.add(updateCircle);

							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + c2.toString());

							// model.removeSel();

							modify = false;

						} catch (Exception e) {
							if (e.getMessage().equals("The value of radius must be positive!")) {
								JOptionPane.showMessageDialog(null, "The value of radius must be positive!");
							} else if (e.getMessage().equals("The values of coordinates must be positive!")) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter integers!");
							}
						}
					}
				}

			}

			if (model.getShape(index) instanceof Donut) {
				Donut d1 = (Donut) model.getSelectedShape(0);
				if (index >= 0) {
					Donut d2 = new Donut();
					DlgModifyDonut dlgDonut = new DlgModifyDonut();
					dlgDonut.getTxtCenterX().setText(Integer.toString(d1.getCenter().getX()));
					dlgDonut.getTxtCenterY().setText(Integer.toString(d1.getCenter().getY()));
					dlgDonut.getTxtRadius().setText(Integer.toString(d1.getRadius()));
					dlgDonut.getTxtInnerRadius().setText(Integer.toString(d1.getInnerRadius()));
					dlgDonut.setColor(d1.getColor());

					dlgDonut.setColor_2(d1.getInsideColor());
					dlgDonut.setVisible(true);
					if (!dlgDonut.isCancel() == false) {

						try {
							d2.setCenter(new Point(Integer.parseInt(dlgDonut.getTxtCenterX().getText()),
									Integer.parseInt(dlgDonut.getTxtCenterY().getText())));
							if (d2.getCenter().getX() < 0 || d2.getCenter().getY() < 0) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
								return;
							}
							d2.setRadius(Integer.parseInt(dlgDonut.getTxtRadius().getText()));
							d2.setInnerRadius(Integer.parseInt(dlgDonut.getTxtInnerRadius().getText()));

							d2.setColor(dlgDonut.getColor());
							d2.setInsideColor(dlgDonut.getColor_2());

							UpdateDonut updateDonut = new UpdateDonut(d1, d2);
							updateDonut.execute();
							undoList.add(updateDonut);
							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + d2.toString());

							// model.removeSel();

							modify = false;

						} catch (Exception e) {
							if (e.getMessage()
									.equals("The value of radius must be must be larger than inner radius!")) {
								JOptionPane.showMessageDialog(null,
										"The value of radius must be must be larger than inner radius!");
							} else if (e.getMessage().equals("The values of coordinates must be positive!")) {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter positive number!");
							}
						}
					}
				}

			}
			if (model.getShape(index) instanceof HexagonAdapter) {
				HexagonAdapter hex1 = (HexagonAdapter) model.getSelectedShape(0);
				if (index >= 0) {
					HexagonAdapter hex2 = new HexagonAdapter();
					DlgModifyHexagon dlgHexagon = new DlgModifyHexagon();
					dlgHexagon.getTxtX().setText(Integer.toString(hex1.getCenter().getX()));
					dlgHexagon.getTxtY().setText(Integer.toString(hex1.getCenter().getY()));
					dlgHexagon.getTxtRadius().setText(Integer.toString(hex1.getRadius()));
					dlgHexagon.setColor1(hex1.getColor());
					dlgHexagon.setColor2(hex1.getInsideColor());
					dlgHexagon.setVisible(true);
					if (!dlgHexagon.isCancel() == false) {

						try {
							hex2.setCenter(new Point(Integer.parseInt(dlgHexagon.getTxtX().getText()),
									Integer.parseInt(dlgHexagon.getTxtY().getText())));
							hex2.setRadius(Integer.parseInt(dlgHexagon.getTxtRadius().getText()));
							hex2.setColor(dlgHexagon.getColor1());
							hex2.setInsideColor(dlgHexagon.getColor2());

							UpdateHexagon updateHexagon = new UpdateHexagon(hex1, hex2);
							updateHexagon.execute();
							undoList.add(updateHexagon);
							redoList.clear();

							checkUndoRedo();

							defaultListModel.addElement("Modify " + hex2.toString());

							// model.removeSel();

							modify = false;
						} catch (Exception e) {
							if (e.getMessage() == "The value of radius must be positive number!") {
								JOptionPane.showMessageDialog(null, "The value of radius must be positive number!");
							} else if (e.getMessage() == "The values of coordinates must be positive!") {
								JOptionPane.showMessageDialog(null, "The values of coordinates must be positive!");
							} else {
								JOptionPane.showMessageDialog(null, "You must enter integers!");
							}
						}

					}
				}
			}

			model.getShape(index).setSelected(true);
			model.removeSel();
			model.addSel(model.getShape(index));
			frame.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "No object is selected");
		}
	}

	public void exportShapes(String path) {
		System.out.println(path);
		filePath = path;
		EIStrategy eiSerializationStrategy = new EISerialization();

		ExportImport export = new ExportImport();
		export.exportShapes(eiSerializationStrategy, this);

		EIStrategy eiLogStrategy = new EILog();

		export.exportShapes(eiLogStrategy, this);

	}

	public void importShapes(String path) {
		System.out.println(path);
		filePath = path;
		EIStrategy eiSerializationStrategy = new EISerialization();
		EIStrategy eiLogStrategy = new EILog();

		ExportImport importS = new ExportImport();

		if (!filePath.contains(".txt")) {
			importS.importShapes(eiSerializationStrategy, this);

		} else {
			
			importS.importShapes(eiLogStrategy, this);
			JOptionPane.showMessageDialog(null, "Text file is imported! You can click button Load Log Command!");

			listStringIndex = 0;
			

		}

		frame.repaint();
		if (model.getLstSelectedShapes().size() == 1) {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button enable", false, true);

		} else if (model.getLstSelectedShapes().size() == 0) {
			propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		} else {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		}

	}

	public void loadLogCommand() {

		if (listString.size() == 0 || listStringIndex >= listString.size()) {

			JOptionPane.showMessageDialog(null, "Please import txt file");
			return;

		}
		System.out.println(listString.get(listStringIndex));

		String[] partsOfShapes = listString.get(listStringIndex).split("[ ()]");
		if (partsOfShapes[0].contains("Point")) {

			int x = Integer.parseInt(partsOfShapes[2].split(",")[0]);
			int y = Integer.parseInt(partsOfShapes[2].split(",")[1]);

			String[] color = partsOfShapes[5].split("[=,]");
			int red = Integer.parseInt(color[1]);
			int green = Integer.parseInt(color[3]);
			int blue = Integer.parseInt(color[5].replace("]", ""));

			addPoint(x, y, new Color(red, green, blue));
		} else if (partsOfShapes[0].contains("Line")) {

			int StartX = Integer.parseInt(partsOfShapes[2].split(",")[0]);
			int StartY = Integer.parseInt(partsOfShapes[2].split(",")[1]);

			int EndX = Integer.parseInt(partsOfShapes[5].split(",")[0]);
			int EndY = Integer.parseInt(partsOfShapes[5].split(",")[1]);

			String[] color = partsOfShapes[8].split("[=,]");
			int red = Integer.parseInt(color[1]);
			int green = Integer.parseInt(color[3]);
			int blue = Integer.parseInt(color[5].replace("]", ""));

			startPoint = new Point(StartX, StartY);
			addLine(EndX, EndY, new Color(red, green, blue));

		} else if (partsOfShapes[0].contains("Rectangle")) {

			int x = Integer.parseInt(partsOfShapes[2].split(",")[0]);
			int y = Integer.parseInt(partsOfShapes[2].split(",")[1]);

			int width = Integer.parseInt(partsOfShapes[7].split(",")[0]);
			int height = Integer.parseInt(partsOfShapes[10].split("[,]")[0]);

			String[] edgeColor = partsOfShapes[13].split("[=,]");
			String[] insideColor = partsOfShapes[16].split("[=,]");
			Rectangle r = new Rectangle(new Point(x, y), width, height);

			r.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
					Integer.parseInt(edgeColor[5].replace("]", ""))));
			r.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
					Integer.parseInt(insideColor[5].replace("]", ""))));
			addRectangle(r);

		} else if (partsOfShapes[0].contains("Donut")) {

			int x = Integer.parseInt(partsOfShapes[4].split(",")[0]);
			int y = Integer.parseInt(partsOfShapes[5].split(",")[0]);
			int radius = Integer.parseInt(partsOfShapes[9].split(",")[0]);
			int innerRadius = Integer.parseInt(partsOfShapes[13].split(",")[0]);

			String[] edgeColor = partsOfShapes[16].split("[=,]");
			String[] insideColor = partsOfShapes[19].split("[=,]");

			Donut donut = new Donut(new Point(x, y), radius, innerRadius);
			donut.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
					Integer.parseInt(edgeColor[5].replace("]", ""))));
			donut.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
					Integer.parseInt(insideColor[5].replace("]", ""))));
			addCircle(donut);

		} else if (partsOfShapes[0].contains("Circle")) {

			int x = Integer.parseInt(partsOfShapes[4].split(",")[0]);
			int y = Integer.parseInt(partsOfShapes[5].split(",")[0]);
			int radius = Integer.parseInt(partsOfShapes[9].split(",")[0]);

			String[] edgeColor = partsOfShapes[12].split("[=,]");
			String[] insideColor = partsOfShapes[15].split("[=,]");

			Circle circle = new Circle(new Point(x, y), radius);
			circle.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
					Integer.parseInt(edgeColor[5].replace("]", ""))));
			circle.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
					Integer.parseInt(insideColor[5].replace("]", ""))));
			addCircle(circle);

		} else if (partsOfShapes[0].contains("Hexagon")) {

			int x = Integer.parseInt(partsOfShapes[4].split(",")[0]);
			int y = Integer.parseInt(partsOfShapes[5].split(",")[0]);
			int radius = Integer.parseInt(partsOfShapes[9].split(",")[0]);

			String[] edgeColor = partsOfShapes[12].split("[=,]");
			String[] insideColor = partsOfShapes[15].split("[=,]");

			HexagonAdapter hex = new HexagonAdapter(x, y, radius);
			hex.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
					Integer.parseInt(edgeColor[5].replace("]", ""))));
			hex.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
					Integer.parseInt(insideColor[5].replace("]", ""))));
			addHexagon(hex);

		} else if (partsOfShapes[0].contains("Selected")) {

			int index = Integer.parseInt(partsOfShapes[5]);
			Shape s = model.getShape(index);
			model.addSel(s);
			s.setSelected(true);
			defaultListModel.addElement("Selected shape on index = " + index + " (" + s.toString() + ")");
		} else if (partsOfShapes[0].contains("Unselected")) {
			if (partsOfShapes[1].contains("all")) {
				unselectedAll();
			} else {
				int index = Integer.parseInt(partsOfShapes[5]);
				Shape s = model.getShape(index);
				model.removeSel(s);
				s.setSelected(false);
				defaultListModel.addElement("Unselected shape on index = " + index + " (" + s.toString() + ")");
			}

		} else if (partsOfShapes[0].contains("Modify")) {
			if (partsOfShapes[1].contains("Point")) {
				Point pt1 = (Point) model.getSelectedShape(0);
				int x = Integer.parseInt(partsOfShapes[3].split(",")[0]);
				int y = Integer.parseInt(partsOfShapes[3].split(",")[1]);

				String[] color = partsOfShapes[6].split("[=,]");
				int red = Integer.parseInt(color[1]);
				int green = Integer.parseInt(color[3]);
				int blue = Integer.parseInt(color[5].replace("]", ""));
				Point pt2 = new Point(x, y, new Color(red, green, blue));
				UpdatePoint updatePoint = new UpdatePoint(pt1, pt2);
				updatePoint.execute();
				undoList.add(updatePoint);
				redoList.clear();

				defaultListModel.addElement("Modify " + pt2.toString());

			} else if (partsOfShapes[1].contains("Line")) {
				Line line1 = (Line) model.getSelectedShape(0);
				int StartX = Integer.parseInt(partsOfShapes[3].split(",")[0]);
				int StartY = Integer.parseInt(partsOfShapes[3].split(",")[1]);

				int EndX = Integer.parseInt(partsOfShapes[6].split(",")[0]);
				int EndY = Integer.parseInt(partsOfShapes[6].split(",")[1]);

				String[] color = partsOfShapes[9].split("[=,]");
				int red = Integer.parseInt(color[1]);
				int green = Integer.parseInt(color[3]);
				int blue = Integer.parseInt(color[5].replace("]", ""));

				Line line2 = new Line(new Point(StartX, StartY), new Point(EndX, EndY));
				line2.setColor(new Color(red, green, blue));

				UpdateLine updateLine = new UpdateLine(line1, line2);
				updateLine.execute();
				undoList.add(updateLine);
				redoList.clear();

				defaultListModel.addElement("Modify " + line2.toString());

			} else if (partsOfShapes[1].contains("Rectangle")) {
				Rectangle rectangle1 = (Rectangle) model.getSelectedShape(0);
				int x = Integer.parseInt(partsOfShapes[3].split(",")[0]);
				int y = Integer.parseInt(partsOfShapes[3].split(",")[1]);

				int width = Integer.parseInt(partsOfShapes[8].split(",")[0]);
				int height = Integer.parseInt(partsOfShapes[11].split("[,]")[0]);

				String[] edgeColor = partsOfShapes[14].split("[=,]");
				String[] insideColor = partsOfShapes[17].split("[=,]");
				Rectangle rectangle2 = new Rectangle(new Point(x, y), width, height);

				rectangle2.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
						Integer.parseInt(edgeColor[5].replace("]", ""))));
				rectangle2.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
						Integer.parseInt(insideColor[5].replace("]", ""))));

				UpdateRectangle updateRectangle = new UpdateRectangle(rectangle1, rectangle2);
				updateRectangle.execute();
				undoList.add(updateRectangle);
				redoList.clear();

				defaultListModel.addElement("Modify " + rectangle2.toString());

			} else if (partsOfShapes[1].contains("Donut")) {
				Donut donut1 = (Donut) model.getSelectedShape(0);
				int x = Integer.parseInt(partsOfShapes[5].split(",")[0]);
				int y = Integer.parseInt(partsOfShapes[6].split(",")[0]);
				int radius = Integer.parseInt(partsOfShapes[10].split(",")[0]);
				int innerRadius = Integer.parseInt(partsOfShapes[14].split(",")[0]);

				String[] edgeColor = partsOfShapes[17].split("[=,]");
				String[] insideColor = partsOfShapes[20].split("[=,]");

				Donut donut2 = new Donut(new Point(x, y), radius, innerRadius);
				donut2.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
						Integer.parseInt(edgeColor[5].replace("]", ""))));
				donut2.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
						Integer.parseInt(insideColor[5].replace("]", ""))));

				UpdateDonut updateDonut = new UpdateDonut(donut1, donut2);
				updateDonut.execute();
				undoList.add(updateDonut);
				redoList.clear();

				defaultListModel.addElement("Modify " + donut2.toString());

			} else if (partsOfShapes[1].contains("Circle")) {
				Circle circle1 = (Circle) model.getSelectedShape(0);
				int x = Integer.parseInt(partsOfShapes[5].split(",")[0]);
				int y = Integer.parseInt(partsOfShapes[6].split(",")[0]);
				int radius = Integer.parseInt(partsOfShapes[10].split(",")[0]);

				String[] edgeColor = partsOfShapes[13].split("[=,]");
				String[] insideColor = partsOfShapes[16].split("[=,]");

				Circle circle2 = new Circle(new Point(x, y), radius);
				circle2.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
						Integer.parseInt(edgeColor[5].replace("]", ""))));
				circle2.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
						Integer.parseInt(insideColor[5].replace("]", ""))));

				UpdateCircle updateCircle = new UpdateCircle(circle1, circle2);
				updateCircle.execute();
				undoList.add(updateCircle);
				redoList.clear();

				defaultListModel.addElement("Modify " + circle2.toString());

			} else if (partsOfShapes[1].contains("Hexagon")) {
				HexagonAdapter hex1 = (HexagonAdapter) model.getSelectedShape(0);
				int x = Integer.parseInt(partsOfShapes[5].split(",")[0]);
				int y = Integer.parseInt(partsOfShapes[6].split(",")[0]);
				int radius = Integer.parseInt(partsOfShapes[10].split(",")[0]);

				String[] edgeColor = partsOfShapes[13].split("[=,]");
				String[] insideColor = partsOfShapes[16].split("[=,]");

				HexagonAdapter hex2 = new HexagonAdapter(x, y, radius);
				hex2.setColor(new Color(Integer.parseInt(edgeColor[1]), Integer.parseInt(edgeColor[3]),
						Integer.parseInt(edgeColor[5].replace("]", ""))));
				hex2.setInsideColor(new Color(Integer.parseInt(insideColor[1]), Integer.parseInt(insideColor[3]),
						Integer.parseInt(insideColor[5].replace("]", ""))));

				UpdateHexagon updateHexagon = new UpdateHexagon(hex1, hex2);
				updateHexagon.execute();
				undoList.add(updateHexagon);
				redoList.clear();

				defaultListModel.addElement("Modify " + hex2.toString());
			}

		} else if (partsOfShapes[0].contains("Delete")) {
			List<Shape> deleteList = new ArrayList<Shape>();

			ListIterator<Shape> it = model.getLstSelectedShapes().listIterator(model.getLstSelectedShapes().size());
			while (it.hasPrevious()) {
				Shape tempShape = it.previous();
				if (tempShape.isSelected()) {

					deleteList.add(tempShape);

				}
			}
			if (deleteList.size() == 1) {
				defaultListModel.addElement("Delete " + deleteList.get(0).toString());
			} else if (deleteList.size() > 1) {
				defaultListModel.addElement("Delete all selected shapes");

			}
			remove(deleteList);
			model.removeSel();
		} else if (partsOfShapes[0].contains("To") && partsOfShapes[1].contains("front")) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != (model.size() - 1)) {
						ToFront toFront = new ToFront(model, index, index + 1);
						toFront.execute();
						undoList.add(toFront);
						redoList.clear();

						checkUndoRedo();
						defaultListModel.addElement("To front " + tempShape.toString());

						break;
					}
				}
			}
		} else if (partsOfShapes[0].contains("To") && partsOfShapes[1].contains("back")) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != 0) {
						ToBack toBack = new ToBack(model, index, index - 1);
						toBack.execute();
						undoList.add(toBack);
						redoList.clear();

						checkUndoRedo();
						defaultListModel.addElement("To back " + tempShape.toString());

						break;
					}
				}
			}
		} else if (partsOfShapes[0].contains("Bring") && partsOfShapes[2].contains("front")) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != (model.size() - 1)) {
						FrontBack bringToFront = new FrontBack(model, index, model.size() - 1);
						bringToFront.execute();
						undoList.add(bringToFront);
						redoList.clear();

						checkUndoRedo();
						defaultListModel.addElement("Bring to front " + tempShape.toString());

						break;
					}
				}
			}
		} else if (partsOfShapes[0].contains("Bring") && partsOfShapes[2].contains("back")) {
			ListIterator<Shape> it = model.getShapes().listIterator(0);
			while (it.hasNext()) {
				Shape tempShape = it.next();
				int index = model.getShapes().indexOf(tempShape);
				if (tempShape.isSelected() && model.size() >= 1) {
					if (index != 0) {
						FrontBack bringToBack = new FrontBack(model, index, 0);
						bringToBack.execute();
						undoList.add(bringToBack);
						redoList.clear();

						checkUndoRedo();
						defaultListModel.addElement("Bring to back " + tempShape.toString());

						break;

					}
				}
			}
		} else if (partsOfShapes[0].contains("Undo")) {
			undo();
		} else if (partsOfShapes[0].contains("Redo")) {
			redo();
		}
		frame.repaint();
		if (model.getLstSelectedShapes().size() == 1) {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button enable", false, true);

		} else if (model.getLstSelectedShapes().size() == 0) {
			propertyChangeSupport.firePropertyChange("Delete button disable", true, false);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		} else {
			propertyChangeSupport.firePropertyChange("Delete button enable", false, true);
			propertyChangeSupport.firePropertyChange("Modify button disable", true, false);
		}

		listStringIndex++;

	}

	public DrawingModel getModel() {
		return model;
	}

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public DefaultListModel<String> getDefaultListModel() {
		return defaultListModel;
	}

	public void setDefaultListModel(DefaultListModel<String> defaultListModel) {
		this.defaultListModel = defaultListModel;
	}

	public List<String> getListString() {
		return listString;
	}

	public void setListString(List<String> listString) {
		this.listString = listString;
	}

}
