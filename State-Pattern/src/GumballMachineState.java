public interface GumballMachineState {

    void addGumball(int count, GumballMachine gumballMachine);
    void insertQuarter(GumballMachine gumballMachine);
    void removeQuarter(GumballMachine gumballMachine);
    void turnHandle(GumballMachine gumballMachine);
}
