package lab2.view;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Ginp extends JFrame{
	private JTextField Item1;
	private JTextField Item2;
	private JTextField Item3;
	
	
	
	
	
	
	public Ginp() {
		super("Weather app");
		setLayout(new FlowLayout());
		
		Item1 = new JTextField("Enter city here", 10);
		add(Item1);
		
		Item2 = new JTextField("Enter hour here", 5);
		add(Item2);
		
		
		
	}
	
	

}
