package lab2.data;
import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;


public class Data {
	/** getTemp 
	 *  Hämtar tempratur från API med angiven url och tid.
	 * **/

	public String getTemp(String url, String time){
		String temprature = "none";
		try{
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document xmlDoc = dbuilder.parse(url);
		NodeList timeList = xmlDoc.getElementsByTagName("time");
		NodeList tempList = xmlDoc.getElementsByTagName("temprature");
		for(int i = 0; i < timeList.getLength(); i++){
			Node tempNode = tempList.item(i);
			Node timeNode = timeList.item(i);
			if(tempNode.getNodeType() == Node.ELEMENT_NODE){
				Element tempElement = (Element) tempNode;
				Element timeElement = (Element) timeNode;
				String timeFromAttribute = timeElement.getAttribute("from");
				String timeToAttribute = timeElement.getAttribute("to");
				if(time.equals(timeFromAttribute) && time.equals(timeToAttribute)){
					temprature = tempElement.getAttribute("value");
					return temprature;
				}
			}
		}
	}catch(Exception e){
		System.out.println("Error in getTemp");
	}
		return temprature;
	}
	/**
	 * createUrl(lat, lon, msl)
	 * Creates an URL used to get wanted data from API
	 * @return URL String to get data from
	 * */
	public String createUrl(String lat, String lon, String msl){
		String url = "http://api.met.no/weatherapi/locationforecast/1.9/?l"+"lat="+lat+";lon="+lon+";msl="+msl;
		return url;
	}
	
	public String[] getLoc(String place){
		String[] locArray = new String[2];
		try{
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			File xmlFile = new File("C:/Users/MarZ/Downloads/places.xml");
			Document dplaces = dbuilder.parse(xmlFile);
			NodeList localityList = dplaces.getElementsByTagName("locality");
			NodeList locationList = dplaces.getElementsByTagName("location");
			for(int i = 0; i < localityList.getLength(); i++){
				Node localityNode = localityList.item(i);
				Node locationNode = locationList.item(i);
				if(localityNode.getNodeType() == Node.ELEMENT_NODE){
					Element localityElement = (Element) localityNode;
					Element locationElement = (Element) locationNode;
					if(place.equals(localityElement.getAttribute("name"))){
						String alt = locationElement.getAttribute("altitude");
						String lat = locationElement.getAttribute("latitude");
						String lon = locationElement.getAttribute("longitude");
						locArray[0] = alt;
						locArray[1] = lat;
						locArray[2] = lon;
						return locArray;
					}
				}
			}
			
		}catch(Exception e){
			System.out.println("Error in getLoc");
		}
		return locArray;
	}
	
		

}
