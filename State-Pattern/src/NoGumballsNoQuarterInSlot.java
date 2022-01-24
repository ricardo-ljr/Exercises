public class NoGumballsNoQuarterInSlot implements GumballMachineState{
    @Override
    public void addGumball(int count, GumballMachine gumballMachine) {
        gumballMachine.numGumballs += count;
        System.out.println(count + " gumballs were added");
        gumballMachine.state = new GumballsNoQuarterInSlot();
    }

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Inserting Quarter");
        gumballMachine.state = new NoGumballsQuarterInSlot();
    }

    @Override
    public void removeQuarter(GumballMachine gumballMachine) {
        System.out.println("Removing quarter");
    }

    @Override
    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("Turning handle, uh oh no gumball");
    }
}
