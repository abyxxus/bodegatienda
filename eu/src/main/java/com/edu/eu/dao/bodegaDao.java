package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.bodega;
import com.edu.eu.jpa.IbodegaJpa;

@Repository
public class bodegaDao implements IbodegaDao{

	@Autowired
	IbodegaJpa jpa;
	
	@Override
	public List<bodega> guardarbodega(bodega bodega) {
		jpa.save(bodega);
		return listacompleta();
	}

	@Override
	public bodega actualizarbodega(bodega bodega) {
		return jpa.save(bodega);
	}

	@Override
	public List<bodega> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public bodega busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

}
