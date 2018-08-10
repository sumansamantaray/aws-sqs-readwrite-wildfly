/**
 * 
 */
package com.suman.example.awssqsreadwrite.configuration;

import javax.jms.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.stereotype.Component;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

/**
 * @author Suman
 *
 */
@Configuration
@EnableJms
@Component
public class AwsJmsConfiguration {
	
	final ClientConfiguration clientConfiguration = new ClientConfiguration();
	
	SQSConnectionFactory connectionFactory =
			/*SQSConnectionFactory.builder()
            .withRegion(Region.getRegion(Regions.US_EAST_1))
            .withAWSCredentialsProvider(new DefaultAWSCredentialsProviderChain())
            .build(); */
			new SQSConnectionFactory(
			        new ProviderConfiguration(),
			        AmazonSQSClientBuilder.standard()
			        //.withClientConfiguration(clientConfiguration) // This is removed for EC2 deployment. Dont need on EC2
			        .withRegion(Regions.US_EAST_2)
			        .withCredentials(new DefaultAWSCredentialsProviderChain())
			        );
			/*new SQSConnectionFactory(
			        new ProviderConfiguration(),
			        AmazonSQSClientBuilder.defaultClient()
			        );*/


    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        System.out.println("jmsListenerContainerFactory is being called...");
        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("3-10");
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate() {
    	System.out.println("defaultJmsTemplate is being called...");
        return new JmsTemplate(this.connectionFactory);
    }
    
   
   @Bean
   public AmazonSQS sqsClientBuilder() {
	   
	   AmazonSQS sqs = AmazonSQSClientBuilder.standard()
               .withClientConfiguration(clientConfiguration)
               .withRegion(Regions.US_EAST_2)
               .withCredentials(new DefaultAWSCredentialsProviderChain())                   
               .build();
	   
	   return sqs;
   }
}
