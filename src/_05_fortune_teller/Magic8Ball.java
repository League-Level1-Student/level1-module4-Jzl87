package _05_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	public static void main(String[] args) {
		Random ran = new Random();
		
		int randomNum = ran.nextInt();
		
		System.out.println(randomNum);
		
		String question = JOptionPane.showInputDialog("What is your question?");
		
		if (randomNum == 0) {
			JOptionPane.showMessageDialog(null, "YES");
		} else if (randomNum == 1) {
			JOptionPane.showMessageDialog(null, "no");
		} else if (randomNum == 2) {
			JOptionPane.showMessageDialog(null, "Maybe?");
		} else {
			JOptionPane.showMessageDialog(null, "AGGGGGHH");
		}
	}
	// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"
	
	// 3. Print out this variable

	// 4. Get the user to enter a question for the 8 ball

	// 5. If the random number is 0

	// -- tell the user "Yes"

	// 6. If the random number is 1

	// -- tell the user "No"

	// 7. If the random number is 2

	// -- tell the user "Maybe you should ask Google?"

	// 8. If the random number is 3

	// -- write your own answer

}
