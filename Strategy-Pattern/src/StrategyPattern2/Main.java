package StrategyPattern2;

public class Main {

    public static void main(String[] args) {
        EmailClient consoleApp = new EmailClient(new ConsoleApplication());
        consoleApp.prompt();

        EmailClient graphicalApp = new EmailClient(new GraphicalApplication());
        graphicalApp.prompt();

        EmailClient configurationFile = new EmailClient(new ConfigurationFile());
        configurationFile.prompt();
    }
}
