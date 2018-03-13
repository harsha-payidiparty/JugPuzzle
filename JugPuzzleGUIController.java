package ca.utoronto.utm.jugpuzzle;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * This class allows the user to play the game of JugPuzzle. It
 * repeatedly asks the user for moves and then applies the moves and allows the user to see
 * the changes through a graphical user interface until the user solves the JugPuzzle.
 */
public class JugPuzzleGUIController extends JFrame{
	//We create two varaible's to hold the two jugs the user wants to spill from and to.
	public static int firstclick = -1;
	public static int secondclick = -1;
	
	//create 3 JButtons, one for each jug
	public static JButton j1 = new JButton("Capacity: 8");
	public static JButton j2 = new JButton("Capacity: 5");
	public static JButton j3 = new JButton("Capacity: 3");
	
	//create a JButton for the reset option
	public static JButton reset = new JButton("Reset");
	
	//Creates a jugPuzzle object	
	private static JugPuzzle jugPuzzle = new JugPuzzle();	
	
	/**
	 * Changes the value of the firstclick from -1 to 0<= newFirstClick <=2
	 * @param newFirstClick value of the index of the jug user selected 0,1,2\
	 */
	public static void setFirstClick(int newFirstClick) {
		firstclick = newFirstClick;
	}
	
	/**
	 * Changes the value of the secondclick from -1 to 0<= newSecondClick <=2
	 * @param newSecondClick value of the index of the jug user selected 0,1,2 
	 */
	public static void setSecondClick(int newSecondClick){
		secondclick = newSecondClick;		
	}	
	
	/**
	 * Runs the createAndShowGUI() method
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	/**
	 * @return the jugPuzzle 
	 */
	public static JugPuzzle getJugPuzzle() {
		return jugPuzzle;
	}
	
	/**
	 * Creates the JFrame GUI adding the JFrame with all the JButtons, JLabels and connecting
	 * the MVC model together
	 */
	public static void createAndShowGUI() {
		
		//Create an array for a GUI_view 
		ArrayList <GUI_View> arrayGUIView = new ArrayList<GUI_View>();		

		//Make 3 GUIViews for each of the jugs 0,1,2.
		int i;
		for (i=0; i< 3; i++) {
			arrayGUIView.add(new GUI_View());
			jugPuzzle.getJug(i).addObserver(arrayGUIView.get(i));
		}
		
		// Create the GUI controller to control the Model
		JFrame frame = new JFrame("JugPuzzle"); // Frame with title
		
		// When the JFrame is closed, the program ends!!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set frame size and disable the ability to resize the frame
		frame.setSize(725, 460);
		frame.setResizable(false);			
		
		//Create a panel and set the layout to null.
		JPanel panel = new JPanel ();
		panel.setLayout(null);				
		
		//Let's make the panel appealing by making the background white!
		panel.setBackground(Color.white);
		
		//Set the font style and size of the text inside each jug button
		j1.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16)); 
		j2.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16)); 
		j3.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16)); 

		//Set the sizes and placements of each jug button(exact location in the panel)
		j1.setBounds(10,310, 225, 65);
		j2.setBounds(250,310,225,65);
		j3.setBounds(490,310,225,65);	
		
		//Add the 3 jug buttons to the panel
		panel.add(j1);
		panel.add(j2);
		panel.add(j3);
		
		//Add a the water jug image to the panel to make it more visually appealing
		ImageIcon background_image = new ImageIcon(JugPuzzleGUIController.class.getResource("/Jug-1.png"));
		JLabel background = new JLabel(background_image);		
		background.setBounds(0, 0, 750, 300);
		panel.add(background);
				
		//Create a Help and Quit button
		JButton Help, Quit;	
		
		//Set the properties(font style, size) and set the location of the Help JButton on the panel. 
		Help = new JButton("Help");
		Help.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16)); 
		Help.setBounds(5,5,100,30);	
		
		//Create and add an ActionListener to the Help button
		HelpActionListener help_button = new HelpActionListener();
		Help.addActionListener(help_button);
		
		//add the Help JButton to the panel
		panel.add(Help);
		
		//Set the properties(font style, size) and set the location of the Quit JButton on the panel.
		Quit = new JButton("Quit");
		Quit.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16)); 
		Quit.setBounds(625,5,100,30);	
		
		//Create and add an ActionListener to the Quit button
		QuitActionListener Quit_ActionListener = new QuitActionListener(frame);
		Quit.addActionListener(Quit_ActionListener);
		
		//add the Quit JButton to the panel
		panel.add(Quit);
		
		//Set the properties(font style, size) and set the location of the Reset JButton on the panel.
		reset.setFont(new Font("Papyrus-Bold", Font.ITALIC, 16));
		reset.setBounds(50,380, 100, 30);
		
		//Add an ActionListener to the Reset JButton		
		ResetActionListener rst = new ResetActionListener();
		reset.addActionListener(rst);
		
		//Add the Reset JButton to the panel
		panel.add(reset);
		frame.getContentPane().add(reset);		
		
		//Add the 3 GUI views to the contentPane and set the location of each.
		frame.getContentPane().add(arrayGUIView.get(0));
		arrayGUIView.get(0).setBounds(90, 260, 300, 65);		
		frame.getContentPane().add(arrayGUIView.get(1));
		arrayGUIView.get(1).setBounds(330,260, 300, 65);		
		frame.getContentPane().add(arrayGUIView.get(2));
		arrayGUIView.get(2).setBounds(570,260,300,65);
		
		//Add the 3 JButtons to the contentPane
		frame.getContentPane().add(j1);
		frame.getContentPane().add(j2);
		frame.getContentPane().add(j3);	

		// Create 3 button press event handlers
		ButtonActionListener btl1 = new ButtonActionListener();
		j1.addActionListener(btl1);
		ButtonActionListener btl2 = new ButtonActionListener();
		j2.addActionListener(btl2);
		ButtonActionListener btl3 = new ButtonActionListener();
		j3.addActionListener(btl3);
		
		//Create a new View for moves adding it to the jugPuzzle as an observer
		GUI_View_Moves View_Moves = new GUI_View_Moves();
		jugPuzzle.addObserver(View_Moves);

		//Add the view for moves into contentPane and set the location.
		frame.getContentPane().add(View_Moves);
		View_Moves.setBounds(330,360,300,65);
	
		//Add the panel to the frame
		frame.add(panel);
		
		//Make the frame visible
		frame.setVisible(true);		
	}	
}
