package com.codesetlabs.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesetlabs.model.Greeting;

@RestController
public class FileUploadController {

	private static final String template = "Hello, %s!";
	private AtomicLong counter = new AtomicLong();
	
	
	//Hello world end point
	@RequestMapping("/greeting")
	public Greeting sayHello(@RequestParam(value="name",defaultValue = "world")String name){
			return new Greeting(counter.incrementAndGet(),name);
		
	}
}
