package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgModifyDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtCenterX;
	public JTextField txtCenterY;
	public JTextField txtRadius;
	public JTextField txtInnerRadius;
	private JButton btnEdgeColor;
	private JButton btnInteriorColor;
	Donut d = new Donut();
	Color color;
	Color color_2;
	
	boolean cancel = false;

	
	
	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public JTextField getTxtCenterX() {
		return txtCenterX;
	}

	public void setTxtCenterX(JTextField txtCenterX) {
		this.txtCenterX = txtCenterX;
	}

	public JTextField getTxtCenterY() {
		return txtCenterY;
	}

	public void setTxtCenterY(JTextField txtCenterY) {
		this.txtCenterY = txtCenterY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public Donut getD() {
		return d;
	}

	public void setD(Donut d) {
		this.d = d;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		btnEdgeColor.setBackground(color);
		this.color = color;
	}

	public Color getColor_2() {
		return color_2;
	}

	public void setColor_2(Color color_2) {
		btnInteriorColor.setBackground(color_2);
		this.color_2 = color_2;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyDonut dialog = new DlgModifyDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyDonut() {
		setModal(true);
		setBounds(100, 100, 498, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("Center-x:");
			lblCenterX.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 0;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			txtCenterX = new JTextField();
			txtCenterX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.anchor = GridBagConstraints.WEST;
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.gridx = 1;
			gbc_txtCenterX.gridy = 1;
			contentPanel.add(txtCenterX, gbc_txtCenterX);
			txtCenterX.setColumns(10);
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
			txtCenterY = new JTextField();
			txtCenterY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
			gbc_txtCenterY.anchor = GridBagConstraints.WEST;
			gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterY.gridx = 1;
			gbc_txtCenterY.gridy = 3;
			contentPanel.add(txtCenterY, gbc_txtCenterY);
			txtCenterY.setColumns(10);
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
			JLabel lblInnerRadius = new JLabel("Inner radius:");
			lblInnerRadius.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 7;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			txtInnerRadius = new JTextField();
			txtInnerRadius.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
			gbc_txtInnerRadius.anchor = GridBagConstraints.WEST;
			gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerRadius.gridx = 1;
			gbc_txtInnerRadius.gridy = 7;
			contentPanel.add(txtInnerRadius, gbc_txtInnerRadius);
			txtInnerRadius.setColumns(10);
		}
		{
			btnEdgeColor = new JButton("CHOOSE EDGE COLOR");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose edge color", color);
					if(color!=null) {
						d.setColor(color);
						btnEdgeColor.setBackground(color);
					}
					else {
						color = btnEdgeColor.getBackground();
					}
					
				}
			});
			btnEdgeColor.setForeground(Color.WHITE);
			//btnEdgeColor.setBackground(Color.GRAY);
			btnEdgeColor.setFont(new Font("Times New Roman", Font.BOLD, 15));
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.anchor = GridBagConstraints.WEST;
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnEdgeColor.gridx = 1;
			gbc_btnEdgeColor.gridy = 9;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
			btnEdgeColor.setPreferredSize(new Dimension(250, 50));
		}
		{
			btnInteriorColor = new JButton("CHOOSE INTERIOR COLOR");
			btnInteriorColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color_2 = JColorChooser.showDialog(null, "Choose interior color", color_2);
					if(color_2!=null) {
						d.setInsideColor(color_2);
						btnInteriorColor.setBackground(color_2);
					}
					else
					{
						color_2 = btnInteriorColor.getBackground();
					}
					

				}
			});
			btnInteriorColor.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnInteriorColor.setForeground(Color.WHITE);
			//btnInteriorColor.setBackground(Color.GRAY);
			GridBagConstraints gbc_btnInteriorColor = new GridBagConstraints();
			gbc_btnInteriorColor.anchor = GridBagConstraints.WEST;
			gbc_btnInteriorColor.gridx = 1;
			gbc_btnInteriorColor.gridy = 11;
			contentPanel.add(btnInteriorColor, gbc_btnInteriorColor);
			btnInteriorColor.setPreferredSize(new Dimension(250, 50));

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
