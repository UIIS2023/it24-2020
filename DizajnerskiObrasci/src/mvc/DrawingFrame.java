package mvc;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import drawing.DlgModifyCircle;
import drawing.DlgModifyDonut;
import drawing.DlgModifyLine;
import drawing.DlgModifyPoint;
import drawing.DlgRectangle;
import drawing.PnlDrawing;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class DrawingFrame extends JFrame implements PropertyChangeListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JToggleButton tglbtnSelection;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;

	JToggleButton tglbtnDelete;
	JToggleButton tglbtnModify;

	private Color color;
	private Color interiorColor;

	DrawingController controller;
	DrawingView panel = new DrawingView();
	private JToggleButton tglbtnHexagon;
	private JPanel panel_1;
	private JButton btnInteriorColor;
	private JButton btnColor;
	private JButton btnBringToFront;
	private JButton btnToBack;
	private JButton btnBringToBack;
	private JButton btnToFront;
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnExport;
	private JPanel panel_2;
	private JButton btnImport;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JList list;

	private DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
	private JButton btnLoadLogCommand;

	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 515);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("IT 27-2020 Isaku Dajana");

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e);
			}
		});
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

		tglbtnDelete = new JToggleButton("DELETE");
		tglbtnDelete.setEnabled(false);
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete = true;
				controller.select = false;
				controller.modify = false;
				tglbtnPoint.setEnabled(false);
				tglbtnLine.setEnabled(false);
				tglbtnRectangle.setEnabled(false);
				tglbtnCircle.setEnabled(false);
				tglbtnDonut.setEnabled(false);
				tglbtnHexagon.setEnabled(false);
				buttonGroup_1.clearSelection();

				controller.delete();
				repaint();

			}
		});

		tglbtnSelection = new JToggleButton("SELECT");
		tglbtnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.select = true;
				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.clickedRectangle = false;
				controller.clickedHexagon = false;
				controller.modify = false;
				controller.delete = false;
				buttonGroup_1.clearSelection();

				tglbtnPoint.setEnabled(false);
				tglbtnLine.setEnabled(false);
				tglbtnRectangle.setEnabled(false);
				tglbtnCircle.setEnabled(false);
				tglbtnDonut.setEnabled(false);
				tglbtnHexagon.setEnabled(false);
			}
		});

		tglbtnModify = new JToggleButton("MODIFY");
		tglbtnModify.setEnabled(false);
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.select = false;
				controller.modify = true;
				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedRectangle = false;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.delete = false;
				buttonGroup_1.clearSelection();

				tglbtnPoint.setEnabled(false);
				tglbtnLine.setEnabled(false);
				tglbtnRectangle.setEnabled(false);
				tglbtnCircle.setEnabled(false);
				tglbtnDonut.setEnabled(false);
				tglbtnHexagon.setEnabled(false);

				controller.modify();
				repaint();

			}
		});
		pnlWest.setLayout(new GridLayout(0, 1, 0, 0));

		tglbtnModify.setForeground(Color.WHITE);
		tglbtnModify.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnModify);
		buttonGroup.add(tglbtnDelete);

		tglbtnModify.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlWest.add(tglbtnModify);
		tglbtnModify.setPreferredSize(new Dimension(200, 50));

		tglbtnSelection.setForeground(Color.WHITE);
		tglbtnSelection.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnSelection);
		tglbtnSelection.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlWest.add(tglbtnSelection);
		tglbtnSelection.setPreferredSize(new Dimension(200, 50));
		tglbtnDelete.setForeground(Color.WHITE);
		tglbtnDelete.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlWest.add(tglbtnDelete);
		tglbtnDelete.setPreferredSize(new Dimension(200, 50));

		JToggleButton tglbtnDrawing = new JToggleButton("DRAWING");
		tglbtnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnPoint.setEnabled(true);
				tglbtnLine.setEnabled(true);
				tglbtnRectangle.setEnabled(true);
				tglbtnCircle.setEnabled(true);
				tglbtnDonut.setEnabled(true);
				tglbtnHexagon.setEnabled(true);

			}
		});

		tglbtnDrawing.setForeground(Color.WHITE);
		tglbtnDrawing.setBackground(Color.GRAY);
		buttonGroup.add(tglbtnDrawing);
		tglbtnDrawing.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlWest.add(tglbtnDrawing);
		tglbtnDrawing.setPreferredSize(new Dimension(200, 50));

		btnBringToFront = new JButton("BRING TO FRONT");
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToFront();
				repaint();
			}
		});

		btnToFront = new JButton("TO FRONT");
		btnToFront.setPreferredSize(new Dimension(200, 50));
		btnToFront.setForeground(Color.WHITE);
		btnToFront.setBackground(Color.GRAY);
		btnToFront.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlWest.add(btnToFront);
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toFront();
				repaint();
			}
		});

		btnBringToFront.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBringToFront.setForeground(Color.WHITE);
		btnBringToFront.setBackground(Color.GRAY);
		btnBringToFront.setPreferredSize(new Dimension(200, 50));
		pnlWest.add(btnBringToFront);

		btnToBack = new JButton("TO BACK");
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toBack();
				repaint();
			}
		});
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBack.gridx = 0;
		gbc_btnToBack.gridy = 9;
		btnToBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnToBack.setForeground(Color.WHITE);
		btnToBack.setBackground(Color.GRAY);
		btnToBack.setPreferredSize(new Dimension(200, 50));
		pnlWest.add(btnToBack, gbc_btnToBack);

		btnBringToBack = new JButton("BRING TO BACK");
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToBack();
				repaint();
			}
		});
		btnBringToBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBringToBack.setForeground(Color.WHITE);
		btnBringToBack.setBackground(Color.GRAY);
		btnBringToBack.setPreferredSize(new Dimension(200, 50));
		pnlWest.add(btnBringToBack);

		JPanel pnlEast = new JPanel();
		pnlEast.setBackground(Color.WHITE);
		contentPane.add(pnlEast, BorderLayout.EAST);
		pnlEast.setLayout(new GridLayout(0, 1, 0, 0));

		tglbtnPoint = new JToggleButton("POINT");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.clickedPoint = true;
				controller.clickedLine = false;
				controller.clickedRectangle = false;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.clickedHexagon = false;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
			}
		});
		tglbtnPoint.setEnabled(false);

		tglbtnPoint.setForeground(Color.WHITE);
		tglbtnPoint.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnPoint);
		tglbtnPoint.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlEast.add(tglbtnPoint);
		tglbtnPoint.setPreferredSize(new Dimension(200, 50));

		tglbtnLine = new JToggleButton("LINE");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startPoint = null;
				controller.clickedPoint = false;
				controller.clickedLine = true;
				controller.clickedRectangle = false;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.clickedHexagon = false;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
			}
		});
		tglbtnLine.setEnabled(false);
		tglbtnLine.setForeground(Color.WHITE);
		tglbtnLine.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnLine);
		tglbtnLine.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlEast.add(tglbtnLine);
		tglbtnLine.setPreferredSize(new Dimension(200, 50));

		tglbtnRectangle = new JToggleButton("RECTANGLE");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedRectangle = true;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
				controller.clickedHexagon = false;
			}
		});
		tglbtnRectangle.setEnabled(false);
		tglbtnRectangle.setForeground(Color.WHITE);
		tglbtnRectangle.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnRectangle);
		tglbtnRectangle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlEast.add(tglbtnRectangle);
		tglbtnRectangle.setPreferredSize(new Dimension(200, 50));

		tglbtnCircle = new JToggleButton("CIRCLE");
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedRectangle = false;
				controller.clickedCircle = true;
				controller.clickedDonut = false;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
				controller.clickedHexagon = false;
			}
		});
		tglbtnCircle.setEnabled(false);
		tglbtnCircle.setForeground(Color.WHITE);
		tglbtnCircle.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnCircle);
		tglbtnCircle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlEast.add(tglbtnCircle);
		tglbtnCircle.setPreferredSize(new Dimension(200, 50));

		tglbtnDonut = new JToggleButton("DONUT");
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedRectangle = false;
				controller.clickedCircle = false;
				controller.clickedDonut = true;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
				controller.clickedHexagon = false;
			}
		});
		tglbtnDonut.setEnabled(false);

		tglbtnDonut.setForeground(Color.WHITE);
		tglbtnDonut.setBackground(Color.GRAY);
		buttonGroup_1.add(tglbtnDonut);
		tglbtnDonut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlEast.add(tglbtnDonut);
		tglbtnDonut.setPreferredSize(new Dimension(200, 50));

		tglbtnHexagon = new JToggleButton("HEXAGON");
		buttonGroup_1.add(tglbtnHexagon);
		tglbtnHexagon.setForeground(Color.WHITE);
		tglbtnHexagon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tglbtnHexagon.setBackground(Color.GRAY);
		tglbtnHexagon.setPreferredSize(new Dimension(200, 50));

		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.clickedHexagon = true;
				controller.clickedPoint = false;
				controller.clickedLine = false;
				controller.clickedRectangle = false;
				controller.clickedCircle = false;
				controller.clickedDonut = false;
				controller.select = false;
				controller.modify = false;
				controller.delete = false;
			}
		});
		tglbtnHexagon.setEnabled(false);
		pnlEast.add(tglbtnHexagon);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setBackground(color.WHITE);

		btnColor = new JButton("EDGE COLOR");
		btnColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnColor.setForeground(Color.WHITE);
		btnColor.setPreferredSize(new Dimension(200, 40));
		btnColor.setBackground(Color.black);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose color", color);
				if (color != null) {
					btnColor.setBackground(color);
				}
			}
		});

		btnUndo = new JButton("UNDO");
		btnUndo.setEnabled(false);
		panel_1.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				repaint();
			}
		});
		btnUndo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUndo.setForeground(Color.WHITE);
		btnUndo.setBackground(Color.GRAY);
		btnUndo.setPreferredSize(new Dimension(200, 40));

		btnRedo = new JButton("REDO");
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				repaint();
			}
		});
		btnRedo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRedo.setForeground(Color.WHITE);
		btnRedo.setBackground(Color.GRAY);
		btnRedo.setPreferredSize(new Dimension(200, 40));
		panel_1.add(btnRedo);
		panel_1.add(btnColor);

		btnInteriorColor = new JButton("INTERIOR COLOR");
		btnInteriorColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInteriorColor.setPreferredSize(new Dimension(200, 40));
		btnInteriorColor.setForeground(Color.WHITE);
		btnInteriorColor.setBackground(Color.LIGHT_GRAY);
		btnInteriorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interiorColor = JColorChooser.showDialog(null, "Choose color", interiorColor);
				if (interiorColor != null) {
					btnInteriorColor.setBackground(interiorColor);
				}
			}
		});

		panel_1.add(btnInteriorColor);

		btnLoadLogCommand = new JButton("LOAD LOG COMMAND");
		btnLoadLogCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadLogCommand();
			}
		});
		btnLoadLogCommand.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLoadLogCommand.setPreferredSize(new Dimension(200, 40));
		btnLoadLogCommand.setForeground(Color.WHITE);
		btnLoadLogCommand.setBackground(Color.gray);
		panel_1.add(btnLoadLogCommand);

		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setBackground(color.white);

		panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 5, 5));

		btnExport = new JButton("EXPORT");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					controller.exportShapes(fileChooser.getSelectedFile().getAbsolutePath());
				}

			}
		});
		panel_4.add(btnExport);
		btnExport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnExport.setPreferredSize(new Dimension(200, 40));
		btnExport.setForeground(Color.WHITE);
		btnExport.setBackground(Color.GRAY);

		btnImport = new JButton("IMPORT");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					controller.importShapes(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		panel_4.add(btnImport);
		btnImport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnImport.setPreferredSize(new Dimension(200, 40));
		btnImport.setForeground(Color.WHITE);
		btnImport.setBackground(Color.GRAY);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setPreferredSize(new Dimension(800, 100));
		panel_2.add(panel_3);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setPreferredSize(new Dimension(780, 90));
		panel_3.add(scrollPane);

		list = new JList();
		list.setModel(defaultListModel);
		scrollPane.setViewportView(list);
		panel_3.setOpaque(true);

	}

	public DrawingView getView() {
		return panel;
	}

	public void setView(DrawingView view) {
		this.panel = view;
	}

	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public JButton getBtnInteriorColor() {
		return btnInteriorColor;
	}

	public void setBtnInteriorColor(JButton btnInteriorColor) {
		this.btnInteriorColor = btnInteriorColor;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Delete button enable")) {
			tglbtnDelete.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Delete button disable")) {
			tglbtnDelete.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Modify button enable")) {
			tglbtnModify.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Modify button disable")) {
			tglbtnModify.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Undo button enable")) {
			btnUndo.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Undo button disable")) {
			btnUndo.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Redo button enable")) {
			btnRedo.setEnabled((boolean) evt.getNewValue());
		} else if (evt.getPropertyName().equals("Redo button disable")) {
			btnRedo.setEnabled((boolean) evt.getNewValue());
		}

	}

	public DefaultListModel<String> getDefaultListModel() {
		return defaultListModel;
	}

	public void setDefaultListModel(DefaultListModel<String> defaultListModel) {
		this.defaultListModel = defaultListModel;
	}

}
