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

import com.edu.eu.entity.pedido;
import com.edu.eu.service.IpedidoService;

@RestController
public class pedidoController {

	@Autowired
	IpedidoService service;
	
	@PostMapping(value = "pedido-save", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<pedido>> postpedido(@RequestBody pedido pedido){
		
		List<pedido> listpedido = service.addpedido(pedido);
		
		return new ResponseEntity<List<pedido>>(listpedido, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "pedido-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<pedido>> getAllpedido(){
		
		List<pedido> listpedido = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listpedido.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<pedido>>(listpedido, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "pedido-update")
	public ResponseEntity<pedido> putpedido(@RequestBody pedido pedido){
		
		return new ResponseEntity<pedido>(service.updatepedido(pedido), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "pedido-id")
	public ResponseEntity<pedido> getIdpedido(@RequestParam("id_pedido") int idpedido){
		
		return new ResponseEntity<pedido>(service.findIdpedido(idpedido), HttpStatus.ACCEPTED);
		
	}
	
}
