package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.cliente;

public interface IclienteDao {
	
	List<cliente> guardarcliente(cliente cliente);
	cliente actualizarcliente(cliente cliente);

	List<cliente> listacompleta();
	cliente busquedaPorId(int id);

}
