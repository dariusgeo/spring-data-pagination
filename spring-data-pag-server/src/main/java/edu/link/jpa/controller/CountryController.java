package edu.link.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.link.jpa.model.Country;
import edu.link.jpa.service.CountryService;

@RestController
@RequestMapping(path="/api/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Country>> getAll(){
		
		List<Country> questions = countryService.readAllCountries();
		
		if(questions.isEmpty()){
		   return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		
	    return new ResponseEntity<List<Country>>(questions, HttpStatus.OK);			
	}

}
