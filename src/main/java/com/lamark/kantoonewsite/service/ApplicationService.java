/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamark.kantoonewsite.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.lamark.kantoonewsite.entity.Application;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ApplicationService {

    //mozham da koristam i metoda za verifikacija
    static final String FROM = "mail@mail.com";  // Replace with your "From" address. This address must be verified.
    static final String TO = "recepient@mail.com"; // Replace with a "To" address. If you have not yet requested
    // production access, this address must be verified.
    static final String BODY = "This email was sent through Amazon SES by using the AWS SDK for Java.";
    static final String SUBJECT = "Contact From My Website";

    static String accessKey = "my_access_key";
    static String secretKey = "my_secret_key";

    /*
     * Before running the code:
     *      Fill in your AWS access credentials in the provided credentials
     *      file template, and be sure to move the file to the default location
     *      (~/.aws/credentials) where the sample code will load the
     *      credentials from.
     *      https://console.aws.amazon.com/iam/home?#security_credential
     *
     * WARNING:
     *      To avoid accidental leakage of your credentials, DO NOT keep
     *      the credentials file in your source directory.
     */
    //  public static void main(String[] args) throws IOException {
    public void sendEmailForContact(Application application) throws IOException {

        String messageBody = getMailBodyFromContact(application);
        // Construct an object to contain the recipient address.
        Destination destination = new Destination()
                .withToAddresses(new String[]{TO});

        // Create the subject and body of the message.
        Content subject = new Content().withData(SUBJECT);
        Content textBody = new Content().withData(messageBody);
        //    Content textBody = new Content().withData("fullName".concat("email").concat("companyName").concat(messageForm));
        Body body = new Body().withText(textBody);

        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(subject).withBody(body);

        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(FROM)
                .withDestination(destination)
                .withMessage((com.amazonaws.services.simpleemail.model.Message) message);

        try {
            System.out.println("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");

            /*
             * The ProfileCredentialsProvider will return your [default]
             * credential profile by reading from the credentials file located at
             * (~/.aws/credentials).
             *
             * TransferManager manages a pool of threads, so we create a
             * single instance and share it throughout our application.
             */
            BasicAWSCredentials awsCreds = null;
            //  ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();

            try {
                  awsCreds = new BasicAWSCredentials(accessKey, secretKey);
                //  credentialsProvider.getCredentials();
            } catch (Exception e) {
                throw new AmazonClientException(
                        "Cannot load the credentials from the credential profiles file. "
                        + "Please make sure that your credentials file is at the correct "
                        + "location (~/.aws/credentials), and is in valid format.",
                        e);
            }

            // Instantiate an Amazon SES client, which will make the service call with the supplied AWS credentials.
            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    //  .withCredentials(credentialsProvider)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your production
                    // access status, sending limits, and Amazon SES identity-related settings are specific to a given
                    // AWS region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using
                    // the US East (N. Virginia) region. Examples of other regions that Amazon SES supports are US_WEST_2
                    // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html
                    .withRegion("us-east-1")
                    .build();

            // Send the email.
            client.sendEmail(request);
            System.out.println("Email sent!");

        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
    }

    private String getMailBodyFromContact(Application contact) {

        StringBuilder sb = new StringBuilder();
        sb.append("App Contact name:\t\t");
        sb.append(contact.getFullName());
        sb.append("\n");
        sb.append("App Contact phone Number: \t");
        sb.append(contact.getPhoneNumber());
        sb.append("\n");
        sb.append("App Contact email: \t");
        sb.append(contact.getEmail());
        sb.append("\n");
        sb.append("App Message: \t");
        sb.append(contact.getMessage());
        sb.append("\n");
        sb.append("AppContact linkedin: \t");
        sb.append(contact.getLinkedin());
        sb.append("\n");
        return sb.toString();
    }

}