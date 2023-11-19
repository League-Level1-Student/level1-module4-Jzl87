package _06_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel answer = new JLabel();

	JTextField firstInput = new JTextField(8);
	JTextField secondInput = new JTextField(8);

	JButton button1 = new JButton("add");
	JButton button2 = new JButton("subtract");
	JButton button3 = new JButton("multiply");
	JButton button4 = new JButton("divide");

	

	public void setup() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);

		panel.add(firstInput);
		panel.add(secondInput);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(answer);

		frame.pack();

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}

	public int add(int value1, int value2) {
		int answer = value1 + value2;
		System.out.println(answer);
		return answer;
	}

	public int subtract(int value1, int value2) {
		int answer = value1 - value2;
		System.out.println(answer);
		return answer;
	}

	public double multiply(double value1, double value2) {
		double answer = value1 * value2;
		System.out.println(answer);
		return answer;
	}

	public double divide(double value1, double value2) {
		double answer = value1 / value2;
		System.out.println(answer);
		return answer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String text1 = firstInput.getText();
		String text2 = secondInput.getText();

		int value1 = Integer.parseInt(text1);
		int value2 = Integer.parseInt(text2);
		
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {

			answer.setText("" + add(value1, value2));
		} else if (buttonPressed == button2) {
			answer.setText("" + subtract(value1, value2));
		} else if (buttonPressed == button3) {
			answer.setText("" + multiply(value1, value2));
		} else {
			answer.setText("" + divide(value1, value2));
		}
		frame.pack();
	}
}
