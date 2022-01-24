public class GumballsNoQuarterInSlot implements GumballMachineState{
    @Override
    public void addGumball(int count, GumballMachine gumballMachine) {
        gumballMachine.numGumballs += count;
        System.out.println(count + " gumballs were added");

    }

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Thanks for the quarter yum yum");
        gumballMachine.state = new GumballsQuarterInSlot();
    }

    @Override
    public void removeQuarter(GumballMachine gumballMachine) {
        System.out.println("Removing quarter uh oh");
    }

    @Override
    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("No quarter can't turn handle");
    }
}
