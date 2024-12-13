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

import com.edu.eu.entity.sede;
import com.edu.eu.service.IsedeService;

@RestController
public class sedeController {

	@Autowired
	IsedeService service;
	
	@PostMapping(value = "sede-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<sede>> postsede(@RequestBody sede sede){
		
		List<sede> listsede = service.addsede(sede);
		
		return new ResponseEntity<List<sede>>(listsede, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "sede-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<sede>> getAllsede(){
		
		List<sede> listsede = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listsede.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<sede>>(listsede, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "sede-update")
	public ResponseEntity<sede> putsede(@RequestBody sede sede){
		
		return new ResponseEntity<sede>(service.updatesede(sede), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "sede-id")
	public ResponseEntity<sede> getIdsede(@RequestParam("id_Sede") int id_Sede){
		
		return new ResponseEntity<sede>(service.findIdsede(id_Sede), HttpStatus.ACCEPTED);
		
	}
	
}
