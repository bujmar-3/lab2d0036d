package lab2.data;
import java.util.Observable;
import java.util.Vector;
import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.*;
import java.net.*;
import java.util.Date;


public class Data extends Observable {
	private Vector<City> Cities;
	private double agingTime;

	
	public Data(double agingTime){
		Cities = new Vector<City>();
	}
	/**
	 * getData, gets the information needed from the yr.no API
	 * @param lat = latitude, lon = longitude, msl = meters over sea level, time = time for forcast.
	 * @return temprature
	 * **/
	public double getData(double lat, double lon, double msl, double time) throws Exception{
		for (City town : Cities){
			double cityLat = town.getLat();
			double cityLon = town.getLon();
			double cityMsl = town.getMsl();
			double cityTime = town.getTime();
			if(cityLat == lat & cityLon == lon & cityMsl == msl & cityTime == time & (this.getTime()-town.getReqTime())<this.agingTime){
				return town.getTemp();
			}
			else if(cityLat == lat & cityLon == lon & cityMsl == msl & cityTime == time & (this.getTime()-town.getReqTime())>this.agingTime){
				Cities.remove(town);
				
				/*Staden finns men data är för gammalt, släng stad från vector och skapa ny*/
			}
			else{
				/*Staden finns inte ännu skapa stad*/
			}
		}
		
	}
	
	private double getTime(){
		/*Should return current time (current time IRL)*/
	}
	
	public void setAgingTime(double agingTime){
		this.agingTime = agingTime;
	}
	/**xmlParse ska hämta ut data från API skapa ett city obeject av datan och retunera detta objekt
	 * 
	 * **/
	private City xmlParse(String url, double time){
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document xmlDoc = dbuilder.parse(new URL(url).openStream());
		NodeList timeList = xmlDoc.getElementsByTagName("time");
			for(int i=0;i<timeList.getLength();i++){
				Element t = (Element) timeList.item(i);
				String from = t.getAttribute("from");
				String to = t.getAttribute("to");
				double timeFrom = strToDouble(from);
				double timeTo = strToDouble(to);
				/*Kolla om det är tiden vi söker*/
				if(time>timeFrom & time<timeTo){
					t.getAttributeNode("")
				}
			}
		
	}
	private double strToDouble(String str){
		
	}

}
