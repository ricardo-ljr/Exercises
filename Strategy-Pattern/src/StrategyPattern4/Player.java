package StrategyPattern4;

import java.util.Scanner;

public class Player {

    public String playerChoice() {
        Scanner in = new Scanner(System.in);

        String input = "";

        System.out.println();
        System.out.print("Please Choose Rock Paper or Scissor: ");
        input = in.next();
        String inputLower = input.toLowerCase();

        return inputLower;
    }
}
