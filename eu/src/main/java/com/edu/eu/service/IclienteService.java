package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.cliente;

public interface IclienteService {

	List<cliente> addcliente(cliente cliente);
	cliente updatecliente(cliente cliente);
	
	List<cliente> listAll();
	cliente findIdcliente(int id);
	
}
