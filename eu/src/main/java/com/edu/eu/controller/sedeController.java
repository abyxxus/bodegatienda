package com.edu.eu.controller;

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
import com.edu.eu.service.ISedeService;
import java.util.List;

@RestController
public class sedeController {

	@Autowired
	ISedeService service;
	
	
	@PostMapping(value = "sedeSave", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<sede>> postSede(@RequestBody sede sede){
		
		List<sede> listSede = service.addSede(sede);
		
		return new ResponseEntity<List<sede>>(listSede, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping(value = "sedeAll", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<sede>> getAllSede(){
		
		List<sede> listSede = service.lisAll();
		
		HttpHeaders head = new HttpHeaders();
		
		head.add("can´t sede", String.valueOf(listSede.size()));
		head.add("test", "valor");
		
		return new ResponseEntity<List<sede>>(listSede, head, HttpStatus.OK);
		
	}
	
	
	@PutMapping(value = "sedeupdate")
	public ResponseEntity<sede> updateSede(@RequestBody sede sede){
		
		return new ResponseEntity<sede>(service.upsede(sede), HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping(value = "sedeId")
	public ResponseEntity<sede> getIdSede(@RequestParam("idSede") int id){
		
		return new ResponseEntity<sede>(service.findIdSede(id), HttpStatus.FOUND);
		
	}
	
	
	@GetMapping(value = "sedeDispo")
	public ResponseEntity<sede> getByDispo(@RequestParam("estado") boolean estado){
		return new ResponseEntity<sede>(service.findEstadoSede(estado), HttpStatus.ACCEPTED);
		
	}
	
}
