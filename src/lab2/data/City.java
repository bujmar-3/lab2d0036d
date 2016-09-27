package lab2.data;

public class City {
	private double lat = 0;
	private double lon = 0;
	private double msl = 0;
	private double time = 0;
	public City(double time, double lat, double lon, double msl){
		this.time = time;
		this.lat = lat;
		this.lon = lon;
		this.msl = msl;
	}

}
