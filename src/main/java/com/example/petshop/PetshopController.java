package com.example.petshop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class PetshopController {

	private String getLocalDateTime()
	{
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  return dtf.format(now);
	}
	
	@RequestMapping(path = "/getnumberofdogs", method = RequestMethod.GET)
	public String getNumberOfDogs() {
		return "We have 5 dogs. " + getLocalDateTime();
	}
	
	@RequestMapping(path = "/getnumberofcats", method = RequestMethod.GET)
	public String anotherGet() {
		return "We have 3 cats. " + getLocalDateTime();
	}
	
	@RequestMapping(path = "/submitrequest", method = RequestMethod.POST)
    public String postBody(@RequestBody String request) {
        return "We received your request at "+getLocalDateTime()+": " + request;
    }

}
