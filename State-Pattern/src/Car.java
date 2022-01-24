public interface CarState {

    void putInPark(Car car);
    void putInDrive(Car car);
    void putInReverse(Car car);
    void accelerate(Car car);
    void decelerate(Car car);

}



public class Car {

    private CarState parked = new ParkedCar();


    public Car state;


    public Car() {
        this.state = parked;

    }

    public void putInPark() {
        state.putInPark(this);
    }

    public void putInDrive() {
        state.putInDrive(this);
    }

    public void putInReverse() {
        state.putInReverse(this);
    }

    public void accelerate() {
        state.accelerate(this);
    }

    public void decelerate() {
        state.decelerate(this);
    }

}

public class ParkedCar implements CarState {

    @Override
    public void putInPark(Car car) {
        System.out.println("You're already parked");
    }

    @Override
    public void putInDrive(Car car) {
        System.out.println("You're parked");
        car.state = new DriveCar();
    }

    @Override
    public void putInReverse(Car car) {
        System.out.println("You're parked");
        car.state = new ReverseCar();
    }

    @Override
    public void accelerate(Car car) {
        System.out.println("You're parked");
    }

    @Override
    public void decelerate(Car car) {
        System.out.println("You're parked");
    }
}

public class DriveCar implements CarState {

    @Override
    public void putInPark(Car car) {
        System.out.println("You're coming to a stop");
        car.state = new ParkedCar();
    }

    @Override
    public void putInDrive(Car car) {
        System.out.println("You're already driving");
    }

    @Override
    public void putInReverse(Car car) {
        System.out.println("You need to slow down first");
        car.state = new ReverseCar();
    }

    @Override
    public void accelerate(Car car) {
        System.out.println("You're going fast!");
    }

    @Override
    public void decelerate(Car car) {
        System.out.println("You're going slow!");
    }
}

public class ReverseCar implements CarState {

    @Override
    public void putInPark(Car car) {
        System.out.println("Putting in park");
        car.state = new ParkedCar();
    }

    @Override
    public void putInDrive(Car car) {
        System.out.println("Driving");
        car.state = new DriveCar();

    }

    @Override
    public void putInReverse(Car car) {
        System.out.println("You're already in reverse");
    }

    @Override
    public void accelerate(Car car) {
        System.out.println("Going fast backwatds is fun!");
    }

    @Override
    public void decelerate(Car car) {
        System.out.println("You don't want to get caught going fast in reverse, good job");
    }
}

