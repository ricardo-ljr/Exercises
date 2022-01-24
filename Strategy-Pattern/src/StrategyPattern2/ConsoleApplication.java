package StrategyPattern2;

import java.util.Scanner;

public class ConsoleApplication implements SendEmail{

    @Override
    public void promptUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter username and password in console or type 'C' if you want to enter in command line: \n");

        if (in.next().equals('C')) {
            System.out.print("Login: ");
            String username = in.next();

            System.out.println("Password: ");
            String password = in.next();
        }

    }
}
