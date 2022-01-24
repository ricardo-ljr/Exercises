package StrategyPattern4;

import java.util.Random;

public interface Strategy {

    public String choose();
}

class WinningStrategy implements Strategy {

    @Override
    public String choose() {
        Random randomGenrator = new Random();
        int randomNumber = randomGenrator.nextInt(3);

        String choice = "";
        switch(randomNumber) {
            case 0:
                choice = "rock";
                break;
            case 1:
                choice = "paper";
                break;
            case 2:
                choice = "scissors";
                break;
        }

        return choice;

    }
}

class LosingStrategy implements Strategy {

    @Override
    public String choose() {
        return "rock";
    }
}
