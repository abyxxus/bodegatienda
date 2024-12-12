package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.sede;
import com.edu.eu.jpa.IsedeJpa;

@Repository
public class sedeDao implements IsedeDao{

	@Autowired
	IsedeJpa jpa;
	
	
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
	public sede busquedaPorId(int id_sede) {
		return jpa.findById(id_sede).orElse(null);
	}

}
