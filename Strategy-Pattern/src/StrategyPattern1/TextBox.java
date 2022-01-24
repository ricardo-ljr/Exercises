package StrategyPattern1;

public class TextBox {

    private String text;
    private int numChars;
    private String textBoxColor;

    public Valid validate;

    public TextBox(Valid validate) {
        this.validate = validate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

    public void setTextBoxColor(String textBoxColor) {
        this.textBoxColor = textBoxColor;

    }

    public String getTextBoxColor() {
        return textBoxColor;
    }

    public boolean validate() {
        return validate.isValidText(numChars);
    }

    public String setColor() {
        if (validate()) {
            return "Green";
        } else {
            return "Black";
        }
    }
}
