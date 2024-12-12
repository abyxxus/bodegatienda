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

import com.edu.eu.entity.cliente;
import com.edu.eu.service.IclienteService;

@RestController
public class clienteController {

	@Autowired
	IclienteService service;
	
	@PostMapping(value = "cliente-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<cliente>> postcliente(@RequestBody cliente cliente){
		
		List<cliente> listcliente = service.addcliente(cliente);
		
		return new ResponseEntity<List<cliente>>(listcliente, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "cliente-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<cliente>> getAllcliente(){
		
		List<cliente> listcliente = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listcliente.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<cliente>>(listcliente, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "cliente-update")
	public ResponseEntity<cliente> putcliente(@RequestBody cliente cliente){
		
		return new ResponseEntity<cliente>(service.updatecliente(cliente), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "cliente-id")
	public ResponseEntity<cliente> getIdcliente(@RequestParam("cedula") int cedula){
		
		return new ResponseEntity<cliente>(service.findIdcliente(cedula), HttpStatus.ACCEPTED);
		
	}
	
}
