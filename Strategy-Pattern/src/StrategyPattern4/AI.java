package StrategyPattern4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    public List<Strategy> strategyList = new ArrayList<>();

    public AI(Strategy winning, Strategy losing) {
        this.strategyList.add(winning);
        this.strategyList.add(losing);
    }

    public void addStrategy(Strategy strategy) {
        this.strategyList.add(strategy);
    }

    public String choose() {

        String choice = "";
        Random generateRandom = new Random();
        choice = strategyList.get(generateRandom.nextInt(strategyList.size())).choose();
        System.out.println(choice);

        return choice;
    }

}
