package com.career.opportunities.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.SubscribeResponse;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SnsConfig {

    @Inject
    SnsClient snsClient;

    @ConfigProperty(name = "topic.arn")
    String topicArn;


    public void sendEmail(String subject, String bodyText) {
        snsClient.publish(builder -> builder.topicArn(topicArn).message(bodyText).subject(subject));
    }

    public void subscribe(String userEmail) {
    	SubscribeResponse response = snsClient.subscribe(s -> s.topicArn(topicArn).protocol("email").endpoint(userEmail));
    }
}
