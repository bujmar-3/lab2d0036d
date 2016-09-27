package lab2.data;

public class City {
	private double lat = 0;
	private double lon = 0;
	private double msl = 0;
	private double time = 0;
	private double temp = 0;
	/**
	 * Constructor for the City objects, used to cashe the data for diffrent citys.
	 * **/
	public City(double time, double lat, double lon, double msl, double temp){
		this.time = time;
		this.lat = lat;
		this.lon = lon;
		this.msl = msl;
		this.temp = temp;
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
		return this.time;
	}
	public double getTemp(){
		return this.temp;
	}

}
