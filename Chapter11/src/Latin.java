import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latin extends JFrame{
	private JLabel messageLabel; // to display a message
	private JButton sinisterbutton;
	private JButton dexterbutton;
	private JButton mediumbutton;
	private JPanel panel; // panel to hold components
	private final int windowheight = 500;
	private final int windowwidth = 500;
	
	//constructor
	public Latin(){
		//set title
		setTitle("Latin translator");
		//set size of window
		setSize(windowwidth,windowheight);
		//close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create a label
		messageLabel = new JLabel("Click a button for English");
		
		//create three buttons
		sinisterbutton = new JButton("sinister");
		dexterbutton = new JButton("dexter");
		mediumbutton = new JButton("medium");
		
		//register an event listener with each button
		sinisterbutton.addActionListener(new SButtonListener());
		dexterbutton.addActionListener(new DButtonListener());
		mediumbutton.addActionListener(new MButtonListener());
		
		//create panel and add components
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(sinisterbutton);
		panel.add(dexterbutton);
		panel.add(mediumbutton);
		
		//add panel to content pane
		add(panel);
		//display window
		setVisible(true);
	}
	
	private class SButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Left");
		}
	}
	
	private class DButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Right");
		}
	}
	
	private class MButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Center");
		}
	}
	
	public static void main(String [] args){
		new Latin();
	}
	
	
}
