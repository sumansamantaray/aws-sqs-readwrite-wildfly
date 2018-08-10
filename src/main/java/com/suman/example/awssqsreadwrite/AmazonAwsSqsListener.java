/**
 * 
 */
package com.suman.example.awssqsreadwrite;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Suman
 *
 */
@Component
@EnableJms
public class AmazonAwsSqsListener {
	
//	@JmsListener(destination="east-sumantestsqs-1")
	public void messageListener(TextMessage textMessage) throws Exception {
		
		try {
			System.out.println("Message read from SQS ###### "+textMessage.getText());
		} catch (JMSException jmsExp) {
			
		}
		if ("Throw Exception".equalsIgnoreCase(textMessage.getText())) {
			throw new Exception();
		}
		
	}

}
