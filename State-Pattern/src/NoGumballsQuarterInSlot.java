public class NoGumballsQuarterInSlot implements GumballMachineState{

    @Override
    public void addGumball(int count, GumballMachine gumballMachine) {
        gumballMachine.numGumballs += count;
        System.out.println(count + " gumballs were added");
        gumballMachine.state = new GumballsQuarterInSlot();
    }

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Inserting quarter");
    }

    @Override
    public void removeQuarter(GumballMachine gumballMachine) {
        System.out.println("Removing quarter");
        gumballMachine.state = new NoGumballsNoQuarterInSlot();
    }

    @Override
    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("Turning handle but no gumball available, sorry");
    }
}
