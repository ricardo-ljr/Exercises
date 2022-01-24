public class FlightStatus implements Observer {

    //attach the feed to observer
    FlightFeed feed;

    public FlightStatus(FlightFeed feed) {
        this.feed = feed;
        feed.attach(this);
    }

    @Override
    public void update(Object o) {
        Flight flight = feed.getFlight();

        if(flight != null) {
            System.out.println(flight.toString());
        } else {

            System.out.println("Flight Over");
        }

    }
}
