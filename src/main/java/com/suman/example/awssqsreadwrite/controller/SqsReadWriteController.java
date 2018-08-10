package com.suman.example.awssqsreadwrite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suman.example.awssqsreadwrite.ReadFromAwsSqs;

/**
 * 
 */

/**
 * @author Suman
 *
 */
@RestController
public class SqsReadWriteController {
	
	@Autowired
	ReadFromAwsSqs readFromSqs;

	@RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
 
		readFromSqs.sendMessageToSqs(name);
		return "Message sent to SQS: " + name;
    }
	
}
