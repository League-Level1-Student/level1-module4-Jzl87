package _10_slot_machine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gamblingAddict {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();

	Random ran = new Random();

	public void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		slot1 = randomizeLabel();
		panel.add(slot1);
		slot2 = randomizeLabel();
		panel.add(slot2);
		slot3 = randomizeLabel();
		panel.add(slot3);
		
		frame.pack();
	}

	public static void main(String[] args) {
		new gamblingAddict().setup();
	}

	public JLabel randomizeLabel() {
		int randomInt = ran.nextInt(3);

		try {

			if (randomInt == 0) {

				return createLabelImage("lime.jpg");
			} else if (randomInt == 1) {
				return createLabelImage("orange.jpg");
			} else {
				return createLabelImage("cherry.jpg");
			}
		} catch (Exception e) {

		}
		return null;

	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
}
