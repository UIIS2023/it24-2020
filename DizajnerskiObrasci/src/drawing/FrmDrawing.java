package drawing;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
//import stack.DlgStack;

import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JToggleButton tglbtnSelection;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("IT 27-2020 Isaku Dajana");

		PnlDrawing panel = new PnlDrawing();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		JPanel pnlWest = new JPanel();
		pnlWest.setForeground(Color.WHITE);
		pnlWest.setBackground(Color.WHITE);
		contentPane.add(pnlWest, BorderLayout.WEST);
		GridBagLayout gbl_pnlWest = new GridBagLayout();
		gbl_pnlWest.columnWidths = new int[] { 180, 0 };
		gbl_pnlWest.rowHeights = new int[] { 63, 50, 15, 45, 21, 41, 0, 0 };
		gbl_pnlWest.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlWest.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlWest.setLayout(gbl_pnlWest);

		JToggleButton tglbtnModify = new JToggleButton("MODIFY");
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.isModify = true;
				panel.clickedPoint = false;
				panel.clickedLine = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = false;
				panel.clickedDonut = false;

				if (panel.lstShape.get(panel.indexOfShape) instanceof Point) {
					Point p = (Point) panel.lstShape.get(panel.indexOfShape);
					if (panel.indexOfShape >= 0) {
						DlgModifyPoint dlgPoint = new DlgModifyPoint();
						dlgPoint.txtX.setText(Integer.toString(p.getX()));
						dlgPoint.txtY.setText(Integer.toString(p.getY()));
						dlgPoint.setVisible(true);
						try {
							p.setX(Integer.parseInt(dlgPoint.txtX.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							p.setY(Integer.parseInt(dlgPoint.txtY.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						p.setSelected(false);

						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, p);
						p.setColor(dlgPoint.point1.getColor());

						repaint();

					}
				}
				if (panel.lstShape.get(panel.indexOfShape) instanceof Line) {
					Line l = (Line) panel.lstShape.get(panel.indexOfShape);
					if (panel.indexOfShape >= 0 && panel.isSelect) {
						DlgModifyLine dlgLine = new DlgModifyLine();
						dlgLine.txtStartPointX.setText(Integer.toString(l.getStartPoint().getX()));
						dlgLine.txtStartPointY.setText(Integer.toString(l.getStartPoint().getY()));
						dlgLine.txtEndPointX.setText(Integer.toString(l.getEndPoint().getX()));
						dlgLine.txtEndPointY.setText(Integer.toString(l.getEndPoint().getY()));

						dlgLine.setVisible(true);
						try {
							l.setStartPoint(new Point(Integer.parseInt(dlgLine.txtStartPointX.getText()),
									Integer.parseInt(dlgLine.txtStartPointY.getText())));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							l.setEndPoint(new Point(Integer.parseInt(dlgLine.txtEndPointX.getText()),
									Integer.parseInt(dlgLine.txtEndPointY.getText())));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						l.setSelected(false);

						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, l);
						l.setColor(dlgLine.line.getColor());
						panel.isSelect = false;

						repaint();

					}
				}
				if (panel.lstShape.get(panel.indexOfShape) instanceof Rectangle) {
					panel.r = new Rectangle();
					panel.r = (Rectangle) panel.lstShape.get(panel.indexOfShape);
					if (panel.indexOfShape >= 0 && panel.isSelect) {
						DlgRectangle dlgRect = new DlgRectangle();
						dlgRect.txtULPX.setText(Integer.toString(panel.r.getUpperLeftPoint().getX()));
						dlgRect.txtULPY.setText(Integer.toString(panel.r.getUpperLeftPoint().getY()));
						dlgRect.txtW.setText(Integer.toString(panel.r.getWidth()));
						dlgRect.txtH.setText(Integer.toString(panel.r.getHeight()));
						dlgRect.setVisible(true);
						try {
							panel.r.getUpperLeftPoint().setX(Integer.parseInt(dlgRect.txtULPX.getText()));
						} catch (NumberFormatException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							panel.r.getUpperLeftPoint().setY(Integer.parseInt(dlgRect.txtULPY.getText()));
						} catch (NumberFormatException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						try {
							panel.r.setWidth(Integer.parseInt(dlgRect.txtW.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							panel.r.setHeight(Integer.parseInt(dlgRect.txtH.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.r.setSelected(false);
						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, panel.r);
						panel.r.setColor(dlgRect.r.getColor());
						if (dlgRect.r.getInsideColor() != null) {
							panel.r.setInsideColor(dlgRect.r.getInsideColor());
						}
						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, panel.r);
						panel.isSelect = false;
						repaint();
					}
				}
				if (panel.lstShape.get(panel.indexOfShape) instanceof Donut) {
					panel.d = new Donut();
					panel.d = (Donut) panel.lstShape.get(panel.indexOfShape);
					if (panel.indexOfShape >= 0 && panel.isSelect) {
						DlgModifyDonut dlgDonut = new DlgModifyDonut();
						dlgDonut.txtCenterX.setText(Integer.toString(panel.d.getCenter().getX()));
						dlgDonut.txtCenterY.setText(Integer.toString(panel.d.getCenter().getY()));
						dlgDonut.txtRadius.setText(Integer.toString(panel.d.getRadius()));
						dlgDonut.txtInnerRadius.setText(Integer.toString(panel.d.getInnerRadius()));
						dlgDonut.setVisible(true);
						try {
							panel.d.setCenter(new Point(Integer.parseInt(dlgDonut.txtCenterX.getText()),
									Integer.parseInt(dlgDonut.txtCenterY.getText())));
						} catch (NumberFormatException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							panel.d.setRadius(Integer.parseInt(dlgDonut.txtRadius.getText()));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						try {
							panel.d.setInnerRadius(Integer.parseInt(dlgDonut.txtInnerRadius.getText()));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						panel.d.setSelected(false);
						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, panel.d);
						panel.d.setColor(dlgDonut.d.getColor());
						if (dlgDonut.d.getInsideColor() != null) {
							panel.d.setInsideColor(dlgDonut.d.getInsideColor());
						}
						panel.isSelect = false;
						repaint();
					}
				}

				if (panel.lstShape.get(panel.indexOfShape) instanceof Circle) {
					panel.c = new Circle();
					panel.c = (Circle) panel.lstShape.get(panel.indexOfShape);
					if (panel.indexOfShape >= 0 && panel.isSelect) {
						DlgModifyCircle dlgCircle = new DlgModifyCircle();
						dlgCircle.txtCenterX.setText(Integer.toString(panel.c.getCenter().getX()));
						dlgCircle.txtCenterY.setText(Integer.toString(panel.c.getCenter().getY()));
						dlgCircle.txtRadius.setText(Integer.toString(panel.c.getRadius()));
						dlgCircle.setVisible(true);
						try {
							panel.c.getCenter().setX(Integer.parseInt(dlgCircle.txtCenterX.getText()));
						} catch (NumberFormatException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (Exception e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						try {
							panel.c.getCenter().setY(Integer.parseInt(dlgCircle.txtCenterY.getText()));
						} catch (NumberFormatException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						try {
							panel.c.setRadius(Integer.parseInt(dlgCircle.txtRadius.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.c.setSelected(false);
						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, panel.r);
						panel.c.setColor(dlgCircle.c.getColor());
						if (dlgCircle.c.getInsideColor() != null) {
							panel.c.setInsideColor(dlgCircle.c.getInsideColor());
						}
						panel.lstShape.remove(panel.indexOfShape);
						panel.lstShape.add(panel.indexOfShape, panel.c);
						panel.isSelect = false;
						repaint();
					}
				}

			}

		});
		tglbtnModify.setForeground(Color.WHITE);
		tglbtnModify.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModify.gridx = 0;
		gbc_tglbtnModify.gridy = 0;
		pnlWest.add(tglbtnModify, gbc_tglbtnModify);
		tglbtnModify.setPreferredSize(new Dimension(180, 50));

		tglbtnSelection = new JToggleButton("SELECTION");
		tglbtnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.isSelect = true;
				panel.clickedLine = false;
				panel.clickedPoint = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = false;
				panel.clickedDonut = false;
			}
		});
		tglbtnSelection.setForeground(Color.WHITE);
		tglbtnSelection.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnSelection);
		tglbtnSelection.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnSelection = new GridBagConstraints();
		gbc_tglbtnSelection.anchor = GridBagConstraints.WEST;
		gbc_tglbtnSelection.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelection.gridx = 0;
		gbc_tglbtnSelection.gridy = 1;
		pnlWest.add(tglbtnSelection, gbc_tglbtnSelection);
		tglbtnSelection.setPreferredSize(new Dimension(180, 50));

		JToggleButton tglbtnDelete = new JToggleButton("DELETE");
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.isDelete = true;
				panel.isSelect = false;
				if (panel.indexOfShape >= 0) {
					int n = JOptionPane.showConfirmDialog(null, "Delete this object?", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						panel.lstShape.remove(panel.indexOfShape);
						// System.out.println(panel.indexOfShape);
						panel.indexOfShape = -1;
						repaint();
					}
				}

			}
		});
		tglbtnDelete.setForeground(Color.WHITE);
		tglbtnDelete.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.anchor = GridBagConstraints.WEST;
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDelete.gridx = 0;
		gbc_tglbtnDelete.gridy = 3;
		pnlWest.add(tglbtnDelete, gbc_tglbtnDelete);
		tglbtnDelete.setPreferredSize(new Dimension(180, 50));

		JToggleButton tglbtnDrawing = new JToggleButton("DRAWING");
		tglbtnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnPoint.setEnabled(true);
				tglbtnLine.setEnabled(true);
				tglbtnRectangle.setEnabled(true);
				tglbtnCircle.setEnabled(true);
				tglbtnDonut.setEnabled(true);

			}
		});

		tglbtnDrawing.setForeground(Color.WHITE);
		tglbtnDrawing.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnDrawing);
		tglbtnDrawing.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnDrawing = new GridBagConstraints();
		gbc_tglbtnDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDrawing.anchor = GridBagConstraints.WEST;
		gbc_tglbtnDrawing.gridx = 0;
		gbc_tglbtnDrawing.gridy = 5;
		pnlWest.add(tglbtnDrawing, gbc_tglbtnDrawing);
		tglbtnDrawing.setPreferredSize(new Dimension(180, 50));

		JPanel pnlEast = new JPanel();
		pnlEast.setBackground(Color.WHITE);
		contentPane.add(pnlEast, BorderLayout.EAST);
		GridBagLayout gbl_pnlEast = new GridBagLayout();
		gbl_pnlEast.columnWidths = new int[] { 180, 0 };
		gbl_pnlEast.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlEast.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlEast.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		pnlEast.setLayout(gbl_pnlEast);

		tglbtnCircle = new JToggleButton("CIRCLE");
		tglbtnCircle.setEnabled(false);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clickedLine = false;
				panel.clickedPoint = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = true;
				panel.clickedDonut = false;
				panel.isSelect = false;
			}
		});

		tglbtnRectangle = new JToggleButton("RECTANGLE");
		tglbtnRectangle.setEnabled(false);
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clickedLine = false;
				panel.clickedPoint = false;
				panel.clickedRectangle = true;
				panel.clickedCircle = false;
				panel.clickedDonut = false;
				panel.isSelect = false;
			}
		});

		tglbtnLine = new JToggleButton("LINE");
		tglbtnLine.setEnabled(false);
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clickedLine = true;
				panel.clickedPoint = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = false;
				panel.clickedDonut = false;
				panel.isSelect = false;
			}
		});

		tglbtnPoint = new JToggleButton("POINT");
		tglbtnPoint.setEnabled(false);
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clickedPoint = true;
				panel.clickedLine = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = false;
				panel.clickedDonut = false;
				panel.isSelect = false;

			}
		});
		tglbtnPoint.setForeground(Color.WHITE);
		tglbtnPoint.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnPoint);
		tglbtnPoint.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 1;
		pnlEast.add(tglbtnPoint, gbc_tglbtnPoint);
		tglbtnPoint.setPreferredSize(new Dimension(180, 50));
		tglbtnLine.setForeground(Color.WHITE);
		tglbtnLine.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnLine);
		tglbtnLine.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnLine.gridx = 0;
		gbc_tglbtnLine.gridy = 4;
		pnlEast.add(tglbtnLine, gbc_tglbtnLine);
		tglbtnLine.setPreferredSize(new Dimension(180, 50));
		tglbtnRectangle.setForeground(Color.WHITE);
		tglbtnRectangle.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnRectangle);
		tglbtnRectangle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnRectangle.gridx = 0;
		gbc_tglbtnRectangle.gridy = 7;
		pnlEast.add(tglbtnRectangle, gbc_tglbtnRectangle);
		tglbtnRectangle.setPreferredSize(new Dimension(180, 50));
		tglbtnCircle.setForeground(Color.WHITE);
		tglbtnCircle.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnCircle);
		tglbtnCircle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnCircle.gridx = 0;
		gbc_tglbtnCircle.gridy = 10;
		pnlEast.add(tglbtnCircle, gbc_tglbtnCircle);
		tglbtnCircle.setPreferredSize(new Dimension(180, 50));

		tglbtnDonut = new JToggleButton("DONUT");
		tglbtnDonut.setEnabled(false);
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clickedLine = false;
				panel.clickedPoint = false;
				panel.clickedRectangle = false;
				panel.clickedCircle = false;
				panel.clickedDonut = true;
				panel.isSelect = false;
			}
		});
		tglbtnDonut.setForeground(Color.WHITE);
		tglbtnDonut.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnDonut);
		tglbtnDonut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonut.gridx = 0;
		gbc_tglbtnDonut.gridy = 13;
		pnlEast.add(tglbtnDonut, gbc_tglbtnDonut);
		tglbtnDonut.setPreferredSize(new Dimension(180, 50));

	}

	public Dimension getTglbtnSelectionPreferredSize() {
		return tglbtnSelection.getPreferredSize();
	}

	public void setTglbtnSelectionPreferredSize(Dimension preferredSize) {
		tglbtnSelection.setPreferredSize(preferredSize);
	}
}
