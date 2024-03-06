package calculator2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class calculator2 {

	private JFrame frame;
	private JTextField textField;
	
	double first;
	double second;
	double result;
	String operation;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator2 window = new calculator2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculator2() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 294, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 18));
		textField.setBounds(10, 11, 256, 65);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		JButton btnBackspace = new JButton("<-");
		btnBackspace.setBackground(Color.DARK_GRAY);
		btnBackspace.setForeground(Color.white);
		
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String backSpace=null;
				if(textField.getText().length()>0)
				{
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace=str.toString();
					textField.setText(backSpace);
				}
				
			}
		});
		btnBackspace.setFont(new Font("Calibri", Font.BOLD, 18));
		btnBackspace.setBounds(10, 87, 65, 54);
		frame.getContentPane().add(btnBackspace);
		
		JButton btn7 = new JButton("7");
		btn7.setBackground(Color.DARK_GRAY);
		btn7.setForeground(Color.white);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn7.getText();
				textField.setText(number);
			}
		});
		btn7.setFont(new Font("Calibri", Font.BOLD, 18));
		btn7.setBounds(10, 140, 65, 54);
		frame.getContentPane().add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.setBackground(Color.DARK_GRAY);
		btn4.setForeground(Color.white);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn4.getText();
				textField.setText(number);
			}
		});
		btn4.setFont(new Font("Calibri", Font.BOLD, 18));
		btn4.setBounds(10, 191, 65, 54);
		frame.getContentPane().add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.setBackground(Color.DARK_GRAY);
		btn1.setForeground(Color.white);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn1.getText();
				textField.setText(number);
				
			}
		});
		btn1.setFont(new Font("Calibri", Font.BOLD, 18));
		btn1.setBounds(10, 244, 65, 54);
		frame.getContentPane().add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.setBackground(Color.DARK_GRAY);
		btn0.setForeground(Color.white);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn0.getText();
				textField.setText(number);
			}
		});
		btn0.setFont(new Font("Calibri", Font.BOLD, 18));
		btn0.setBounds(10, 296, 65, 54);
		frame.getContentPane().add(btn0);
		
		JButton btnClear = new JButton("C");
		btnClear.setBackground(Color.DARK_GRAY);
		btnClear.setForeground(Color.white);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
			}
		});
		btnClear.setFont(new Font("Calibri", Font.BOLD, 18));
		btnClear.setBounds(75, 87, 65, 54);
		frame.getContentPane().add(btnClear);
		
		JButton btn8 = new JButton("8");
		btn8.setBackground(Color.DARK_GRAY);
		btn8.setForeground(Color.white);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn8.getText();
				textField.setText(number);
			}
		});
		btn8.setFont(new Font("Calibri", Font.BOLD, 18));
		btn8.setBounds(75, 140, 65, 54);
		frame.getContentPane().add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.setBackground(Color.DARK_GRAY);
		btn5.setForeground(Color.white);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn5.getText();
				textField.setText(number);
			}
		});
		btn5.setFont(new Font("Calibri", Font.BOLD, 18));
		btn5.setBounds(75, 191, 65, 54);
		frame.getContentPane().add(btn5);
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(Color.DARK_GRAY);
		btn2.setForeground(Color.white);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn2.getText();
				textField.setText(number);
			}
		});
		btn2.setFont(new Font("Calibri", Font.BOLD, 18));
		btn2.setBounds(75, 244, 65, 54);
		frame.getContentPane().add(btn2);
		
		JButton btnDot = new JButton(".");
		btnDot.setBackground(Color.DARK_GRAY);
		btnDot.setForeground(Color.white);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btnDot.getText();
				textField.setText(number);
			}
		});
		btnDot.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDot.setBounds(75, 296, 65, 54);
		frame.getContentPane().add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setBackground(Color.DARK_GRAY);
		btnEqual.setForeground(Color.white);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String answer;
				second=Double.parseDouble(textField.getText());
				if(operation=="+")
				{
					result=first+second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-")
				{
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="*")
				{
					result=first*second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="/")
				{
					result=first/second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="%")
				{
					result=first%second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				
			}
		});
		btnEqual.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEqual.setBounds(141, 296, 65, 54);
		frame.getContentPane().add(btnEqual);
		
		JButton btnPercent = new JButton("%");
		btnPercent.setBackground(Color.DARK_GRAY);
		btnPercent.setForeground(Color.white);
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="%";
			}
		});
		btnPercent.setFont(new Font("Calibri", Font.BOLD, 18));
		btnPercent.setBounds(206, 296, 65, 54);
		frame.getContentPane().add(btnPercent);
		
		JButton btn3 = new JButton("3");
		btn3.setBackground(Color.DARK_GRAY);
		btn3.setForeground(Color.white);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn3.getText();
				textField.setText(number);
			}
		});
		btn3.setFont(new Font("Calibri", Font.BOLD, 18));
		btn3.setBounds(141, 244, 65, 54);
		frame.getContentPane().add(btn3);
		
		JButton btn6 = new JButton("6");
		btn6.setBackground(Color.DARK_GRAY);
		btn6.setForeground(Color.white);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn6.getText();
				textField.setText(number);
			}
		});
		btn6.setFont(new Font("Calibri", Font.BOLD, 18));
		btn6.setBounds(141, 191, 65, 54);
		frame.getContentPane().add(btn6);
		
		JButton btn9 = new JButton("9");
		btn9.setBackground(Color.DARK_GRAY);
		btn9.setForeground(Color.white);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn9.getText();
				textField.setText(number);
			}
		});
		btn9.setFont(new Font("Calibri", Font.BOLD, 18));
		btn9.setBounds(141, 140, 65, 54);
		frame.getContentPane().add(btn9);
		
		JButton btn00 = new JButton("00");
		btn00.setBackground(Color.DARK_GRAY);
		btn00.setForeground(Color.white);
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number=textField.getText()+btn00.getText();
				textField.setText(number);
			}
		});
		btn00.setFont(new Font("Calibri", Font.BOLD, 18));
		btn00.setBounds(141, 87, 65, 54);
		frame.getContentPane().add(btn00);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBackground(Color.DARK_GRAY);
		btnPlus.setForeground(Color.white);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="+";
			}
		});
		btnPlus.setFont(new Font("Calibri", Font.BOLD, 18));
		btnPlus.setBounds(206, 87, 65, 54);
		frame.getContentPane().add(btnPlus);
		
		JButton btnSub = new JButton("-");
		btnSub.setBackground(Color.DARK_GRAY);
		btnSub.setForeground(Color.white);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="-";
			}
		});
		btnSub.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSub.setBounds(206, 140, 65, 54);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.setBackground(Color.DARK_GRAY);
		btnMul.setForeground(Color.white);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="*";
			}
		});
		btnMul.setFont(new Font("Calibri", Font.BOLD, 18));
		btnMul.setBounds(206, 191, 65, 54);
		frame.getContentPane().add(btnMul);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBackground(Color.DARK_GRAY);
		btnDivide.setForeground(Color.white);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="/";
			}
		});
		btnDivide.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDivide.setBounds(206, 244, 65, 54);
		frame.getContentPane().add(btnDivide);
	}
}