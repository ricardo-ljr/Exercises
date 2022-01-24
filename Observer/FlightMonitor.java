
public class FlightMonitor {
	
	public static void main(String[] args) {
	
		FlightFeed feed = new FlightFeed();
		FlightStatus flightStatus = new FlightStatus(feed);
		FlightDeltas flightDeltas = new FlightDeltas(feed);
		feed.start();
	}
	
}