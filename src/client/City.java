package client;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.teamdev.jxmaps.LatLng;
/**
 * Simple class that represents a city with a name and a location
 * @author Adam
 *
 */
public class City {
	
	private String name; 
	private LatLng latlng;
	
	public City(String name, LatLng latlng) {
		this.name = name;
		this.latlng = latlng;
	}

	public LatLng getCoordinates() {
		return latlng;
	}
	
	public String getName() {
		return name;
	}
}
