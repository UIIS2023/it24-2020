package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgModifyLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtStartPointX;
	public JTextField txtStartPointY;
	public JTextField txtEndPointX;
	public JTextField txtEndPointY;
	Line line = new Line();
	Color color;
	private JButton btnColor;

	boolean cancel = false;
	
	

	public JTextField getTxtStartPointX() {
		return txtStartPointX;
	}

	public void setTxtStartPointX(JTextField txtStartPointX) {
		this.txtStartPointX = txtStartPointX;
	}

	public JTextField getTxtStartPointY() {
		return txtStartPointY;
	}

	public void setTxtStartPointY(JTextField txtStartPointY) {
		this.txtStartPointY = txtStartPointY;
	}

	public JTextField getTxtEndPointX() {
		return txtEndPointX;
	}

	public void setTxtEndPointX(JTextField txtEndPointX) {
		this.txtEndPointX = txtEndPointX;
	}

	public JTextField getTxtEndPointY() {
		return txtEndPointY;
	}

	public void setTxtEndPointY(JTextField txtEndPointY) {
		this.txtEndPointY = txtEndPointY;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		btnColor.setBackground(color);
		this.color = color;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyLine dialog = new DlgModifyLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyLine() {
		setModal(true);
		setBounds(100, 100, 441, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPointX = new JLabel("Start point-x:");
			lblStartPointX.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 0;
			gbc_lblStartPointX.gridy = 1;
			contentPanel.add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			txtStartPointX = new JTextField();
			txtStartPointX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtStartPointX = new GridBagConstraints();
			gbc_txtStartPointX.anchor = GridBagConstraints.WEST;
			gbc_txtStartPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointX.gridx = 1;
			gbc_txtStartPointX.gridy = 1;
			contentPanel.add(txtStartPointX, gbc_txtStartPointX);
			txtStartPointX.setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("Start point-y:");
			lblStartPointY.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 0;
			gbc_lblStartPointY.gridy = 3;
			contentPanel.add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			txtStartPointY = new JTextField();
			txtStartPointY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtStartPointY = new GridBagConstraints();
			gbc_txtStartPointY.anchor = GridBagConstraints.WEST;
			gbc_txtStartPointY.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointY.gridx = 1;
			gbc_txtStartPointY.gridy = 3;
			contentPanel.add(txtStartPointY, gbc_txtStartPointY);
			txtStartPointY.setColumns(10);
		}
		{
			JLabel lblEndPointX = new JLabel("End point-x:");
			lblEndPointX.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 0;
			gbc_lblEndPointX.gridy = 5;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			txtEndPointX = new JTextField();
			txtEndPointX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtEndPointX = new GridBagConstraints();
			gbc_txtEndPointX.anchor = GridBagConstraints.WEST;
			gbc_txtEndPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndPointX.gridx = 1;
			gbc_txtEndPointX.gridy = 5;
			contentPanel.add(txtEndPointX, gbc_txtEndPointX);
			txtEndPointX.setColumns(10);
		}
		{
			JLabel lblEndPointY = new JLabel("End point-y:");
			lblEndPointY.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointY.gridx = 0;
			gbc_lblEndPointY.gridy = 7;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			txtEndPointY = new JTextField();
			txtEndPointY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtEndPointY = new GridBagConstraints();
			gbc_txtEndPointY.anchor = GridBagConstraints.WEST;
			gbc_txtEndPointY.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndPointY.gridx = 1;
			gbc_txtEndPointY.gridy = 7;
			contentPanel.add(txtEndPointY, gbc_txtEndPointY);
			txtEndPointY.setColumns(10);
		}
		{
			btnColor = new JButton("CHOOSE COLOR");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose edge color", color);
					line.setColor(color);
					if(color!=null) {
						line.setColor(color);
						btnColor.setBackground(color);
					}
					else {
						color = btnColor.getBackground();
					}

					
				}
			});
			btnColor.setForeground(Color.WHITE);
			btnColor.setFont(new Font("Times New Roman", Font.BOLD, 15));
			//btnColor.setBackground(Color.GRAY);
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.anchor = GridBagConstraints.WEST;
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 9;
			contentPanel.add(btnColor, gbc_btnColor);
			btnColor.setPreferredSize(new Dimension(200, 50));

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
