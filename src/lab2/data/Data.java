package lab2.data;
import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;


public class Data {
	/** getTemp 
	 *  Hämtar tempratur från API med angiven url och tid.
	 * **/

	public String getTemp(String url, String time){
		String temprature = "none";
		int j = -5;
		try{
		URL url1 = new URL(url);
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document xmlDoc = dbuilder.parse(url1.openStream());
		NodeList timeList = xmlDoc.getElementsByTagName("time");
		NodeList tempList = xmlDoc.getElementsByTagName("temperature");
		for(int i = 0; i < timeList.getLength(); i++){
			j = j + 5;
			Node tempNode = tempList.item(i);
			Node timeNode = timeList.item(j);
			if(tempNode.getNodeType() == Node.ELEMENT_NODE){
				Element tempElement = (Element) tempNode;
				Element timeElement = (Element) timeNode;
				String timeFromAttribute = timeElement.getAttribute("from");
				String timeToAttribute = timeElement.getAttribute("to");
				if(time.equals(timeFromAttribute) && time.equals(timeToAttribute)){
					temprature = tempElement.getAttribute("value");
					System.out.println("Temprature:" + temprature);
					return temprature;
				}
			}
		}
	}catch(Exception e){
		System.out.println(e);
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
		String[] locArray = new String[3];
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
						System.out.println("Alt:" + alt + " Lat:" + lat +  " Lon:" + lon);
						return locArray;
					}
				}
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return locArray;
	}
	
	public String getCurrentTime(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy'T'HH:mm:ss'Z'");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		return df.format(calobj.getTime());
	}
	
		

}
