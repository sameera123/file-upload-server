package com.codesetlabs.rest.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codesetlabs.model.FileDetails;
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
	
	@RequestMapping(method =RequestMethod.POST,value = "/upload")
	public FileDetails handleFileUpload(@RequestParam("name")String name,@RequestParam("file") MultipartFile file,RedirectAttributes attributes){
		
	
		
		if(!file.isEmpty()){
			try {
				BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(new File(""+"files/"+file.getOriginalFilename())));
				
				FileCopyUtils.copy(file.getInputStream(), stream);
				System.out.println(file.getOriginalFilename());
				System.out.println(file.getName());
				System.out.println(file.getContentType());
				//System.out.println(file.getOriginalFilename());
				stream.close();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new FileDetails(counter.incrementAndGet(), name,dateFormat.format(date).toString(), file.getSize());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
		return null;
		
		
	}
	
	
	
	
	
}
