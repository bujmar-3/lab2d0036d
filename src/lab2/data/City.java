package lab2.data;

public class City {
	private double lat = 0;
	private double lon = 0;
	private double msl = 0;
	private double hour = 0; /*Time for the weather forecast*/
	private double temp = 0;
	private double reqTime = 0; /*Time this was requested against API*/
	/**
	 * Constructor for the City objects, used to cashe the data for diffrent citys.
	 * **/
	public City(double hour, double reqTime, double lat, double lon, double msl, double temp){
		this.hour = hour;
		this.lat = lat;
		this.lon = lon;
		this.msl = msl;
		this.temp = temp;
		this.reqTime = reqTime;
	}
	public double getLat(){
		return this.lat;
	}
	public double getLon(){
		return this.lon;
	}
	public double getMsl(){
		return this.msl;
	}
	public double getTime(){
		return this.hour;
	}
	public double getTemp(){
		return this.temp;
	}
	public double getReqTime(){
		return this.reqTime;
	}

}
