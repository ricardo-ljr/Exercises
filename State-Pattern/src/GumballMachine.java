public class GumballMachine {

    private GumballMachineState noGumballs_noQuarter = new NoGumballsNoQuarterInSlot();
    private GumballMachineState noGumballs_quarterIn = new NoGumballsQuarterInSlot();
    private GumballMachineState gumballs_noQuarter = new GumballsNoQuarterInSlot();
    private GumballMachineState gumballs_quarterIn = new GumballsQuarterInSlot();

    public GumballMachineState state;

    int numGumballs;
    int coins;

    public GumballMachine() {
        this.state = noGumballs_noQuarter;
        this.numGumballs = 0;
        this.coins = 0;
    }

    public void addGumball(int count) {
        state.addGumball(count, this);
    }

    public void insertQuarter() {
        state.insertQuarter(this);
    }

    public void removeQuarter() {
        state.removeQuarter(this);
    }

    public void turnHandle() {
        state.turnHandle(this);
    }
}
