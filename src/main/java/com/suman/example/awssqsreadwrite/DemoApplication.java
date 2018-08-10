package com.suman.example.awssqsreadwrite;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("Application started *************");
//		Scanner scanner = new Scanner(System.in);

	    //  prompt for the user's name
	    System.out.print("Type a Message to be put on to AWS SQS queue :- \n");

	    // get their input as a String
//	    String message = scanner.nextLine();

	    
		SpringApplication.run(DemoApplication.class, args);
		/*ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		ReadFromAwsSqs readBean = context.getBean(ReadFromAwsSqs.class);
		readBean.sendMessageToSqs("First Deployment on EC2!!!");*/
//		scanner.close();
	}

}
