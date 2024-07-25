package com.career.opportunities.config;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SnsPublisher {

    private final SnsClient snsClient;

    @Inject
    public SnsPublisher(SnsClient snsClient) {
        this.snsClient = snsClient;
    }
    public void sendEmail(String subject, String bodyText) {
        PublishRequest request = PublishRequest.builder()
                .topicArn("arn:aws:sns:us-east-1:211125574560:quarkus-sns")
                .subject(subject)
                .message(bodyText)
                .build();
        snsClient.publish(request);
    }

    public void subscribe(String userEmail) {
        SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                .topicArn("arn:aws:sns:us-east-1:211125574560:quarkus-sns")
                .protocol("email")
                .endpoint(userEmail)
                .build();
        snsClient.subscribe(subscribeRequest);
    }
}
