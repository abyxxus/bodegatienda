package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.sede;
import com.edu.eu.jpa.ISedeJpa;

@Repository
public class sedeDao implements ISedeDao{

	@Autowired
	ISedeJpa jpa;
	
	@Override
	public List<sede> guardarsede(sede sede) {
		
		jpa.save(sede);
		
		return listacompleta();
	}

	@Override
	public sede actualizarsede(sede sede) {
		return jpa.save(sede);
	}

	@Override
	public List<sede> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public sede busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public sede busquedaPorDisponibilidad(boolean estado) {
		return jpa.findBySedeDispo(estado);
	}

}
