package ses;

// these are the imports for SDK v1

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.Regions;

public class EmailSender {
    public SendEmailResult handleRequest(EmailRequest request, Context context) {

        SendEmailResult emailResult;
        LambdaLogger logger = context.getLogger();
        logger.log("Entering send_email");

        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()
                            .withRegion(Regions.US_WEST_1).build();

            Destination destination = new Destination().withToAddresses(request.to);
            Content subject = new Content()
                    .withCharset("UTF-8").withData(request.subject);
            Content htmlContent = new Content()
                    .withCharset("UTF-8").withData(request.htmlBody);
            Content bodyContent = new Content()
                    .withCharset("UTF-8").withData(request.textBody);

            SendEmailRequest emailRequest = new SendEmailRequest()
                    .withSource(request.from)
                    .withDestination(destination)
                    .withMessage(new Message()
                            .withSubject(subject)
                            .withBody(new Body()
                                    .withHtml(htmlContent)
                                    .withText(bodyContent)));

            emailResult = client.sendEmail(emailRequest);

            logger.log("Email sent!");
        } catch (Exception ex) {
            logger.log("The email was not sent. Error message: " + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            logger.log("Leaving send_email");
        }

        // TODO:
        // Return EmailResult
        return emailResult;
    }
}