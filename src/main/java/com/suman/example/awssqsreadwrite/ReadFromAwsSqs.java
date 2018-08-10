/**
 * 
 */
package com.suman.example.awssqsreadwrite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.suman.example.awssqsreadwrite.configuration.AwsJmsConfiguration;

/**
 * @author Suman
 *
 */


@Component
public class ReadFromAwsSqs {
	
	@Autowired
	AwsJmsConfiguration awsJmsConfig;

	public void sendMessageToSqs(String message) {
		SendMessageRequest sendMessageReq = new SendMessageRequest("east-sumantestsqs-1", message);
		
		// create the SQS client to drop the message
		AmazonSQS sqsClient = awsJmsConfig.sqsClientBuilder();
		
		System.out.println("## Message is being sent to SQS .....  " +sendMessageReq.getMessageBody());
		
		sqsClient.sendMessage(sendMessageReq);
		
		System.out.println("## Message sent to SQS successfully!!!" +sendMessageReq.getMessageBody());
	}
}
