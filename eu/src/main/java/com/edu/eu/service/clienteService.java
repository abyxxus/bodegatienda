package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IclienteDao;
import com.edu.eu.entity.cliente;

@Service
public class clienteService implements IclienteService{

	@Autowired
	IclienteDao dao;
	
	@Override
	public List<cliente> addcliente(cliente cliente) {
		return dao.guardarcliente(cliente);
	}

	@Override
	public cliente updatecliente(cliente cliente) {
		int id_cliente = cliente.getCedula();
		
		if(!findIdcliente(id_cliente).equals(null)) {
			
			return dao.actualizarcliente(cliente);
			
		}
		
		return null;
	}

	@Override
	public List<cliente> listAll() {
		return dao.listacompleta();
	}

	@Override
	public cliente findIdcliente(int id) {
		return dao.busquedaPorId(id);
	}

}
