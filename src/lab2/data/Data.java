package lab2.data;
import java.util.Observable;
import java.util.Vector;
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

}
