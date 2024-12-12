package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IproductoDao;
import com.edu.eu.entity.producto;

@Service
public class productoService implements IproductoService{

	@Autowired
	IproductoDao dao;
	
	@Override
	public List<producto> addproducto(producto producto) {
		return dao.guardarproducto(producto);
	}

	@Override
	public producto updateproducto(producto producto) {
		int id_producto = producto.getIdproducto();
		
		if(!findIdproducto(id_producto).equals(null)) {
			
			return dao.actualizarproducto(producto);
			
		}
		
		return null;
	}

	@Override
	public List<producto> listAll() {
		return dao.listacompleta();
	}

	@Override
	public producto findIdproducto(int id) {
		return dao.busquedaPorId(id);
	}

}
