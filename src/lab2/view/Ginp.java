package lab2.view;
import javax.swing.*;

import java.awt.FlowLayout;

import java.awt.event.*;
import javax.swing.*;


public class Ginp extends JFrame{
	private JComboBox boxlocation;
	private JComboBox boxtime;
	private static String[] location = {"stockholm", "Skelleftea" , "Kage"}; 
	private static String[] hours = {"00:00", "01:00", "02:00", "fuck me", "03:00", "04:00", "05:00"};
	private String test = "fuckm me dead";
	
	public Ginp(){
		super("the title");
		setLayout(new FlowLayout());
		
			boxtime = new JComboBox(hours);
		boxtime.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						String string = ""
						if(event.getStateChange()==ItemEvent.SELECTED)
							string=.string.format	/** få in xml svar */
					}
				}
				
				
				
				
		);
		
		
		boxlocation = new JComboBox(location);
		boxlocation.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						String string = ""
						if(event.getStateChange()==ItemEvent.SELECTED)
							string=.string.format	/** få in xml svar */
					}
				}
				
				
		); 
		
		
		
	
	
	
	

		
		
		
	}
	
	

}
