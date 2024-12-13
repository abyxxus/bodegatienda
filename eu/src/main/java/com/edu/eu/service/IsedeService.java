package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.sede;

public interface ISedeService {

	List<sede> addSede(sede sede);
	sede upsede(sede sede);
	List<sede> lisAll();
	sede findIdSede(int id);
	sede findEstadoSede(boolean estado);
	
}
