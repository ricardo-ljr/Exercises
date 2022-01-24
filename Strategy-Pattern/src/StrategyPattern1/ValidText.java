package StrategyPattern1;

public class ValidText implements Valid{

    @Override
    public boolean isValidText(int numChars) {
        if (numChars > 1) {
            System.out.println("Valid text");
            return true;
        } else {
            System.out.println("Invalid text");
            return false;
        }
    }
}
