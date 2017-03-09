import javax.swing.*;
import java.awt.event.*;
public class TheaterRevenue extends JFrame {
	
private JPanel panel; //to reference a panel
//to reference labels
private JLabel messageLabel_Priceofadulttickets;
private JLabel messageLabel_Numofadultticketssold;
private JLabel messageLabel_Priceofchildtickets;
private JLabel messageLabel_Numofchildticketssold;
//to reference text fields
private JTextField TextField_Priceofadulttickets;
private JTextField TextField_Numofadultticketssold;
private JTextField TextField_Priceofchildtickets;
private JTextField TextField_Numofchildticketssold;

private JButton calcButton;//to reference a button

private final int windowwidth = 300;//window width
private final int windowheight = 300;//window height

public TheaterRevenue(){
	//set the window title
	setTitle("Theater Revenue");
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

//build panel method to add labels, text and button
private void buildPanel(){
	
	messageLabel_Priceofadulttickets = new JLabel("Enter adult ticket price ");
	TextField_Priceofadulttickets = new JTextField(10);
	messageLabel_Numofadultticketssold = new JLabel("Enter adult tickets sold ");
	TextField_Numofadultticketssold = new JTextField(10);
	
	messageLabel_Priceofchildtickets = new JLabel("Enter child ticket price ");
	TextField_Priceofchildtickets = new JTextField(10);
	messageLabel_Numofchildticketssold = new JLabel("Enter child tickets sold ");
	TextField_Numofchildticketssold = new JTextField(10);
	
	calcButton = new JButton ("Calculate Theater Revenue");
	//add an action listener to the button
	calcButton.addActionListener((ActionListener) new CalcButtonListener());
	
	//create a JPanel object
	panel = new JPanel();
	//add the label, text and button
	panel.add(messageLabel_Priceofadulttickets);
	panel.add(TextField_Priceofadulttickets);
	
	panel.add(messageLabel_Numofadultticketssold);
	panel.add(TextField_Numofadultticketssold);
	
	panel.add(messageLabel_Priceofchildtickets);
	panel.add(TextField_Priceofchildtickets);
	
	panel.add(messageLabel_Numofchildticketssold);
	panel.add(TextField_Numofchildticketssold);
	
	panel.add(calcButton);
	}

//calcButtonListener is action listener class for the calculate button
	private class CalcButtonListener implements ActionListener{
		//action performed method executes when user clicks button
		public void actionPerformed(ActionEvent e){
			String input;  //to hold user input
			
			double Gross_revadultticksold;
			double net_revadultticksold = 0 ;
			double Gross_revchildticksold;
			double net_revchildticksold;
			double totalgross;
			double totalnet;
			
			String inputone = TextField_Priceofadulttickets.getText();
			String inputtwo = TextField_Numofadultticketssold.getText();
			String inputthree = TextField_Priceofchildtickets.getText();
			String inputfour = TextField_Numofchildticketssold.getText();
			//convert the input
			Gross_revadultticksold = Double.parseDouble(inputone) * Double.parseDouble(inputtwo);
			Gross_revchildticksold = Double.parseDouble(inputthree) * Double.parseDouble(inputfour);
			
			//display the result
			JOptionPane.showMessageDialog(null, "Gross revenue for adult tickets sold is "+ Gross_revadultticksold);
			net_revchildticksold = (Gross_revadultticksold * 0.2);
			JOptionPane.showMessageDialog(null, "Net revenue for adult tickets sold is " + net_revadultticksold);
			
			JOptionPane.showMessageDialog(null, "Gross revenue for child tickets sold is "+ Gross_revchildticksold);
			net_revchildticksold = (Gross_revchildticksold * 0.2);
			JOptionPane.showMessageDialog(null, "Net revenue for child tickets sold is " + net_revchildticksold);
			
			totalgross = (Gross_revadultticksold + Gross_revchildticksold);
			totalnet = (net_revadultticksold + net_revchildticksold);
			
			JOptionPane.showMessageDialog(null, "The total gross revenue is " + totalgross +"\n" +
			"The total net revenue is " + totalnet);
		}//end action performed
	}//end calculate
	public static void main(String [] args){
		new TheaterRevenue();
	}
}//end theater revenue
