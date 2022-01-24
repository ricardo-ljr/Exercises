public class FlightDeltas implements Observer {

    FlightFeed feed;
    private Flight last = null;

    public FlightDeltas(FlightFeed feed) {
        this.feed = feed;
        feed.attach(this);
    }

    @Override
    public void update(Object o) {

        Flight flight = feed.getFlight();

        if(flight != null) {

            if(last != null) {

                float lonDelta = (flight.longitude - last.longitude);
                float latDelta = (flight.latitude - last.latitude);
                float velDelta = (flight.velocity - last.velocity);
                float altDelta = (flight.geo_altitude - last.geo_altitude);

                System.out.println(String.format("lon-delta: %f, lat-delta: %f, vel-delta: %f, alt-delta: %f", lonDelta, latDelta, velDelta, altDelta));
            }

            last = flight;
        } else {
            System.out.println("Flight Over");
        }
    }
}
