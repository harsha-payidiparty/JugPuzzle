package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * We extend JLabel as a view on the Amounts of the 3 jugs implementing Observer
 */
public class GUI_View extends JLabel implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		Jug jug = (Jug)o;				
		this.setText("Amount: " + jug.getAmount());			
	}	
}


