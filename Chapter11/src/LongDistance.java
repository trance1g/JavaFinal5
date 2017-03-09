import javax.swing.*;
import java.awt.event.*;
public class LongDistance extends JFrame {
	
	private JPanel panel; 
	private JLabel messageLabel;
	private JTextField minutesTextField;
	
	private JRadioButton daybutton;
	private JRadioButton eveningbutton;
	private JRadioButton offpeakbutton;
	private ButtonGroup radiobuttongroup;
	
	private final int windowheight = 300;
	private final int windowwidth = 300;
	
	//constructor
	public LongDistance(){
		//set the window title
				setTitle("Long Distance calls");
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
		//create label, text field and radio button
		messageLabel = new JLabel("Enter number of minutes");
		minutesTextField = new JTextField(10);
		daybutton = new JRadioButton("Day time");
		eveningbutton = new JRadioButton("Evening time");
		offpeakbutton = new JRadioButton("Off-Peak");
	//group the radio buttons
		radiobuttongroup = new ButtonGroup();
		radiobuttongroup.add(daybutton);
		radiobuttongroup.add(eveningbutton);
		radiobuttongroup.add(offpeakbutton);
		
		//add action listener to radio buttons
		daybutton.addActionListener
		(new RadioButtonListener());
		eveningbutton.addActionListener
		(new RadioButtonListener());
		offpeakbutton.addActionListener
		(new RadioButtonListener());
		
		//create panel
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(minutesTextField);
		panel.add(daybutton);
		panel.add(eveningbutton);
		panel.add(offpeakbutton);
		
		private class RadioButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String input; //hold user input
				double result = 0.0;
				input = minutesTextField.getText();
				//determine button click
				if(e.getSource() == daybutton){
					result = Double.parseDouble(input) *0.07;
				}
				else if (e.getSource() == eveningbutton){
					result = Double.parseDouble(input) *0.12;
				}
				else if (e.getSource() == offpeakbutton){
					result = Double.parseDouble(input)*0.05;
				}
				//display
				JOptionPane.showMessageDialog(null, "Call charges are:" + result);
			}//end action performed
		}//end class radio button
	}
	public static void main(String [] args){
		 new LongDistance();
	}//end main
}//end long distance
