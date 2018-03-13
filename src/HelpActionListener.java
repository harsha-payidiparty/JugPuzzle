package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * The HelpActionListener gets called when the user clicks the help button.
 * The method of this class then gives a message displaying the rules of how the
 * Jug Puzzle game works. *
 */
public class HelpActionListener implements ActionListener {	
	/* 
	 * The ActionPerfomed method opens up a message box displaying the game rules for the 
	 * Jug Puzzle. The dialog box can be closed with the default close button.
	 */
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"A Jug Puzzle consists of three Jugs with capacities 8,5 and 3. \n" + 
				"Initially, jug 1 is full, the other two are empty. You must spill \n" + 
				"liquid between the jugs until both jugs 1 and 2 contain 4 units \n" + "of liquid each.",
				"Instructions", JOptionPane.INFORMATION_MESSAGE);			
	}	
}
