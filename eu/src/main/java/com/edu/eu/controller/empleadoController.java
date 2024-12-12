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

import com.edu.eu.entity.empleado;
import com.edu.eu.service.IempleadoService;

@RestController
public class empleadoController {

	@Autowired
	IempleadoService service;
	
	@PostMapping(value = "empleado-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<empleado>> postempleado(@RequestBody empleado empleado){
		
		List<empleado> listempleado = service.addempleado(empleado);
		
		return new ResponseEntity<List<empleado>>(listempleado, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "empleado-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<empleado>> getAllempleado(){
		
		List<empleado> listempleado = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listempleado.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<empleado>>(listempleado, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "empleado-update")
	public ResponseEntity<empleado> putempleado(@RequestBody empleado empleado){
		
		return new ResponseEntity<empleado>(service.updateempleado(empleado), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "empleado-id")
	public ResponseEntity<empleado> getIdempleado(@RequestParam("cedula") int cedula){
		
		return new ResponseEntity<empleado>(service.findIdempleado(cedula), HttpStatus.ACCEPTED);
		
	}
	
}
