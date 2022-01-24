package StrategyPattern2;

public class GraphicalApplication implements SendEmail{
    @Override
    public void promptUser() {
        System.out.println("Enter your username and password once you see the graphical interface.");
    }
}
