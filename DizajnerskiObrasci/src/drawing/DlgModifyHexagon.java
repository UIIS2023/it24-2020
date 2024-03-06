package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import adapter.HexagonAdapter;

public class DlgModifyHexagon extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtRadius;
	
	private JButton btnEdgeColor;
	private JButton btnInteriorColor;

	HexagonAdapter h = new HexagonAdapter();

	Color color1;
	Color color2;

	boolean cancel = false;

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public HexagonAdapter getH() {
		return h;
	}

	public void setH(HexagonAdapter h) {
		this.h = h;
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		btnEdgeColor.setBackground(color1);
		this.color1 = color1;
		
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		btnInteriorColor.setBackground(color2);
		this.color2 = color2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgHexagon dialog = new DlgHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyHexagon() {
		setModal(true);
		setBounds(100, 100, 533, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("Center-x:");
			lblCenterX.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.anchor = GridBagConstraints.WEST;
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 0;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			txtX = new JTextField();
			txtX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.anchor = GridBagConstraints.WEST;
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.gridx = 1;
			gbc_txtCenterX.gridy = 1;
			contentPanel.add(txtX, gbc_txtCenterX);
			txtX.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 5;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			txtRadius.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.anchor = GridBagConstraints.WEST;
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 5;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblCenterY = new JLabel("Center-y:");
			lblCenterY.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 0;
			gbc_lblCenterY.gridy = 3;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			txtY = new JTextField();
			txtY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
			gbc_txtCenterY.anchor = GridBagConstraints.WEST;
			gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterY.gridx = 1;
			gbc_txtCenterY.gridy = 3;
			contentPanel.add(txtY, gbc_txtCenterY);
			txtY.setColumns(10);
		}
		{
			btnEdgeColor = new JButton("CHOOSE EDGE COLOR");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color1 = JColorChooser.showDialog(null, "Choose edge color", color1);
					h.setColor(color1);
					if(color1!=null) {
						h.setColor(color1);
						btnEdgeColor.setBackground(color1);
					}
					else {
						color1 = btnEdgeColor.getBackground();
					}

				}
				
			});
			btnEdgeColor.setForeground(Color.WHITE);
			//btnEdgeColor.setBackground(Color.GRAY);
			btnEdgeColor.setFont(new Font("Times New Roman", Font.BOLD, 15));
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnEdgeColor.gridx = 1;
			gbc_btnEdgeColor.gridy = 7;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
			btnEdgeColor.setPreferredSize(new Dimension(350, 50));
		}
		{
			btnInteriorColor = new JButton("CHOOSE INTERIOR COLOR");
			btnInteriorColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color2 = JColorChooser.showDialog(null, "Choose interior color", color2);
					h.setInsideColor(color2);
					if(color2!=null) {
						h.setInsideColor(color2);
						btnInteriorColor.setBackground(color2);
					}
					else
					{
						color2 = btnInteriorColor.getBackground();
					}

				}
			});
			btnInteriorColor.setForeground(Color.WHITE);
			//btnInteriorColor.setBackground(Color.GRAY);
			btnInteriorColor.setFont(new Font("Times New Roman", Font.BOLD, 15));
			GridBagConstraints gbc_btnInteriorColor = new GridBagConstraints();
			gbc_btnInteriorColor.gridx = 1;
			gbc_btnInteriorColor.gridy = 9;
			contentPanel.add(btnInteriorColor, gbc_btnInteriorColor);
			btnInteriorColor.setPreferredSize(new Dimension(350, 50));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						cancel = true;
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
