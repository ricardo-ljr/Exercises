package StrategyPattern2;

public class ConfigurationFile implements SendEmail{

    @Override
    public void promptUser() {
        System.out.println("Enter your username and password once you see the file.");
    }
}
