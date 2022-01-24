public class Main {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine();

        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.addGumball(1);
        gumballMachine.turnHandle();
        System.out.println("You have a total of: $" + gumballMachine.coins * 0.25 + " in profit");
        System.out.println("You have " + gumballMachine.numGumballs + " gumballs left");
        gumballMachine.addGumball(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.removeQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.removeQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        System.out.println("You have a total of: $" + gumballMachine.coins * 0.25 + " in profit");
        System.out.println("You have " + gumballMachine.numGumballs + " gumballs left");
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.addGumball(1);
        gumballMachine.turnHandle();
        System.out.println("You have a total of: $" + gumballMachine.coins * 0.25 + " in profit");
        System.out.println("You have " + gumballMachine.numGumballs + " gumballs left");
        gumballMachine.addGumball(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.removeQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.removeQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        System.out.println("You have a total of: $" + gumballMachine.coins * 0.25 + " in profit");
        System.out.println("You have " + gumballMachine.numGumballs + " gumballs left");

    }
}
