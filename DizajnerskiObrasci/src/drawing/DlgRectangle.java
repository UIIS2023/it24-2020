package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

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

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtULPX;
	public JTextField txtULPY;
	public JTextField txtW;
	public JTextField txtH;
	Rectangle r = new Rectangle();

    
    boolean cancel = true;
    
    

	public JTextField getTxtULPX() {
		return txtULPX;
	}

	public void setTxtULPX(JTextField txtULPX) {
		this.txtULPX = txtULPX;
	}

	public JTextField getTxtULPY() {
		return txtULPY;
	}

	public void setTxtULPY(JTextField txtULPY) {
		this.txtULPY = txtULPY;
	}

	public JTextField getTxtW() {
		return txtW;
	}

	public void setTxtW(JTextField txtW) {
		this.txtW = txtW;
	}

	public JTextField getTxtH() {
		return txtH;
	}

	public void setTxtH(JTextField txtH) {
		this.txtH = txtH;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
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
			DlgModifyRectangle dialog = new DlgModifyRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 475, 438);
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
			JLabel lblULPX = new JLabel("Upper left point-x:");
			lblULPX.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblULPX = new GridBagConstraints();
			gbc_lblULPX.anchor = GridBagConstraints.EAST;
			gbc_lblULPX.insets = new Insets(0, 0, 5, 5);
			gbc_lblULPX.gridx = 0;
			gbc_lblULPX.gridy = 1;
			contentPanel.add(lblULPX, gbc_lblULPX);
		}
		{
			txtULPX = new JTextField();
			txtULPX.setEditable(false);
			txtULPX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtULPX = new GridBagConstraints();
			gbc_txtULPX.anchor = GridBagConstraints.WEST;
			gbc_txtULPX.insets = new Insets(0, 0, 5, 0);
			gbc_txtULPX.gridx = 1;
			gbc_txtULPX.gridy = 1;
			contentPanel.add(txtULPX, gbc_txtULPX);
			txtULPX.setColumns(10);
		}
		{
			JLabel lblULPY = new JLabel("Upper left point-y:");
			lblULPY.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblULPY = new GridBagConstraints();
			gbc_lblULPY.anchor = GridBagConstraints.EAST;
			gbc_lblULPY.insets = new Insets(0, 0, 5, 5);
			gbc_lblULPY.gridx = 0;
			gbc_lblULPY.gridy = 3;
			contentPanel.add(lblULPY, gbc_lblULPY);
		}
		{
			txtULPY = new JTextField();
			txtULPY.setEditable(false);
			txtULPY.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtULPY = new GridBagConstraints();
			gbc_txtULPY.anchor = GridBagConstraints.WEST;
			gbc_txtULPY.insets = new Insets(0, 0, 5, 0);
			gbc_txtULPY.gridx = 1;
			gbc_txtULPY.gridy = 3;
			contentPanel.add(txtULPY, gbc_txtULPY);
			txtULPY.setColumns(10);
		}
		{
			JLabel lblW = new JLabel("Width:");
			lblW.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblW = new GridBagConstraints();
			gbc_lblW.anchor = GridBagConstraints.EAST;
			gbc_lblW.insets = new Insets(0, 0, 5, 5);
			gbc_lblW.gridx = 0;
			gbc_lblW.gridy = 5;
			contentPanel.add(lblW, gbc_lblW);
		}
		{
			txtW = new JTextField();
			txtW.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtW = new GridBagConstraints();
			gbc_txtW.anchor = GridBagConstraints.WEST;
			gbc_txtW.insets = new Insets(0, 0, 5, 0);
			gbc_txtW.gridx = 1;
			gbc_txtW.gridy = 5;
			contentPanel.add(txtW, gbc_txtW);
			txtW.setColumns(10);
		}
		{
			JLabel lblH = new JLabel("Height:");
			lblH.setFont(new Font("Times New Roman", Font.BOLD, 18));
			GridBagConstraints gbc_lblH = new GridBagConstraints();
			gbc_lblH.anchor = GridBagConstraints.EAST;
			gbc_lblH.insets = new Insets(0, 0, 5, 5);
			gbc_lblH.gridx = 0;
			gbc_lblH.gridy = 7;
			contentPanel.add(lblH, gbc_lblH);
		}
		{
			txtH = new JTextField();
			txtH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtH = new GridBagConstraints();
			gbc_txtH.anchor = GridBagConstraints.WEST;
			gbc_txtH.insets = new Insets(0, 0, 5, 0);
			gbc_txtH.gridx = 1;
			gbc_txtH.gridy = 7;
			contentPanel.add(txtH, gbc_txtH);
			txtH.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancel = false;

						setVisible(false);
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
