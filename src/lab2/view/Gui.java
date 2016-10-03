package lab2.view;

import lab2.controller.Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;

// The Gui
public class Gui {
	private JFrame weatherFrame;
	private JLabel head;
	private JLabel status;
	private JPanel ctrl;
	
	//Constructor
	public Gui(){
		buildGui();
	}
	
	
	// Main method
	// Creates window
	public static void main(String[] args){
		Date date = new Date();
		System.out.println("Date: "+ date);
		Gui YrCoordz = new Gui();
		lab2.data.Data.getData();
	}
	
	public void buildGui(){
		weatherFrame = new JFrame("climate climax");
		weatherFrame.setLayout(new GridLayout(3, 1));
		weatherFrame.setSize(333,333);
	    weatherFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent windowEvent){
		    	System.exit(0);
		    }
	    });
			
		head = new JLabel("",JLabel.TOP);
	    
		ctrl = new JPanel();
	    ctrl.setLayout(new FlowLayout());
		
	    status = new JLabel("", JLabel.TOP);
	    status.setSize(350,100);
	    
	    weatherFrame.add(head);
	    weatherFrame.add(status);
	    weatherFrame.add(ctrl);
	    weatherFrame.setVisible(true);  
	}
	
}
