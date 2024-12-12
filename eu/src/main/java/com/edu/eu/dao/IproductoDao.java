package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.producto;

public interface IproductoDao {

	List<producto> guardarproducto(producto producto);
	producto actualizarproducto(producto producto);
	
	List<producto> listacompleta();
	producto busquedaPorId(int id);

	
}

