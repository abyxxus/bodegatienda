package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.producto;
import com.edu.eu.jpa.IproductoJpa;

@Repository
public class productoDao implements IproductoDao{

	@Autowired
	IproductoJpa jpa;
	
	@Override
	public List<producto> guardarproducto(producto producto) {
		jpa.save(producto);
		return listacompleta();
	}

	@Override
	public producto actualizarproducto(producto producto) {
		return jpa.save(producto);
	}

	@Override
	public List<producto> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public producto busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

}
