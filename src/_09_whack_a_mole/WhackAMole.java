package _09_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame("Whack a mole for fame and glory");
	JPanel panel;
	Dimension average = new Dimension(400, 300);
	Dimension large = new Dimension(80, 32);
	Random ran = new Random();
	String mole = "MOLE!";
	int count = 0;
	int randomInt;

	Date tinder = new Date();

	public void setup() {

		int randomInt = ran.nextInt(24);

		panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(average);

		for (int i = 0; i < 24; i++) {

			if (i == randomInt) {
				JButton button = new JButton(mole);
				button.setPreferredSize(large);
				panel.add(button);
				button.addActionListener(this);
			} else {
				JButton button = new JButton();
				button.setPreferredSize(large);
				panel.add(button);
				button.addActionListener(this);
			}
		}

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.getText().equals(mole)) {
			frame.remove(panel);
			setup();
			count++;

			if (count >= 10) {
				endGame(tinder, count);
			}

		} else {
			speak("MONKEYYYYYYY");
		}
	}

	public static void main(String[] args) {
		new WhackAMole().setup();
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}
}
