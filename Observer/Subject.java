import java.util.ArrayList;

public abstract class Subject {
    ArrayList<Observer> observers = new ArrayList<>();

    // add
    public void attach(Observer obs) {
        observers.add(obs);
    }
    // remove
    public void detach(Observer obs) {
        observers.remove(obs);
    }
    // notify method
    public void Notify() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }
}
