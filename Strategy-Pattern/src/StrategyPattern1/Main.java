package StrategyPattern1;

public class Main {

    public static void main(String[] args) {

        TextBox box = new TextBox(new ValidText());

        String test1 = "";
        String test2 = "Hello World";

        box.setText(test1);
        box.setNumChars(test1.length());
        box.setTextBoxColor(box.setColor());
        System.out.println("The box is now " + box.getTextBoxColor());

        box.setText(test2);
        box.setNumChars(test2.length());
        box.setTextBoxColor(box.setColor());
        System.out.println("The box is now " + box.getTextBoxColor());

    }

}

