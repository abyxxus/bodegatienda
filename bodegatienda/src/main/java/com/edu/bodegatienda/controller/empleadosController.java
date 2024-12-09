package com.edu.bodegatienda.controller;

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

import com.edu.bodegatienda.entity.empleados;
import com.edu.bodegatienda.service.IempleadosService;


@RestController
public class empleadosController {

	@Autowired
	IempleadosService service;
	
	@PostMapping(value = "emp-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<empleados>> postempleados(@RequestBody empleados empleado){
		
		List<empleados> listEmpleados = service.addEmpleado(empleado);
		
		return new ResponseEntity<List<empleados>>(listEmpleados, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "emp-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<empleados>> getAllempleados(){
		
		List<empleados> listEmpleados = service.listAll();
		
		HttpHeaders headears = new HttpHeaders();
		
		headears.add("can't datos", String.valueOf(listEmpleados.size()));
		headears.add("test", "valor");
		
		return new ResponseEntity<List<empleados>>(listEmpleados, headears, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "emp-up")
	public ResponseEntity<empleados> putEmpleados(@RequestBody empleados empleado){
		
		return new ResponseEntity<empleados>(service.upEmpleado(empleado), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "emp-id")
	public ResponseEntity<empleados> getIdEmpleados(@RequestParam("id") int id){
		
		return null;
		
	}
	
	@GetMapping(value = "emp-email")
	public ResponseEntity<empleados> getByNombre(@RequestParam("nombre") String nombre){
		return new ResponseEntity<empleados>(service.findNombreEmpleado(nombre), HttpStatus.ACCEPTED);
		
	}
	
}
