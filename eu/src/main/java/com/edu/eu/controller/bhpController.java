package com.edu.eu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eu.entity.bhp;
import com.edu.eu.service.IbhpService;

@RestController
public class bhpController {

	@Autowired
	IbhpService service;
	
	@PostMapping(value = "bhp-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<bhp>> postbhp(@RequestBody bhp bhp){
		
		List<bhp> listbhp = service.addbhp(bhp);
		
		return new ResponseEntity<List<bhp>>(listbhp, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "bhp-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<bhp>> getAllbhp(){
		
		List<bhp> listbhp = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listbhp.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<bhp>>(listbhp, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "bhp-update")
	public ResponseEntity<bhp> putbhp(@RequestBody bhp bhp){
		
		return new ResponseEntity<bhp>(service.updatebhp(bhp), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "bhp-id")
	public ResponseEntity<bhp> getIdbhp(@RequestParam("id") int id){
		
		return new ResponseEntity<bhp>(service.findIdbhp(id), HttpStatus.ACCEPTED);
		
	}
	
}
