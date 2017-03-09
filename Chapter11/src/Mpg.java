import javax.swing.*;
import java.awt.event.*;
public class Mpg extends JFrame{
	private JPanel panel; // panel
	private JLabel messageLabelgallons;
	private JLabel messageLabelmiles;
	private JTextField gallonsTextField;
	private JTextField milesTextField;
	private JButton mpgbutton; //button
	private final int windowwidth = 500;
	private final int windowheight = 500;
	
	//constructor
	public Mpg(){
		//set the window title
		setTitle("MPG calculator");
		//set the size of window
		setSize(windowheight, windowwidth);
		//when close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//build panel
		buildPanel();
		//add the panel
		add(panel);
		//display the window
		setVisible(true);
	}
	
	private void buildPanel(){
		messageLabelgallons = new JLabel("Enter number of gallons: ");
		gallonsTextField = new JTextField(10);
		messageLabelmiles = new JLabel("enter miles: ");
		milesTextField = new JTextField(10);
		
		//create button to calculate
		mpgbutton = new JButton("Calculate MPG");
		mpgbutton.addActionListener(new CalculateMPG());
		//add items to panel
		panel = new JPanel();
		panel.add(messageLabelgallons);
		panel.add(gallonsTextField);
		panel.add(messageLabelmiles);
		panel.add(milesTextField);
		panel.add(mpgbutton);
	}

	public class CalculateMPG implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String inputone;
			String inputtwo;
			double mpg;
			//inputting data
			inputone = gallonsTextField.getText();
			inputtwo = milesTextField.getText();
			mpg = (Double.parseDouble(inputtwo) / Double.parseDouble(inputone));
			//outputting
			JOptionPane.showMessageDialog(null, "MPG of cars is " + mpg);
		}
	}
	public static void main(String [] args){
		new Mpg();
	}
}

