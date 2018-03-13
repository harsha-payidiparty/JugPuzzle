package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * The ButtonActionListener class gets called when the user presses the buttons
 * for jug 1,2,3. It gets the two jugs the user wants to make the move() from the 
 * JugPuzzle class. If the user has won the game, then it notifies them and prompts
 * them to start a new game or exit.
 */
public class ButtonActionListener implements ActionListener {
	//Gets the jugPuzzle object created in JugPuzzleGUIController.
	JugPuzzle jugPuzzle=JugPuzzleGUIController.getJugPuzzle();
	/* 
	 * The actionPerfomed method gets the two jugs the user has selected and stores
	 * them in two varaible's which were created in JugPuzzleGUIController called firstclick
	 * and secondclick. It then passes those 2 integers as an index for moves() from JugPuzzle.
	 */
	public void actionPerformed(ActionEvent e) {	
		if (jugPuzzle.getIsPuzzleSolved() == false) {
			//checks if the first jug has been selected yet,
			//if not then it stores the button chosen in the variable firstclick.
			if (JugPuzzleGUIController.firstclick == -1) {
				if (e.getActionCommand() == "Capacity: 8") {
					JugPuzzleGUIController.firstclick = 0;
				}
				if (e.getActionCommand() == "Capacity: 5") {
					JugPuzzleGUIController.firstclick = 1;
				}
				if (e.getActionCommand() == "Capacity: 3") {
					JugPuzzleGUIController.firstclick = 2;
				}
			}
			//stores the second jug selected in the secondclick variable, 
			//since the first jug has already been done.		
			else  {					 
				if (e.getActionCommand() == "Capacity: 8") {
					JugPuzzleGUIController.secondclick = 0;
				}
				if (e.getActionCommand() == "Capacity: 5") {
					JugPuzzleGUIController.secondclick = 1;
				}
				if (e.getActionCommand() == "Capacity: 3") {
					JugPuzzleGUIController.secondclick = 2;
				}
				//Makes the move using the two varaible's from firstclick/secondclick
				//as the index of Jug for move()
				jugPuzzle.move(JugPuzzleGUIController.firstclick, JugPuzzleGUIController.secondclick);	
				//Sets the value of firstclick and secondclick back to -1(initial value) after the move has been made
				JugPuzzleGUIController.setFirstClick(-1);
				JugPuzzleGUIController.setSecondClick(-1);
				//Opens a message box to notify that user has won the game
				if (jugPuzzle.getIsPuzzleSolved() == true){
					JOptionPane.showMessageDialog(null, "You have solved the Jug Puzzle!\n"
							+ "To start a new game, click reset.\n" + "Or to close the game, click quit", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		//If user has won the game and tries to make a move, message pop appears again and user must reset/close the game.
		else if (jugPuzzle.getIsPuzzleSolved() == true){
			JOptionPane.showMessageDialog(null, "You have solved the Jug Puzzle!\n"
					+ " To start a new game, click reset.\n" + "Or to close the game, click quit", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);	
		}		
	}
}

