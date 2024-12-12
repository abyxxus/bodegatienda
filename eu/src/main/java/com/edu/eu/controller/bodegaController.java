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

import com.edu.eu.entity.bodega;
import com.edu.eu.service.IbodegaService;

@RestController
public class bodegaController {

	@Autowired
	IbodegaService service;
	
	@PostMapping(value = "bodega-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<bodega>> postbodega(@RequestBody bodega bodega){
		
		List<bodega> listbodega = service.addbodega(bodega);
		
		return new ResponseEntity<List<bodega>>(listbodega, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "bodega-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<bodega>> getAllbodega(){
		
		List<bodega> listbodega = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listbodega.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<bodega>>(listbodega, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "bodega-update")
	public ResponseEntity<bodega> putbodega(@RequestBody bodega bodega){
		
		return new ResponseEntity<bodega>(service.updatebodega(bodega), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "bodega-id")
	public ResponseEntity<bodega> getIdbodega(@RequestParam("idbodega") int idbodega){
		
		return new ResponseEntity<bodega>(service.findIdbodega(idbodega), HttpStatus.ACCEPTED);
		
	}
	
}
