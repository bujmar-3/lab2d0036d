package lab2.data;
import java.util.Observable;
import java.io.*;
import java.net.*;


public class Data extends Observable {
	private Vector<City> Cities;
	public Data(){
		
		int timeLimit = ;
		if City.time <= timeLimit{
			return City.getTemp();
		}else
		{
			
		}
		
	}
	/**
	 * getData, gets the information needed from the yr.no API
	 * @param lat = latitude, lon = longitude, msl = meters over sea level.
	 * **/
	public void getData(double lat, double lon, double msl) throws Exception{
		URL yr = new URL("http://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10;lon=9.58;msl=70");
		URLConnection yrConnection = yr.openConnection();
		
	}

}
