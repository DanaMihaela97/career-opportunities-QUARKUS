package com.career.opportunities.config;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class SnsClientProducer {
    @ConfigProperty(name = "quarkus.amazon.sns.region")
    String region;

    @ConfigProperty(name = "quarkus.amazon.sns.access-key-id")
    String accessKeyId;

    @ConfigProperty(name = "quarkus.amazon.sns.secret-access-key")
    String secretAccessKey;
    @Produces
    @ApplicationScoped
    public SnsClient produceSnsClient() {
        return SnsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();
    }
}
