package StrategyPattern2;

public class EmailClient {

    private String username;
    private String password;

    public SendEmail sendEmail;

    public EmailClient(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    public void prompt() {
        sendEmail.promptUser();
    }

}
