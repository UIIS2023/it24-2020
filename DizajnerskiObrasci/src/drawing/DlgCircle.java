package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtCentarx;
	public JTextField txtCentary;
	public JTextField txtRadius;
	
	boolean cancel = true;

	

	public JTextField getTxtCentarx() {
		return txtCentarx;
	}

	public void setTxtCentarx(JTextField txtCentarx) {
		this.txtCentarx = txtCentarx;
	}

	public JTextField getTxtCentary() {
		return txtCentary;
	}

	public void setTxtCentary(JTextField txtCentary) {
		this.txtCentary = txtCentary;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCentarx = new JLabel("Center-x:");
			lblCentarx.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCentarx = new GridBagConstraints();
			gbc_lblCentarx.anchor = GridBagConstraints.EAST;
			gbc_lblCentarx.insets = new Insets(0, 0, 5, 5);
			gbc_lblCentarx.gridx = 0;
			gbc_lblCentarx.gridy = 0;
			contentPanel.add(lblCentarx, gbc_lblCentarx);
		}
		{
			txtCentarx = new JTextField();
			txtCentarx.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtCentarx.setEditable(false);
			GridBagConstraints gbc_txtCentarx = new GridBagConstraints();
			gbc_txtCentarx.insets = new Insets(0, 0, 5, 5);
			gbc_txtCentarx.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCentarx.gridx = 1;
			gbc_txtCentarx.gridy = 0;
			contentPanel.add(txtCentarx, gbc_txtCentarx);
			txtCentarx.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 3;
			gbc_lblRadius.gridy = 1;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			txtRadius.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 5);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 4;
			gbc_txtRadius.gridy = 1;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblCenary = new JLabel("Center-y:");
			lblCenary.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCenary = new GridBagConstraints();
			gbc_lblCenary.anchor = GridBagConstraints.EAST;
			gbc_lblCenary.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenary.gridx = 0;
			gbc_lblCenary.gridy = 2;
			contentPanel.add(lblCenary, gbc_lblCenary);
		}
		{
			txtCentary = new JTextField();
			txtCentary.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtCentary.setEditable(false);
			GridBagConstraints gbc_txtCentary = new GridBagConstraints();
			gbc_txtCentary.insets = new Insets(0, 0, 5, 5);
			gbc_txtCentary.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCentary.gridx = 1;
			gbc_txtCentary.gridy = 2;
			contentPanel.add(txtCentary, gbc_txtCentary);
			txtCentary.setColumns(10);
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
