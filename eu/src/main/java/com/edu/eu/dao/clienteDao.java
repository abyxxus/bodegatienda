package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.cliente;
import com.edu.eu.jpa.IclienteJpa;


@Repository
public class clienteDao implements IclienteDao{

	@Autowired
	IclienteJpa jpa;
	
	@Override
	public List<cliente> guardarcliente(cliente cliente) {
		jpa.save(cliente);
		return listacompleta();
	}

	@Override
	public cliente actualizarcliente(cliente cliente) {
		return jpa.save(cliente);
	}

	@Override
	public List<cliente> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public cliente busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

}
