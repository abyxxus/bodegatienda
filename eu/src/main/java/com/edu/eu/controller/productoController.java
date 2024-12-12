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

import com.edu.eu.entity.producto;
import com.edu.eu.service.IproductoService;

@RestController
public class productoController {

	@Autowired
	IproductoService service;
	
	@PostMapping(value = "producto-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<producto>> postproducto(@RequestBody producto producto){
		
		List<producto> listproducto = service.addproducto(producto);
		
		return new ResponseEntity<List<producto>>(listproducto, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "producto-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<producto>> getAllproducto(){
		
		List<producto> listproducto = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listproducto.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<producto>>(listproducto, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "producto-update")
	public ResponseEntity<producto> putproducto(@RequestBody producto producto){
		
		return new ResponseEntity<producto>(service.updateproducto(producto), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "producto-id")
	public ResponseEntity<producto> getIdproducto(@RequestParam("idproducto") int idproducto){
		
		return new ResponseEntity<producto>(service.findIdproducto(idproducto), HttpStatus.ACCEPTED);
		
	}
	
}
