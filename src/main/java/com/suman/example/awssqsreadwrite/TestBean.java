/**
 * 
 */
package com.suman.example.awssqsreadwrite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
@Component
public class TestBean {
	
	@Value("${check.profile.value}")
	String testPropVal;
	
	@Value("${application.name}")
	String applicationName;
	
	
	/*@Bean
	public String testMethod() {
		System.out.println("testMethod called ####################"+applicationName);
		System.out.println("testMethod called $$$$$$$$$$$$$$$$$$$$"+testPropVal);

		try {
			AmazonSQS sqs = AmazonSQSClientBuilder.standard()
	                 .withCredentials(new DefaultAWSCredentialsProviderChain())
	                 .withRegion(Regions.US_EAST_1)
	                 .build();

			AmazonSQS sqs = AmazonSQSClientBuilder.standard()
			                .withClientConfiguration(config)
			                .withRegion(Regions.US_EAST_1)
			                .withCredentials(new DefaultAWSCredentialsProviderChain())                   
			                .build();
			
			System.out.println("Creating a new SQS queue called MyQueue.\n");
//            CreateQueueRequest createQueueRequest = new CreateQueueRequest("MyQueue");
//            String myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();
            System.out.println("New SQS queue called MyQueue got created.\n");
            
            // List queues
            System.out.println("Listing all queues in your account.\n");
            for (String queueUrl : sqs.listQueues().getQueueUrls()) {
                System.out.println("  QueueUrl: " + queueUrl);
            }
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		 
		return null;
	}*/
}