package StrategyPattern3;

public class Main {

    public static void main(String[] args) {

        double newTV = 1000.00;

        ProcessOrders order1 = new ProcessOrders(new CreditCard(), new Arizona(), new WestCoast());
        order1.setItemCost(newTV);
        System.out.println("Total order cost: " + order1.checkout() + " enjoy your new TV!");

    }
}
