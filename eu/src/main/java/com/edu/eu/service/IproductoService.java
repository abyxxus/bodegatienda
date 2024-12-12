package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.producto;

public interface IproductoService {

	List<producto> addproducto(producto producto);
	producto updateproducto(producto producto);
	
	List<producto> listAll();
	producto findIdproducto(int id);
	
}
