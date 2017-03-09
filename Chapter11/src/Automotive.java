import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
public class Automotive extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7988871219932169544L;
	private JPanel panel;
	private JCheckBox oilCb,lubeCb,radiatorCb,transCb,
	inspectCb,mufflerCb,tireCb,othersCb ;
	
	private JLabel laborCharges,numOfHours;
	private JButton totalAmount;
	private JTextField hours;
	private final double oil = 26.00;
	private final double lube = 18.00;
	private final double radiator = 30.00;
	private final double trans = 80.00;
	private final double inspect = 15.00;
	private final double muffler = 100.00;
	private final double tire = 20.00;
	private final double laborPerHour = 20.00;
	private final double others = 50.00;
	private final int windowwidth = 500;
	private final int windowheight = 800;
	
	//constructor
	public Automotive(){
		//set the window title
		setTitle("Joe Automotive Services");
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
		//create J Panel object
		panel = new JPanel();
		
		//create the check box
		oilCb = new JCheckBox("Oil change: $" + oil);
		lubeCb = new JCheckBox("Lube job: $"  + lube);
		radiatorCb = new JCheckBox("Radiator flush: $" + radiator);
		transCb = new JCheckBox("Transmission flush: $" + trans);
		inspectCb = new JCheckBox("Inspection : $" + inspect);
		mufflerCb = new JCheckBox("Muffler replacement: $" + muffler);
		tireCb = new JCheckBox("Tire rotation: $" + tire);
		othersCb = new JCheckBox ("Other: $" + others);
		
		//create a label for labor charges and hours
		laborCharges = new JLabel("Labor charges: $" + laborPerHour + "Per Hour");
		numOfHours = new JLabel("Enter the number of hours:");
		
		//create a text field for number of hours
		hours = new JTextField(3);
		
		//create a button for total
		totalAmount = new JButton("Total");
		
		//add action listener to button
		totalAmount.addActionListener(new CalcButtonListener());
		
		//add check boxes to panel
		panel.add(oilCb);
		panel.add(lubeCb);
		panel.add(radiatorCb);
		panel.add(transCb);
		panel.add(inspectCb);
		panel.add(mufflerCb);
		panel.add(tireCb);
		panel.add(othersCb);
		panel.add(laborCharges);
		panel.add(numOfHours);
		panel.add(hours);
		panel.add(totalAmount);
	}//end build panel
	
	private class CalcButtonListener implements ActionListener{
		//this method executes when user clicks button
		public void actionPerformed(ActionEvent e){
			//calculate total amount for customer
			double amount = 0.0;
			//find checked boxes
			if(oilCb.isSelected())
				amount += oil;
			if(lubeCb.isSelected())
				amount += lube;
			if(radiatorCb.isSelected())
				amount += radiator;
			if(transCb.isSelected())
				amount += trans;
			if(inspectCb.isSelected())
				amount += inspect;
			if(mufflerCb.isSelected())
				amount += muffler;
			if(tireCb.isSelected())
				amount += tire;
			if(othersCb.isSelected())
				amount += others;
			
			//get the number of hours from hours text box
			String input = hours.getText();
			int hrs = Integer.parseInt(input);
			
			amount += laborPerHour * hrs;
			
			//display the message for the total
			JOptionPane.showMessageDialog(null, "Your total amount is : $" + amount);
			
		}//end action performed
	}//end calculate Button listener
	
	public static void main(String [] args) {
		new Automotive();
	}
	
	
	
	

}
