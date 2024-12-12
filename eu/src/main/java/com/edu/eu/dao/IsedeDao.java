package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.sede;

public interface IsedeDao {
	
	List<sede> guardarsede(sede sede);
	sede actualizarsede(sede sede);
	
	List<sede> listacompleta();
	sede busquedaPorId(int id);

}
