package _03_typing_tutor;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	
	JFrame 	frame = new JFrame();
	JPanel 	panel = new JPanel();
	JLabel  label = new JLabel();
	
	char currentLetter;
	
	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		currentLetter = generateRandomLetter();
		label.setText("currentLetter");
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		label.addKeyListener(this);
		
		panel.add(label);
		frame.add(panel);
		
		frame.pack();
		
		
	}
	
	public char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == currentLetter) {
			panel.setBackground(Color.GREEN);
		} else {
			panel.setBackground(Color.RED);

		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		
		label.setText("" + currentLetter);
		System.out.println(currentLetter);
		
	}
}
