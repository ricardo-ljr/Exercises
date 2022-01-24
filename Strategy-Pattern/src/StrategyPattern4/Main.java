package StrategyPattern4;

public class Main {

    public static void main(String[] args) {


        AI ai = new AI(new WinningStrategy(), new LosingStrategy());
        Player player = new Player();
        System.out.println("Let's play rock paper scissors!");

        do {
            String newPlayer = player.playerChoice();
            String newAi = ai.choose();

            if (newPlayer.equals("rock") && newAi.equals("rock")) {
                System.out.println("You and the Computer Both Chose Rock. It's a Tie!");
            } else if (newPlayer.equals("paper") && newAi.equals("paper")) {
                System.out.println("You and the Computer Both Chose Paper. It's a Tie!");

            } else if (newPlayer.equals("scissors") && newAi.equals("scissors")) {
                System.out.println("You and the Computer Both Chose Scissors. It's a Tie!");

            } else if (newPlayer.equals("rock") && newAi.equals("scissors")) {
                System.out.println("You Chose Rock and the Computer Chose Scissors. You Win!");

            } else if (newAi.equals("rock") && newPlayer.equals("scissors")) {
                System.out.println("You Chose Scissors and the Computer Chose Rock. You Lose!");

            } else if (newPlayer.equals("scissors") && newAi.equals("paper")) {
                System.out.println("You Chose Scissors and the Computer Chose Paper. You Win!");

            } else if (newAi.equals("scissors") && newPlayer.equals("paper")) {
                System.out.println("You Chose Paper and the Computer Chose Scissors. You Lose!");

            } else if (newPlayer.equals("paper") && newAi.equals("rock")) {
                System.out.println("You Chose Paper and the Computer Chose Rock. You Win!");

            } else if (newAi.equals("paper") && newPlayer.equals("rock")) {
                System.out.println("You Chose Paper and the Computer Chose Rock. You Lose!");

            } else {
                System.out.println("Invalid Input. Please Re-Enter. ");
                System.out.println();
            }

        } while (!(player.equals("quit")));


    }
}
