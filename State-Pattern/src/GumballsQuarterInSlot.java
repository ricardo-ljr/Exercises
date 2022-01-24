public class GumballsQuarterInSlot implements GumballMachineState{
    @Override
    public void addGumball(int count, GumballMachine gumballMachine) {
        gumballMachine.numGumballs += count;
        System.out.println("Adding gumballs yum yum");
    }

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Quarter already in place");
    }

    @Override
    public void removeQuarter(GumballMachine gumballMachine) {
        System.out.println("You're now removing the quarter");
        gumballMachine.state = new GumballsNoQuarterInSlot();
    }

    @Override
    public void turnHandle(GumballMachine gumballMachine) {
        gumballMachine.coins++;
        System.out.println("Here's your gumball wow");

        if (gumballMachine.numGumballs - 1 < 1) {
            System.out.println("There are no more gumballs available");
            gumballMachine.state = new NoGumballsNoQuarterInSlot();
        } else {
            gumballMachine.state = new GumballsNoQuarterInSlot();
        }
    }
}
