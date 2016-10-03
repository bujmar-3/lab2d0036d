package lab2.main;

import lab2.data.Data;
import lab2.controller.Controller;
import lab2.view.Gui;

public class Main {

	public static void main(String[] args){
		Data model = new Data();
		model.getCurrentTime();
		model.getLoc("Kage");
		model.getTemp("http://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10;lon=9.58;msl=70", "2016-10-04T02:00:00Z");
}
}
