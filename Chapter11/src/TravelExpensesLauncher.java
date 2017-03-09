
import javax.swing.*;
import java.awt.event.*;

public class TravelExpensesLauncher extends JFrame {
	//required components and variables
	private JPanel panel;
	private JLabel onedays, oneairfare,onecar,onemiles,oneparking,onetaxi,
	oneseminar,onelodge,meals,parking,taxi,lodge,mile;
	private JTextField tdays,tairfare,tcar,tmiles,
	tparking,ttaxi,tseminar,tlodge;
	private JButton calculations;
	
	private final double mealsPerDay = 37.00;
	private final double parkingPerDay = 10.00;
	private final double taxtPerDay = 20.00;
	private final double lodgingPerDay = 95.00;
	private final double dPerMile = 0.27;
	
	private final int windowHeight = 500;
	private final int windowWidth = 280;
	
	//constructor
	public TravelExpensesLauncher(){
		//set the window title
		setTitle("Travel Expenses");
		//set the size of window
		setSize(windowHeight, windowWidth);
		//when close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//build panel
		buildPanel();
		//add the panel
		add(panel);
		//display the window
		setVisible(true);
	}//end constructor
	
	//build panel method
	private void buildPanel(){
		//create J panel object
		panel = new JPanel();
		
		//create the labels
		onedays = new JLabel("Number of Days: ");
		oneairfare = new JLabel("Amount of airfare: $");
		onecar = new JLabel("Car rental fees: $ ");
		onemiles = new JLabel("Number of miles: ");
		oneparking = new JLabel("Parking fees: $");
		onetaxi = new JLabel("Taxi charges: $");
		oneseminar = new JLabel("Seminar fees: $");
		onelodge = new JLabel("Lodging fees per night: $");
		
		meals = new JLabel("Meals per day: $" + mealsPerDay);
		parking = new JLabel("Parking per day: $" + parkingPerDay);
		taxi = new JLabel("Taxi per day: $" + taxtPerDay);
		lodge = new JLabel("Lodging per day: $" + lodgingPerDay);
		mile = new JLabel("Charges per Mile: $" + dPerMile);
		
		//create text fields
		tdays = new JTextField(10);
		tairfare = new JTextField(10);
		tcar = new JTextField(10);
		tmiles = new JTextField(10);
		tparking = new JTextField(10);
		ttaxi = new JTextField(10);
		tseminar = new JTextField(10);
		tlodge = new JTextField(10);
		
		//create a button
		calculations = new JButton("Display the details");
		calculations.addActionListener(new Calc());
		
		//add the components to the panel
		panel.add(onedays);
		panel.add(tdays);
		panel.add(oneairfare);
		panel.add(tairfare);
		panel.add(onecar);
		panel.add(tcar);
		panel.add(onemiles);
		panel.add(tmiles);
		panel.add(oneparking);
		panel.add(tparking);
		panel.add(onetaxi);
		panel.add(ttaxi);
		panel.add(oneseminar);
		panel.add(tseminar);
		panel.add(onelodge);
		panel.add(tlodge);
		
		panel.add(meals);
		panel.add(parking);
		panel.add(taxi);
		panel.add(lodge);
		panel.add(mile);
		panel.add(calculations);
	}//end build panel method
	
	private class Calc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double totalExpences;
			double allowedExpences;
			
			double days = Integer.parseInt(tdays.getText());
			double d1 = Double.parseDouble(tairfare.getText());
			double d2 = Double.parseDouble(tcar.getText());
			double d3 = Double.parseDouble(tmiles.getText());
			double d4 = Double.parseDouble(tparking.getText());
			double d5 = Double.parseDouble(ttaxi.getText());
			double d6 = Double.parseDouble(tseminar.getText());
			double d7 = Double.parseDouble(tlodge.getText());
			
			//calculate the total expenses
			totalExpences = d1+d2+ (d3 *dPerMile) +d4+d5+d6+(d7*days);
			
			//calculate the allowable expense
			allowedExpences = (mealsPerDay + parkingPerDay+taxtPerDay+lodgingPerDay)
								* days +(d3 * dPerMile);
			
			//find out if total more than allowable
			if(totalExpences > allowedExpences)
				JOptionPane.showMessageDialog(null, "Total expences: $" + Double.toString(totalExpences)
				+ "\nAllowable expenses for the trip: $" + Double.toString(allowedExpences)+
				"\nExpenses must be paid: $" + Double.toString((totalExpences - allowedExpences)));
			else
				JOptionPane.showMessageDialog(null, "Total expences: $" + Double.toString(totalExpences)
				+ "\nAllowable expenses for the trip: $" + Double.toString(allowedExpences)+
				"\nAmount saved: $" + Double.toString((allowedExpences - totalExpences)));
		}//end of action performed
	}//end of class
	
	public static void main(String [] args){
		new TravelExpensesLauncher();
	}//end of main
}//end of launcher
